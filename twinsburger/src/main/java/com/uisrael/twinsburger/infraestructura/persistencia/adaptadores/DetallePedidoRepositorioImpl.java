package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.dominio.repositorios.IDetallePedidoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;

public class DetallePedidoRepositorioImpl implements IDetallePedidoRepositorio{
	
	private final IDetallePedidoJpaRepositorio jpaRepositorio;
	private final IDetallePedidoJpaMapper entityMapper;
	

	public DetallePedidoRepositorioImpl(IDetallePedidoJpaRepositorio jpaRepositorio,
			IDetallePedidoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public DetallePedido guardar(DetallePedido nuevoDetalle) {
		DetallePedidoEntity entity = entityMapper.toEntity(nuevoDetalle);
		DetallePedidoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<DetallePedido> buscarId(int idDetalle) {
		return jpaRepositorio.findById(idDetalle).map(entityMapper::toDomain);
	}

	@Override
	public List<DetallePedido> listarTodos() {
		return jpaRepositorio.findByDetalleEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idDetalle) {
		DetallePedidoEntity detalle = jpaRepositorio.findById(idDetalle)
	            .orElseThrow(() -> new RuntimeException("no se encontro detalles de este pedido"));
	 detalle.setDetalleEstado(false);
	 jpaRepositorio.save(detalle);
		
	}

	@Override
	public List<DetallePedido> obtenerDetallePedido(Integer idPedido) {
		return jpaRepositorio.obtenerDetallePedido(idPedido).stream().map(entityMapper::toDomain).toList();
	}

}
