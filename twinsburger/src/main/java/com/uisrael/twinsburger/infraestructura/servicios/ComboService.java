package com.uisrael.twinsburger.infraestructura.servicios;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboProductoEntity;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;
import com.uisrael.twinsburger.presentacion.dto.request.ComboRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboProductoResponseDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboResponseDto;

@Service
public class ComboService {
    private final IComboJpaRepositorio comboRepositorio;
    private final IProductoJpaRepositorio productoRepositorio;
    private final IDetallePedidoJpaRepositorio detalleRepositorio;

    public ComboService(IComboJpaRepositorio comboRepositorio, IProductoJpaRepositorio productoRepositorio,
            IDetallePedidoJpaRepositorio detalleRepositorio) {
        this.comboRepositorio = comboRepositorio;
        this.productoRepositorio = productoRepositorio;
        this.detalleRepositorio = detalleRepositorio;
    }

    @Transactional(readOnly = true)
    public List<ComboResponseDto> listar() {
        return comboRepositorio.findByComboEstadoTrueOrderByComboNombreAsc().stream().map(this::toDto).toList();
    }

    @Transactional(readOnly = true)
    public ComboResponseDto buscar(int id) { return toDto(buscarEntity(id)); }

    @Transactional
    public ComboResponseDto guardar(ComboRequestDto dto) {
        if (dto.getIdCombo() > 0 && detalleRepositorio.existsByFkComboIdCombo(dto.getIdCombo())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT,
                    "El combo ya fue vendido. Desactívalo y crea uno nuevo para cambiar su composición.");
        }
        ComboEntity combo = dto.getIdCombo() == 0 ? new ComboEntity() : buscarEntity(dto.getIdCombo());
        combo.setComboNombre(dto.getComboNombre().trim());
        combo.setComboDescripcion(dto.getComboDescripcion());
        combo.setComboPrecio(dto.getComboPrecio());
        combo.setComboImagen(dto.getComboImagen());
        combo.setComboEstado(true);
        combo.getProductos().clear();

        for (var item : dto.getProductos()) {
            var producto = productoRepositorio.findById(item.idProducto())
                    .filter(p -> p.isProdEstado())
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                            "Producto no encontrado: " + item.idProducto()));
            ComboProductoEntity relacion = new ComboProductoEntity();
            relacion.setFkCombo(combo);
            relacion.setFkProducto(producto);
            relacion.setCantidad(item.cantidad());
            combo.getProductos().add(relacion);
        }
        return toDto(comboRepositorio.save(combo));
    }

    @Transactional
    public void eliminar(int id) {
        ComboEntity combo = buscarEntity(id);
        combo.setComboEstado(false);
        comboRepositorio.save(combo);
    }

    public ComboEntity buscarEntity(int id) {
        return comboRepositorio.findById(id).filter(ComboEntity::isComboEstado)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Combo no encontrado"));
    }

    public int stockDisponible(ComboEntity combo) {
        if (combo.getProductos().stream().anyMatch(i -> !i.getFkProducto().isProdEstado())) return 0;
        return combo.getProductos().stream()
                .mapToInt(i -> i.getFkProducto().getProdStock() / i.getCantidad())
                .min().orElse(0);
    }

    private ComboResponseDto toDto(ComboEntity combo) {
        var productos = combo.getProductos().stream()
                .map(i -> new ComboProductoResponseDto(i.getFkProducto().getIdProducto(),
                        i.getFkProducto().getProdNombre(), i.getCantidad())).toList();
        return new ComboResponseDto(combo.getIdCombo(), combo.getComboNombre(), combo.getComboDescripcion(),
                combo.getComboPrecio(), combo.getComboImagen(), stockDisponible(combo), productos);
    }
}
