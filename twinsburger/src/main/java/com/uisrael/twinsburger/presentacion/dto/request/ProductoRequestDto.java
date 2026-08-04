package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductoRequestDto {

	private int idProducto;
	@NotBlank
	private String prodNombre;

	private String prodDescripcion;
	
	@PositiveOrZero(message = "El stock no puede ser negativo")
	private int prodStock;
	@NotNull(message = "La categoria es obligatoria")
	private Integer idCategoria;

	@NotNull(message = "El precio es obligatorio")
	@DecimalMin(value = "0.01", message = "El precio debe ser mayor que cero")
	private BigDecimal prodPrecio;
	
	private String prodImagen;

}
