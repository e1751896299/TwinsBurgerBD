package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;

public interface IMetodoPagoRepositorio extends JpaRepository<MetodoPagoEntity, Integer>{

}
