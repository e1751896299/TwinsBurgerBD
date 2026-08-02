package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;

public interface IAdministradorJpaRepositorio extends JpaRepository<AdministradorEntity, Integer> {
	
	Optional<AdministradorEntity> findByAdminCorreoIgnoreCase(String correo);
	
	List<AdministradorEntity> findByAdminEstadoTrue();

}

