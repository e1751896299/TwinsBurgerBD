package com.uisrael.clienteweb.model.dto.response;

import java.time.LocalDateTime;

public class OrdenCompraResponseDto {

	private int idOrdenCompra;
	private LocalDateTime ocFecha;
	private String ocProveedor;

	public OrdenCompraResponseDto() {
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

}
