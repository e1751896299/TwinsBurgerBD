package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductoRequestDto {

	private int idProducto;
	@NotBlank
	private String prodNombre;

	private String prodDescripcion;

	private int prodStock;
	private int idCategoria;
	@NotNull
	private LocalDateTime proFechaCreacion;
	
	private boolean prodEstado = true;

}
