package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.dominio.repositorios.IPagoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IMetodoPagoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPagoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;

public class PagoRepositorioImpl implements IPagoRepositorio{

	private final IPagoJpaRepositorio jpaRepositorio;
	private final IPagoJpaMapper entityMapper;
	private final IPedidoJpaRepositorio pedidoJpaRepositorio;
	private final IMetodoPagoJpaRepositorio metodoPagoJpaRepositorio;

	public PagoRepositorioImpl(IPagoJpaRepositorio jpaRepositorio, IPagoJpaMapper entityMapper,
			IPedidoJpaRepositorio pedidoJpaRepositorio, IMetodoPagoJpaRepositorio metodoPagoJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.pedidoJpaRepositorio = pedidoJpaRepositorio;
		this.metodoPagoJpaRepositorio = metodoPagoJpaRepositorio;
	}


	@Override
	public Pago guardar(Pago nuevoPago) {
		PagoEntity entity = entityMapper.toEntity(nuevoPago);
		PedidoEntity pedido = pedidoJpaRepositorio.findById(nuevoPago.getIdPedido())
				.orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
		MetodoPagoEntity metodoPago = metodoPagoJpaRepositorio.findById(nuevoPago.getIdMetodoPago())
				.orElseThrow(() -> new RuntimeException("MetodoPago no encontrado"));
		entity.setFkPedido(pedido);
		entity.setFkMetodoPago(metodoPago);
		PagoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pago> buscarId(int idPago) {
		return jpaRepositorio.findById(idPago).map(entityMapper::toDomain);
	}

	@Override
	public List<Pago> listaTodos() {
		return jpaRepositorio.findByPagoEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPago) {
		PagoEntity pago = jpaRepositorio.findById(idPago)
	            .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
	 pago.setPagoEstado(false);
	 jpaRepositorio.save(pago);
		
	}


	@Override
	public Optional<Pago> findByFkPedidoIdPedido(Integer idPedido) {
		return jpaRepositorio.findByFkPedidoIdPedido(idPedido).map(entityMapper::toDomain);
	}


	@Override
	public List<Pago> buscarPorMetodo(Integer idMetodo) {
		return jpaRepositorio.buscarPorMetodo(idMetodo).stream().map(entityMapper::toDomain).toList();
	}

}
