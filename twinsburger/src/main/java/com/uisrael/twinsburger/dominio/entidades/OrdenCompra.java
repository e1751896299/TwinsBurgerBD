package com.uisrael.twinsburger.dominio.entidades;

import java.time.LocalDateTime;

public class OrdenCompra {

	private int idOrdenCompra;
	private LocalDateTime ocFecha;
	private String ocProveedor;
	private boolean ocEstado = true;

	public OrdenCompra() {
	}

	public int getIdOrdenCompra() {
		return idOrdenCompra;
	}
	public void setIdOrdenCompra(int idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}
	public LocalDateTime getOcFecha() {
		return ocFecha;
	}
	public void setOcFecha(LocalDateTime ocFecha) {
		this.ocFecha = ocFecha;
	}
	public String getOcProveedor() {
		return ocProveedor;
	}
	public void setOcProveedor(String ocProveedor) {
		this.ocProveedor = ocProveedor;
	}
	public boolean isOcEstado() {
		return ocEstado;
	}
	public void setOcEstado(boolean ocEstado) {
		this.ocEstado = ocEstado;
	}

}
