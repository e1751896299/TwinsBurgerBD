package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;

public interface ICategoriaJpaRepositorio extends JpaRepository<CategoriaEntity, Integer> {

}
