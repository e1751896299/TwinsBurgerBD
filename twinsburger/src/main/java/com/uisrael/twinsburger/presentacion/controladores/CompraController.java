package com.uisrael.twinsburger.presentacion.controladores;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.dominio.entidades.EstadoPedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.twinsburger.presentacion.dto.request.CompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CompraResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final IProductoJpaRepositorio productos;
    private final IComboJpaRepositorio combos;
    private final IClienteJpaRepositorio clientes;
    private final IPedidoJpaRepositorio pedidos;
    private final IDetallePedidoJpaRepositorio detalles;

    public CompraController(IProductoJpaRepositorio productos, IComboJpaRepositorio combos,
            IClienteJpaRepositorio clientes, IPedidoJpaRepositorio pedidos,
            IDetallePedidoJpaRepositorio detalles) {
        this.productos = productos; this.combos = combos; this.clientes = clientes;
        this.pedidos = pedidos; this.detalles = detalles;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CompraResponseDto comprar(@Valid @RequestBody CompraRequestDto compra) {
        var lineas = new ArrayList<LineaCompra>();
        BigDecimal total = BigDecimal.ZERO;

        for (var item : compra.getItems()) {
            if (item.getCantidad() < 1 || (item.getIdProducto() <= 0 && item.getIdCombo() <= 0))
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Artículo inválido");

            if (item.getIdCombo() > 0) {
                ComboEntity combo = combos.findById(item.getIdCombo()).filter(ComboEntity::isComboEstado)
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Combo no encontrado"));
                for (var componente : combo.getProductos()) {
                    int requerido = componente.getCantidad() * item.getCantidad();
                    ProductoEntity producto = productos.buscarPorIdParaCompra(componente.getFkProducto().getIdProducto())
                            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
                    if (!producto.isProdEstado() || producto.getProdStock() < requerido)
                        throw new ResponseStatusException(HttpStatus.CONFLICT,
                                "Stock insuficiente para el combo " + combo.getComboNombre());
                    producto.setProdStock(producto.getProdStock() - requerido);
                    productos.save(producto);
                }
                BigDecimal subtotal = combo.getComboPrecio().multiply(BigDecimal.valueOf(item.getCantidad()));
                total = total.add(subtotal);
                lineas.add(new LineaCompra(null, combo, item.getCantidad(), combo.getComboPrecio(), subtotal));
            } else {
                ProductoEntity producto = productos.buscarPorIdParaCompra(item.getIdProducto())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
                if (!producto.isProdEstado() || producto.getProdStock() < item.getCantidad() || producto.getProdPrecio() == null)
                    throw new ResponseStatusException(HttpStatus.CONFLICT, "Producto sin stock o precio");
                producto.setProdStock(producto.getProdStock() - item.getCantidad());
                productos.save(producto);
                BigDecimal subtotal = producto.getProdPrecio().multiply(BigDecimal.valueOf(item.getCantidad()));
                total = total.add(subtotal);
                lineas.add(new LineaCompra(producto, null, item.getCantidad(), producto.getProdPrecio(), subtotal));
            }
        }

        var cliente = clientes.findById(compra.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        PedidoEntity pedido = new PedidoEntity();
        pedido.setPedidoEstadoProceso(EstadoPedido.PENDIENTE);
        pedido.setPedidoFechaPedido(Date.valueOf(LocalDate.now()));
        pedido.setPedidoHoraRetiro(LocalTime.now().withSecond(0).withNano(0));
        pedido.setPedidoEstado(true); pedido.setPedidoTotal(total);
        pedido.setPedidoDescripcion("Compra desde el menú web"); pedido.setPedidoEntrega(false);
        pedido.setFkCliente(cliente); pedido = pedidos.save(pedido);

        for (var linea : lineas) {
            DetallePedidoEntity detalle = new DetallePedidoEntity();
            detalle.setDetalleCantidad(linea.cantidad()); detalle.setDetallePrecio(linea.precio());
            detalle.setDetalleSubtotal(linea.subtotal()); detalle.setDetalleEstado(true);
            detalle.setFkPedido(pedido); detalle.setFkProducto(linea.producto()); detalle.setFkCombo(linea.combo());
            detalles.save(detalle);
        }
        return new CompraResponseDto("Pedido " + pedido.getIdPedido() + " registrado correctamente", total);
    }

    private record LineaCompra(ProductoEntity producto, ComboEntity combo, int cantidad,
            BigDecimal precio, BigDecimal subtotal) { }
}
