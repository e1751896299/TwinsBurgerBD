package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;

public interface IPagoJpaRepositorio extends JpaRepository<PagoEntity, Integer> {
	
	Optional<PagoEntity> findByPedidoIdPedido(Integer idPedido);
	
	@Query("""
			SELECT p
			FROM PagoEntity p
			WHERE p.metodoPago.idMetodo = :idMetodo
			""")
			List<PagoEntity> buscarPorMetodo(Integer idMetodo);

}
