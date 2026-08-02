package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetalleOrdenCompraEntity;

public interface IDetalleOrdenCompraJpaRepositorio extends JpaRepository<DetalleOrdenCompraEntity, Integer> {

	@Query("""
			SELECT d
			FROM DetalleOrdenCompraEntity d
			WHERE d.fkOrdenCompra.idOrdenCompra = :idOrdenCompra
			""")
	List<DetalleOrdenCompraEntity> obtenerDetalleOrdenCompra(Integer idOrdenCompra);

	List<DetalleOrdenCompraEntity> findByDocEstadoTrue();

}
