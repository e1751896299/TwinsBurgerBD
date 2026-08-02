package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
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
@Table(name = "Combo")
public class ComboEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCombo;
	private String comboNombre;
	private String comboDescripcion;
	private BigDecimal comboPrecio;
	private boolean comboEstado = true;

	@OneToMany(mappedBy = "fkCombo")
	private List<ComboDetalleEntity> detalles = new ArrayList<>();

}
