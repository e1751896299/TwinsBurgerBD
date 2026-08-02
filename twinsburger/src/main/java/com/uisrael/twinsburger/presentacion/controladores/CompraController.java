package com.uisrael.twinsburger.presentacion.controladores;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.twinsburger.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.twinsburger.presentacion.dto.request.CompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CompraResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    private final IProductoJpaRepositorio productoRepositorio;
    private final IClienteJpaRepositorio clienteRepositorio;
    private final IPedidoJpaRepositorio pedidoRepositorio;
    private final IDetallePedidoJpaRepositorio detalleRepositorio;

    public CompraController(IProductoJpaRepositorio productoRepositorio,
            IClienteJpaRepositorio clienteRepositorio, IPedidoJpaRepositorio pedidoRepositorio,
            IDetallePedidoJpaRepositorio detalleRepositorio) {
        this.productoRepositorio = productoRepositorio;
        this.clienteRepositorio = clienteRepositorio;
        this.pedidoRepositorio = pedidoRepositorio;
        this.detalleRepositorio = detalleRepositorio;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    public CompraResponseDto comprar(@Valid @RequestBody CompraRequestDto compra) {
        BigDecimal total = BigDecimal.ZERO;
        var productosCompra = new java.util.ArrayList<ProductoEntity>();

        for (var item : compra.getItems()) {
            ProductoEntity producto = productoRepositorio.buscarPorIdParaCompra(item.getIdProducto())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Producto no encontrado: " + item.getIdProducto()));

            if (!producto.isProdEstado() || producto.getProdStock() < item.getCantidad()) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "Stock insuficiente para " + producto.getProdNombre());
            }
            if (producto.getProdPrecio() == null) {
                throw new ResponseStatusException(HttpStatus.CONFLICT,
                        "El producto no tiene precio: " + producto.getProdNombre());
            }

            producto.setProdStock(producto.getProdStock() - item.getCantidad());
            productoRepositorio.save(producto);
            total = total.add(producto.getProdPrecio().multiply(BigDecimal.valueOf(item.getCantidad())));
            productosCompra.add(producto);
        }

        var cliente = clienteRepositorio.findById(compra.getIdCliente())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado"));
        PedidoEntity pedido = new PedidoEntity();
        pedido.setPedidoFechaPedido(Date.valueOf(LocalDate.now()));
        pedido.setPedidoHoraRetiro(LocalTime.now().withSecond(0).withNano(0));
        pedido.setPedidoEstado(true);
        pedido.setPedidoTotal(total);
        pedido.setPedidoDescripcion("Compra desde el menú web");
        pedido.setPedidoEntrega(false);
        pedido.setFkCliente(cliente);
        pedido = pedidoRepositorio.save(pedido);

        for (int indice = 0; indice < compra.getItems().size(); indice++) {
            var item = compra.getItems().get(indice);
            var producto = productosCompra.get(indice);
            DetallePedidoEntity detalle = new DetallePedidoEntity();
            detalle.setDetalleCantidad(item.getCantidad());
            detalle.setDetallePrecio(producto.getProdPrecio());
            detalle.setDetalleSubtotal(producto.getProdPrecio().multiply(BigDecimal.valueOf(item.getCantidad())));
            detalle.setDetalleEstado(true);
            detalle.setFkPedido(pedido);
            detalle.setFkProducto(producto);
            detalleRepositorio.save(detalle);
        }

        return new CompraResponseDto("Pedido " + pedido.getIdPedido() + " registrado correctamente", total);
    }
}
