package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;

public interface IAdministradorRepositorio extends JpaRepository<AdministradorEntity, Integer> {

}
