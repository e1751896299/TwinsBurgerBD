package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;

public interface IDetallePedidoJpaRepositorio extends JpaRepository<DetallePedidoEntity, Integer> {
	
	
	@Query("""
			SELECT d
			FROM DetallePedidoEntity d
			WHERE d.fkPedido.idPedido = :idPedido
			""")
			List<DetallePedidoEntity> obtenerDetallePedido(Integer idPedido);

}
