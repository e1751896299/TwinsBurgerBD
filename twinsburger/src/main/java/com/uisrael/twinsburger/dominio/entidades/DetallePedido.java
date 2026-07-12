package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;

public class DetallePedido {
	
	private int idDetallePedido;
	private int detalleCantidad;
	private BigDecimal detalleSubtotal;
	private BigDecimal detallePrecio;
	
	public DetallePedido(int idDetallePedido, int detalleCantidad, BigDecimal detalleSubtotal,
			BigDecimal detallePrecio) {
		super();
		this.idDetallePedido = idDetallePedido;
		this.detalleCantidad = detalleCantidad;
		this.detalleSubtotal = detalleSubtotal;
		this.detallePrecio = detallePrecio;
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
