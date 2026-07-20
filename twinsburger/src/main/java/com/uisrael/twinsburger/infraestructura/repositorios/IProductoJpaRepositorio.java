package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer> {
	

	List<ProductoEntity> findByProdNombre(String nombre);
	
	@Query("""
			SELECT p
			FROM ProductoEntity p
			WHERE p.fkCategoria.idCategoria = :idCategoria
			""")
			List<ProductoEntity> buscarPorCategoria(Integer idCategoria);
	

}
