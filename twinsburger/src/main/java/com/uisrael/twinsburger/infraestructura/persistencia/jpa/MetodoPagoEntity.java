package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

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
@Table(name = "MetodoPago")
public class MetodoPagoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMetodoPago;
	private String mpagoDescripcion;
	private boolean mpagoEstado = true;
	
	@OneToMany(mappedBy = "fkMetodoPago")
	private List<PagoEntity> pagos = new ArrayList<>();

}
