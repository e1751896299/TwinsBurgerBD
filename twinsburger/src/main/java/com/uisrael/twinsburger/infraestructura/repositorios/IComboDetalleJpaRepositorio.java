package com.uisrael.twinsburger.infraestructura.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboDetalleEntity;

public interface IComboDetalleJpaRepositorio extends JpaRepository<ComboDetalleEntity, Integer> {

	@Query("""
			SELECT d
			FROM ComboDetalleEntity d
			WHERE d.fkCombo.idCombo = :idCombo
			""")
	List<ComboDetalleEntity> obtenerComboDetalle(Integer idCombo);

	List<ComboDetalleEntity> findByCdEstadoTrue();

}
