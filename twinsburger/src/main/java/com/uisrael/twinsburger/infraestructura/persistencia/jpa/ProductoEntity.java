package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private String prodCategoria;
	private LocalDateTime proFechaCreacion;
	 
}
