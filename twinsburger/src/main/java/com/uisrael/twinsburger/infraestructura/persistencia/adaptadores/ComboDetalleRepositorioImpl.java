package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;
import com.uisrael.twinsburger.dominio.repositorios.IComboDetalleRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboDetalleEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IComboDetalleJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboDetalleJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

public class ComboDetalleRepositorioImpl implements IComboDetalleRepositorio {

	private final IComboDetalleJpaRepositorio jpaRepositorio;
	private final IComboDetalleJpaMapper entityMapper;
	private final IComboJpaRepositorio comboJpaRepositorio;
	private final IProductoJpaRepositorio productoJpaRepositorio;

	public ComboDetalleRepositorioImpl(IComboDetalleJpaRepositorio jpaRepositorio, IComboDetalleJpaMapper entityMapper,
			IComboJpaRepositorio comboJpaRepositorio, IProductoJpaRepositorio productoJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.comboJpaRepositorio = comboJpaRepositorio;
		this.productoJpaRepositorio = productoJpaRepositorio;
	}

	@Override
	public ComboDetalle guardar(ComboDetalle nuevoDetalle) {
		ComboDetalleEntity entity = entityMapper.toEntity(nuevoDetalle);
		ComboEntity combo = comboJpaRepositorio.findById(nuevoDetalle.getIdCombo())
				.orElseThrow(() -> new RuntimeException("Combo no encontrado"));
		ProductoEntity producto = productoJpaRepositorio.findById(nuevoDetalle.getIdProducto())
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		entity.setFkCombo(combo);
		entity.setFkProducto(producto);
		ComboDetalleEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<ComboDetalle> buscarId(int idDetalle) {
		return jpaRepositorio.findById(idDetalle).map(entityMapper::toDomain);
	}

	@Override
	public List<ComboDetalle> listarTodos() {
		return jpaRepositorio.findByCdEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalle) {
		ComboDetalleEntity detalle = jpaRepositorio.findById(idDetalle)
				.orElseThrow(() -> new RuntimeException("Detalle de combo no encontrado"));
		detalle.setCdEstado(false);
		jpaRepositorio.save(detalle);
	}

	@Override
	public List<ComboDetalle> obtenerComboDetalle(Integer idCombo) {
		return jpaRepositorio.obtenerComboDetalle(idCombo).stream().map(entityMapper::toDomain).toList();
	}

}
