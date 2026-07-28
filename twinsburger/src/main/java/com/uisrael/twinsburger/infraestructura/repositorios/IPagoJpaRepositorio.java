package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;

public interface IPagoJpaRepositorio extends JpaRepository<PagoEntity, Integer> {
	
	Optional<PagoEntity> findByFkPedidoIdPedido(Integer idPedido);
	
	
	@Query("""
		    SELECT p
		    FROM PagoEntity p
		    WHERE p.fkMetodoPago.idMetodoPago = :idMetodo
		    """)
		List<PagoEntity> buscarPorMetodo(@Param("idMetodo") Integer idMetodo);
	
	List<PagoEntity> findByPagoEstadoTrue();

}
