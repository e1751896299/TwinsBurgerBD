package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HorarioRetiro")
public class HorarioRetiroEntity {
	
	@Id
	private int idHorarioRetiro;
	private LocalTime hrInicio;
	private LocalTime hrFin;
	private boolean hrEstado;

}
