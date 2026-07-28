package com.uisrael.twinsburger.presentacion.dto.response;

import java.math.BigDecimal;

public class DetallePedidoResponseDto {
	
	private int idDetallePedido;
	private int detalleCantidad;
	private BigDecimal detalleSubtotal;
	private BigDecimal detallePrecio;

	
	public DetallePedidoResponseDto() {
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
