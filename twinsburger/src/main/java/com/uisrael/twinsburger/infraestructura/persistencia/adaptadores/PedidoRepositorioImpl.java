package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ClienteEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IAdministradorJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IHorarioRetiroJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;

public class PedidoRepositorioImpl implements IPedidoRepositorio {

	private final IPedidoJpaRepositorio jpaRepositorio;
	private final IPedidoJpaMapper entityMapper;
	private final IClienteJpaRepositorio clienteJpaRepositorio;
	private final IAdministradorJpaRepositorio administradorJpaRepositorio;
	private final IHorarioRetiroJpaRepositorio horarioRetiroJpaRepositorio;


	public PedidoRepositorioImpl(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper entityMapper,
			IClienteJpaRepositorio clienteJpaRepositorio, IAdministradorJpaRepositorio administradorJpaRepositorio,
			IHorarioRetiroJpaRepositorio horarioRetiroJpaRepositorio) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.clienteJpaRepositorio = clienteJpaRepositorio;
		this.administradorJpaRepositorio = administradorJpaRepositorio;
		this.horarioRetiroJpaRepositorio = horarioRetiroJpaRepositorio;
	}

	@Override
	public Pedido guardar(Pedido nuevoPedido) {
		PedidoEntity entity = entityMapper.toEntity(nuevoPedido);
		ClienteEntity cliente = clienteJpaRepositorio.findById(nuevoPedido.getIdCliente())
				.orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
		AdministradorEntity administrador = administradorJpaRepositorio.findById(nuevoPedido.getIdAdministrador())
				.orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
		HorarioRetiroEntity horario = horarioRetiroJpaRepositorio.findById(nuevoPedido.getIdHorarioRetiro())
				.orElseThrow(() -> new RuntimeException("HorarioRetiro no encontrado"));
		entity.setFkCliente(cliente);
		entity.setFkAdministrador(administrador);
		entity.setFkHorarioRetiro(horario);
		PedidoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pedido> buscarId(int idPedido) {
		return jpaRepositorio.findById(idPedido).map(entityMapper::toDomain);
	}

	@Override
	public List<Pedido> listaTodos() {
		return jpaRepositorio.findByPedidoEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPedido) {
		PedidoEntity pedido = jpaRepositorio.findById(idPedido)
	            .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
	 pedido.setPedidoEstado(false);
	 jpaRepositorio.save(pedido);
		
	}

	@Override
	public List<Pedido> listarPedidosCliente(Integer idCliente) {
		return jpaRepositorio.listarPedidosCliente(idCliente).stream().map(entityMapper::toDomain).toList();
	}


	@Override
	public List<Pedido> buscarPorHorario(Integer idHorario) {
		return jpaRepositorio.buscarPorHorario(idHorario).stream().map(entityMapper::toDomain).toList();
	}

}
