package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;

public interface IMetodoPagoJpaRepositorio extends JpaRepository<MetodoPagoEntity, Integer>{
	
	Optional<MetodoPagoEntity> findByMpagoDescripcion(String descripcion);
	
	List<MetodoPagoEntity> findByMpagoEstadoTrue();

}
