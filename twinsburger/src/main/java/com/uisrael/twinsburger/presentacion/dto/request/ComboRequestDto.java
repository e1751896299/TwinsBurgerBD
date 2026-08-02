package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComboRequestDto {

	private int idCombo;
	@NotBlank
	private String comboNombre;

	private String comboDescripcion;
	@NotNull
	private BigDecimal comboPrecio;

}
