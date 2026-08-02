package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.query.Param;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

import jakarta.persistence.LockModeType;

public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer> {
	

	List<ProductoEntity> findByProdNombre(String nombre);
	
	@Query("""
			SELECT p
			FROM ProductoEntity p
			WHERE p.fkCategoria.idCategoria = :idCategoria
			""")
			List<ProductoEntity> buscarPorCategoria(Integer idCategoria);
	
	List<ProductoEntity> findByProdEstadoTrue();

	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Query("SELECT p FROM ProductoEntity p WHERE p.idProducto = :idProducto")
	java.util.Optional<ProductoEntity> buscarPorIdParaCompra(@Param("idProducto") Integer idProducto);
	

}
