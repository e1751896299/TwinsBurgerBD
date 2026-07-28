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
@Table(name = "Categoria")
public class CategoriaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategoria;
	private String categoriaNombre;
	private String categoriaDescripcion;
	private boolean categoriaEstado = true;
	
	
	@OneToMany(mappedBy = "fkCategoria")
	private List<ProductoEntity> productos = new ArrayList<>();

}
