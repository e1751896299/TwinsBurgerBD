package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;

public class PedidoRepositorioImpl implements IPedidoRepositorio {
	
	private final IPedidoJpaRepositorio jpaRepositorio;
	private final IPedidoJpaMapper entityMapper;
	

	public PedidoRepositorioImpl(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Pedido guardar(Pedido nuevoPedido) {
		PedidoEntity entity = entityMapper.toEntity(nuevoPedido);
		PedidoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pedido> buscarId(int idPedido) {
		return jpaRepositorio.findById(idPedido).map(entityMapper::toDomain);
	}

	@Override
	public List<Pedido> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPedido) {
		jpaRepositorio.deleteById(idPedido);
		
	}

}
