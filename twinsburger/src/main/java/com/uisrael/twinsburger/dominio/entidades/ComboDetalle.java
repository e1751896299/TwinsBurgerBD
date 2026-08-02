package com.uisrael.twinsburger.dominio.entidades;

public class ComboDetalle {

	private int idComboDetalle;
	private int cdCantidad;
	private boolean cdEstado = true;
	private int idCombo;
	private int idProducto;
	private String productoNombre;

	public ComboDetalle() {
	}

	public int getIdComboDetalle() {
		return idComboDetalle;
	}
	public void setIdComboDetalle(int idComboDetalle) {
		this.idComboDetalle = idComboDetalle;
	}
	public int getCdCantidad() {
		return cdCantidad;
	}
	public void setCdCantidad(int cdCantidad) {
		this.cdCantidad = cdCantidad;
	}
	public boolean isCdEstado() {
		return cdEstado;
	}
	public void setCdEstado(boolean cdEstado) {
		this.cdEstado = cdEstado;
	}
	public int getIdCombo() {
		return idCombo;
	}
	public void setIdCombo(int idCombo) {
		this.idCombo = idCombo;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProductoNombre() {
		return productoNombre;
	}
	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

}
