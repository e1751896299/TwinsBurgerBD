package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;

public interface IComboJpaRepositorio extends JpaRepository<ComboEntity, Integer> {
    List<ComboEntity> findByComboEstadoTrueOrderByComboNombreAsc();
}
