package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;
import com.uisrael.twinsburger.dominio.repositorios.IDetalleOrdenCompraRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetalleOrdenCompraEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IDetalleOrdenCompraJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetalleOrdenCompraJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IOrdenCompraJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

public class DetalleOrdenCompraRepositorioImpl implements IDetalleOrdenCompraRepositorio {

	private final IDetalleOrdenCompraJpaRepositorio jpaRepositorio;
	private final IDetalleOrdenCompraJpaMapper entityMapper;
	private final IOrdenCompraJpaRepositorio ordenCompraJpaRepositorio;
	private final IProductoJpaRepositorio productoJpaRepositorio;

	public DetalleOrdenCompraRepositorioImpl(IDetalleOrdenCompraJpaRepositorio jpaRepositorio,
			IDetalleOrdenCompraJpaMapper entityMapper, IOrdenCompraJpaRepositorio ordenCompraJpaRepositorio,
			IProductoJpaRepositorio productoJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.ordenCompraJpaRepositorio = ordenCompraJpaRepositorio;
		this.productoJpaRepositorio = productoJpaRepositorio;
	}

	@Override
	public DetalleOrdenCompra guardar(DetalleOrdenCompra nuevoDetalle) {
		boolean esNuevo = nuevoDetalle.getIdDetalleOrdenCompra() == 0;
		DetalleOrdenCompraEntity entity = entityMapper.toEntity(nuevoDetalle);
		OrdenCompraEntity ordenCompra = ordenCompraJpaRepositorio.findById(nuevoDetalle.getIdOrdenCompra())
				.orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));
		ProductoEntity producto = productoJpaRepositorio.findById(nuevoDetalle.getIdProducto())
				.orElseThrow(() -> new RuntimeException("Producto no encontrado"));
		entity.setFkOrdenCompra(ordenCompra);
		entity.setFkProducto(producto);
		DetalleOrdenCompraEntity guardado = jpaRepositorio.save(entity);

		if (esNuevo) {
			producto.setProdStock(producto.getProdStock() + nuevoDetalle.getDocCantidad());
			productoJpaRepositorio.save(producto);
		}

		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetalleOrdenCompra> buscarId(int idDetalle) {
		return jpaRepositorio.findById(idDetalle).map(entityMapper::toDomain);
	}

	@Override
	public List<DetalleOrdenCompra> listarTodos() {
		return jpaRepositorio.findByDocEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalle) {
		DetalleOrdenCompraEntity detalle = jpaRepositorio.findById(idDetalle)
				.orElseThrow(() -> new RuntimeException("Detalle de orden de compra no encontrado"));
		detalle.setDocEstado(false);
		jpaRepositorio.save(detalle);
	}

	@Override
	public List<DetalleOrdenCompra> obtenerDetalleOrdenCompra(Integer idOrdenCompra) {
		return jpaRepositorio.obtenerDetalleOrdenCompra(idOrdenCompra).stream().map(entityMapper::toDomain).toList();
	}

}
