package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;

public interface ICategoriaRepositorio extends JpaRepository<CategoriaEntity, Integer> {

}
