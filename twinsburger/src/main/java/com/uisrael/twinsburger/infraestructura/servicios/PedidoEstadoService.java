package com.uisrael.twinsburger.infraestructura.servicios;

import java.util.EnumSet;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.dominio.entidades.EstadoPedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

@Service
public class PedidoEstadoService {

    private final IPedidoJpaRepositorio pedidoRepositorio;
    private final IDetallePedidoJpaRepositorio detalleRepositorio;
    private final IProductoJpaRepositorio productoRepositorio;

    public PedidoEstadoService(
            IPedidoJpaRepositorio pedidoRepositorio,
            IDetallePedidoJpaRepositorio detalleRepositorio,
            IProductoJpaRepositorio productoRepositorio) {

        this.pedidoRepositorio = pedidoRepositorio;
        this.detalleRepositorio = detalleRepositorio;
        this.productoRepositorio = productoRepositorio;
    }

    @Transactional
    public PedidoEntity cambiarEstado(
            int idPedido,
            EstadoPedido nuevoEstado) {

        PedidoEntity pedido =
                pedidoRepositorio.findById(idPedido)
                    .orElseThrow(() ->
                        new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Pedido no encontrado"
                        )
                    );

        EstadoPedido estadoActual =
                pedido.getPedidoEstadoProceso();

        // Permite trabajar con pedidos antiguos
        // creados antes de añadir la nueva columna.
        if (estadoActual == null) {
            estadoActual = EstadoPedido.PENDIENTE;
        }

        if (estadoActual == nuevoEstado) {
            return pedido;
        }

        validarTransicion(
                estadoActual,
                nuevoEstado
        );

        if (nuevoEstado == EstadoPedido.CANCELADO) {
            devolverStock(idPedido);
        }

        pedido.setPedidoEstadoProceso(nuevoEstado);

        return pedidoRepositorio.save(pedido);
    }

    private void validarTransicion(
            EstadoPedido actual,
            EstadoPedido nuevo) {

        boolean permitido = switch (actual) {

            case PENDIENTE ->
                EnumSet.of(
                    EstadoPedido.EN_PREPARACION,
                    EstadoPedido.CANCELADO
                ).contains(nuevo);

            case EN_PREPARACION ->
                EnumSet.of(
                    EstadoPedido.LISTO,
                    EstadoPedido.CANCELADO
                ).contains(nuevo);

            case LISTO ->
                nuevo == EstadoPedido.ENTREGADO;

            case ENTREGADO, CANCELADO ->
                false;
        };

        if (!permitido) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "No se puede cambiar de "
                    + actual
                    + " a "
                    + nuevo
            );
        }
    }

    private void devolverStock(int idPedido) {

        var detalles =
                detalleRepositorio
                    .obtenerDetallePedido(idPedido);

        for (var detalle : detalles) {
            if (detalle.getFkProducto() != null) {
                devolverProducto(detalle.getFkProducto().getIdProducto(), detalle.getDetalleCantidad());
            } else if (detalle.getFkCombo() != null) {
                for (var componente : detalle.getFkCombo().getProductos()) {
                    devolverProducto(componente.getFkProducto().getIdProducto(),
                            componente.getCantidad() * detalle.getDetalleCantidad());
                }
            }
        }
    }

    private void devolverProducto(int idProducto, int cantidad) {
        var producto = productoRepositorio.buscarPorIdParaCompra(idProducto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado"));
        producto.setProdStock(producto.getProdStock() + cantidad);
        productoRepositorio.save(producto);
    }
}
