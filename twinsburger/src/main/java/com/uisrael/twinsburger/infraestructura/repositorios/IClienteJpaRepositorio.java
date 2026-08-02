	package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ClienteEntity;

public interface IClienteJpaRepositorio extends JpaRepository<ClienteEntity, Integer>{
	
	Optional<ClienteEntity> findByCliCorreoIgnoreCase(String correo);
	
	@Query("""
			SELECT c
			FROM ClienteEntity c
			WHERE LOWER(c.cliNombre) LIKE LOWER(CONCAT('%', :nombre, '%'))
			""")
			List<ClienteEntity> buscarPorNombre(String nombre);
	
	List<ClienteEntity> findByCliEstadoTrue();

}
