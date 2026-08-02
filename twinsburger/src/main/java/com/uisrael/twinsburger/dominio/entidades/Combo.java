package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;

public class Combo {

	private int idCombo;
	private String comboNombre;
	private String comboDescripcion;
	private BigDecimal comboPrecio;
	private boolean comboEstado = true;

	public Combo() {
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
	public boolean isComboEstado() {
		return comboEstado;
	}
	public void setComboEstado(boolean comboEstado) {
		this.comboEstado = comboEstado;
	}

}
