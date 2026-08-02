package com.uisrael.clienteweb.model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoRequestDto {

	private int idProducto;
	
	private String prodNombre;

	private String prodDescripcion;

	private int prodStock;

	private int idCategoria;

	private LocalDateTime proFechaCreacion;
	
	private boolean prodEstado = true;

}
