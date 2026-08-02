package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;
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
@Table(name = "OrdenCompra")
public class OrdenCompraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idOrdenCompra;
	private LocalDateTime ocFecha;
	private String ocProveedor;
	private boolean ocEstado = true;

	@OneToMany(mappedBy = "fkOrdenCompra")
	private List<DetalleOrdenCompraEntity> detalles = new ArrayList<>();

}
