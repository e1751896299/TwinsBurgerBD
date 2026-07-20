package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;

public interface IPedidoJpaRepositorio extends JpaRepository<PedidoEntity, Integer>{
	
	
	@Query("""
		    SELECT p
		    FROM PedidoEntity p
		    WHERE p.fkCliente.idCliente = :idCliente
		    ORDER BY p.idPedido DESC
		    """)
		List<PedidoEntity> listarPedidosCliente(@Param("idCliente") Integer idCliente);
	
	
	@Query("""
		    SELECT p
		    FROM PedidoEntity p
		    WHERE p.fkHorarioRetiro.idHorarioRetiro = :idHorario
		    """)
		List<PedidoEntity> buscarPorHorario(@Param("idHorario") Integer idHorario);

}
