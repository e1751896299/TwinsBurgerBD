package com.uisrael.clienteweb.model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductoRequestDto {
	
	private int idProducto;
	
	private String prodNombre;
	
	private String prodDescripcion;
	
	private int prodStock;
	
	private String prodCategoria;
	
	private LocalDateTime proFechaCreacion;

}
