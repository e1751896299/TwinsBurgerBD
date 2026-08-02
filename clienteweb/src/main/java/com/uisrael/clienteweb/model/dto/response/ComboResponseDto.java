package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;

public class ComboResponseDto {

	private int idCombo;
	private String comboNombre;
	private String comboDescripcion;
	private BigDecimal comboPrecio;

	public ComboResponseDto() {
	}

	public int getIdCombo() {
		return idCombo;
	}

	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}

	public String getComboNombre() {
		return comboNombre;
	}

	public void setComboNombre(String comboNombre) {
		this.comboNombre = comboNombre;
	}

	public String getComboDescripcion() {
		return comboDescripcion;
	}

	public void setComboDescripcion(String comboDescripcion) {
		this.comboDescripcion = comboDescripcion;
	}

	public BigDecimal getComboPrecio() {
		return comboPrecio;
	}

	public void setComboPrecio(BigDecimal comboPrecio) {
		this.comboPrecio = comboPrecio;
	}

}
