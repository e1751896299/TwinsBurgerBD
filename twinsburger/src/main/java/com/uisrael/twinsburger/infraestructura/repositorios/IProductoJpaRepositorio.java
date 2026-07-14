package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

public interface IProductoJpaRepositorio extends JpaRepository<ProductoEntity, Integer> {
	
	List<ProductoEntity> findByProdEstado(Boolean estado);

	List<ProductoEntity> findByProdNombreContaining(String nombre);
	
	@Query("""
			SELECT p
			FROM ProductoEntity p
			WHERE p.categoria.idCategoria = :idCategoria
			""")
			List<ProductoEntity> buscarPorCategoria(Integer idCategoria);
	
	@Query("""
			SELECT p
			FROM ProductoEntity p
			WHERE p.prodEstado = true
			""")
			List<ProductoEntity> listarActivos();

}
