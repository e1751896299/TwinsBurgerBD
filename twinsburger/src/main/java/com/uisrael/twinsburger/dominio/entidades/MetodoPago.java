package com.uisrael.twinsburger.dominio.entidades;

public class MetodoPago {
	
	private int idMetodoPago;
	private String mpagoDescripcion;
	private boolean mpagoEstado;
	public int getIdMetodoPago() {
		return idMetodoPago;
	}
	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}
	public String getMpagoDescripcion() {
		return mpagoDescripcion;
	}
	public void setMpagoDescripcion(String mpagoDescripcion) {
		this.mpagoDescripcion = mpagoDescripcion;
	}
	public boolean isMpagoEstado() {
		return mpagoEstado;
	}
	public void setMpagoEstado(boolean mpagoEstado) {
		this.mpagoEstado = mpagoEstado;
	}
	
	


}
