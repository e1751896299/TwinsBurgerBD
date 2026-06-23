package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ClienteEntity;

public interface IClienteRepositorio extends JpaRepository<ClienteEntity, Integer>{

}
