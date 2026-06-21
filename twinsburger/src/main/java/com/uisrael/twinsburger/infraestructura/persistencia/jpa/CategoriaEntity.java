package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Categoria")
public class CategoriaEntity {
	
	@Id
	private int idCategoria;
	private String categoriaNombre;
	private String categoriaDescripcion;
	private boolean categoriaEstado;

}
