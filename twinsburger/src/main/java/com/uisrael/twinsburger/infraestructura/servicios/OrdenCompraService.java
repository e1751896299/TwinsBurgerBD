package com.uisrael.twinsburger.infraestructura.servicios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraProductoEntity;
import com.uisrael.twinsburger.infraestructura.repositorios.IOrdenCompraJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.twinsburger.presentacion.dto.request.OrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.OrdenCompraProductoResponseDto;
import com.uisrael.twinsburger.presentacion.dto.response.OrdenCompraResponseDto;

@Service
public class OrdenCompraService {
    private final IOrdenCompraJpaRepositorio ordenCompraRepositorio;
    private final IProductoJpaRepositorio productoRepositorio;

    public OrdenCompraService(IOrdenCompraJpaRepositorio ordenCompraRepositorio, IProductoJpaRepositorio productoRepositorio) {
        this.ordenCompraRepositorio = ordenCompraRepositorio;
        this.productoRepositorio = productoRepositorio;
    }

    @Transactional(readOnly = true)
    public List<OrdenCompraResponseDto> listar() {
        return ordenCompraRepositorio.findByOcEstadoTrueOrderByOcFechaDesc().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public OrdenCompraResponseDto buscar(int id) { return toDto(buscarEntity(id)); }

    @Transactional
    public OrdenCompraResponseDto guardar(OrdenCompraRequestDto dto) {
        if (dto.getIdOrdenCompra() > 0) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "Una orden de compra ya registrada no se puede editar. Crea una nueva si necesitas corregirla.");
        }
        OrdenCompraEntity orden = new OrdenCompraEntity();
        orden.setOcFecha(dto.getOcFecha());
        orden.setOcProveedor(dto.getOcProveedor().trim());
        orden.setOcEstado(true);

        for (var item : dto.getProductos()) {
            var producto = productoRepositorio.buscarPorIdParaCompra(item.idProducto())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Producto no encontrado: " + item.idProducto()));

            OrdenCompraProductoEntity relacion = new OrdenCompraProductoEntity();
            relacion.setFkOrdenCompra(orden);
            relacion.setFkProducto(producto);
            relacion.setCantidad(item.cantidad());
            relacion.setPrecioUnitario(item.precioUnitario());
            orden.getProductos().add(relacion);

            producto.setProdStock(producto.getProdStock() + item.cantidad());
            productoRepositorio.save(producto);
        }
        return toDto(ordenCompraRepositorio.save(orden));
    }

    @Transactional
    public void eliminar(int id) {
        OrdenCompraEntity orden = buscarEntity(id);
        orden.setOcEstado(false);
        ordenCompraRepositorio.save(orden);
    }

    private OrdenCompraEntity buscarEntity(int id) {
        return ordenCompraRepositorio.findById(id).filter(OrdenCompraEntity::isOcEstado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden de compra no encontrada"));
    }

    private OrdenCompraResponseDto toDto(OrdenCompraEntity orden) {
        var productos = orden.getProductos().stream()
                .map(i -> new OrdenCompraProductoResponseDto(i.getFkProducto().getIdProducto(),
                        i.getFkProducto().getProdNombre(), i.getCantidad(), i.getPrecioUnitario()))
                .toList();
        return new OrdenCompraResponseDto(orden.getIdOrdenCompra(), orden.getOcFecha(), orden.getOcProveedor(), productos);
    }
}
