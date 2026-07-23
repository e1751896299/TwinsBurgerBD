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
	@NotBlank
	private String prodCategoria;
	@NotNull
	private LocalDateTime proFechaCreacion;

}
