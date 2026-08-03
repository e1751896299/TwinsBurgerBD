package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;

public class DetallePedido {
	
	private int idDetallePedido;
	private int detalleCantidad;
	private BigDecimal detalleSubtotal;
	private BigDecimal detallePrecio;
	private boolean detalleEstado = true;
	private int idProducto;
	private String prodNombre;
	
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getProdNombre() {
		return prodNombre;
	}

	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}

	public DetallePedido() {
	}
	
	public boolean isDetalleEstado() {
		return detalleEstado;
	}
	public void setDetalleEstado(boolean detalleEstado) {
		this.detalleEstado = detalleEstado;

	}
	public int getIdDetallePedido() {
		return idDetallePedido;
	}
	public void setIdDetallePedido(int idDetallePedido) {
		this.idDetallePedido = idDetallePedido;
	}
	public int getDetalleCantidad() {
		return detalleCantidad;
	}
	public void setDetalleCantidad(int detalleCantidad) {
		this.detalleCantidad = detalleCantidad;
	}
	public BigDecimal getDetalleSubtotal() {
		return detalleSubtotal;
	}
	public void setDetalleSubtotal(BigDecimal detalleSubtotal) {
		this.detalleSubtotal = detalleSubtotal;
	}
	public BigDecimal getDetallePrecio() {
		return detallePrecio;
	}
	public void setDetallePrecio(BigDecimal detallePrecio) {
		this.detallePrecio = detallePrecio;
	}
	
	
	

}
