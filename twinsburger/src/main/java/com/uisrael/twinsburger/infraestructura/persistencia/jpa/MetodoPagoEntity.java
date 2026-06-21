package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "MetodoPago")
public class MetodoPagoEntity {
	
	@Id
	private int idMetodoPago;
	private String mpagoDescripcion;
	private boolean mpagoEstado;

}
