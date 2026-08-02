package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ComboDetalle")
public class ComboDetalleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComboDetalle;
	private int cdCantidad;
	private boolean cdEstado = true;

	@ManyToOne
	@JoinColumn(name = "id_combo")
	private ComboEntity fkCombo;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoEntity fkProducto;

}
