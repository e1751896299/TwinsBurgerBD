package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;

public interface IHorarioRetiroJpaRepositorio extends JpaRepository<HorarioRetiroEntity, Integer> {

}
