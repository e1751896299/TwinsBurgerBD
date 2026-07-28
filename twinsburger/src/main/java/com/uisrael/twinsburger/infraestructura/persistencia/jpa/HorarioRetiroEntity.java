package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "HorarioRetiro")
public class HorarioRetiroEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHorarioRetiro;
	private LocalTime hrInicio;
	private LocalTime hrFin;
	private boolean hrEstado = true;
	
	@OneToMany(mappedBy = "fkHorarioRetiro")
	private List<PedidoEntity> pedidos = new ArrayList<>();

}
