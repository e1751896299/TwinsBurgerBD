package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraEntity;

public interface IOrdenCompraJpaRepositorio extends JpaRepository<OrdenCompraEntity, Integer> {
    List<OrdenCompraEntity> findByOcEstadoTrueOrderByOcFechaDesc();
}
