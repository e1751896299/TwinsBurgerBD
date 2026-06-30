package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductoRequestDto {
	
	private int idProducto;
	@NotBlank
	private String prodNombre;
	
	private String prodDescripcion;
	@NotBlank
	private int prodStock;
	@NotBlank
	private String prodCategoria;
	@NotBlank
	private LocalDateTime proFechaCreacion;

}
