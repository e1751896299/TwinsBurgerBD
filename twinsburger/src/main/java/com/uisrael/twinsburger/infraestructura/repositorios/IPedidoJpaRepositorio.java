package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;

public interface IPedidoJpaRepositorio extends JpaRepository<PedidoEntity, Integer>{
	
	
	@Query("""
			SELECT p
			FROM PedidoEntity p
			WHERE p.cliente.idCliente = :idCliente
			ORDER BY p.idPedido DESC
			""")
			List<PedidoEntity> listarPedidosCliente(Integer idCliente);
	
	@Query("""
			SELECT p
			FROM PedidoEntity p
			WHERE p.pedidoEstado = false
			""")
			List<PedidoEntity> listarPendientes();
	
	@Query("""
			SELECT p
			FROM PedidoEntity p
			WHERE p.horarioRetiro.idHorario = :idHorario
			""")
			List<PedidoEntity> buscarPorHorario(Integer idHorario);

}
