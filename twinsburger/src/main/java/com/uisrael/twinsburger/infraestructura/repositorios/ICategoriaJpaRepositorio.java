package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;

public interface ICategoriaJpaRepositorio extends JpaRepository<CategoriaEntity, Integer> {
	
	Optional<CategoriaEntity> findByCatNombre(String nombre);

}
