package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ComboRequestDto {

	private int idCombo;

	private String comboNombre;

	private String comboDescripcion;

	private BigDecimal comboPrecio;

}
