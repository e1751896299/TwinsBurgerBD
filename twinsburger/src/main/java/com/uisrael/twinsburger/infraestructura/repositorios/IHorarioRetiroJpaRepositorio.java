package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;

public interface IHorarioRetiroJpaRepositorio extends JpaRepository<HorarioRetiroEntity, Integer> {
	
	@Query("""
			SELECT h
			FROM HorarioRetiroEntity h
			ORDER BY h.idHorario
			""")
			List<HorarioRetiroEntity> listarHorarios();

}
