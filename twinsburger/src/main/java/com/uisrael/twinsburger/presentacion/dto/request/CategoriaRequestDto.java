package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoriaRequestDto {
	
	private int idCategoria;
	@NotBlank
	private String categoriaNombre;
	
	private String categoriaDescripcion;
	@NotBlank
	private boolean categoriaEstado;

}
