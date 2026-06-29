package com.uisrael.twinsburger.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;

public interface IPedidoJpaRepositorio extends JpaRepository<PedidoEntity, Integer>{

}
