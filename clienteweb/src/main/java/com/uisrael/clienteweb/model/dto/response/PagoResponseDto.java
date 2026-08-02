package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDto {
	
	private int idPago;
	private LocalDateTime pagoFecha;
	private BigDecimal pagoMonto;
	private boolean pagoEstado;
	private int idPedido;
	private int idMetodoPago;
	private String metodoPagoDescripcion;

	public boolean isPagoEstado() {
		return pagoEstado;
	}

	public void setPagoEstado(boolean pagoEstado) {
		this.pagoEstado = pagoEstado;
	}

	public PagoResponseDto() {
	}

	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public LocalDateTime getPagoFecha() {
		return pagoFecha;
	}

	public void setPagoFecha(LocalDateTime pagoFecha) {
		this.pagoFecha = pagoFecha;
	}

	public BigDecimal getPagoMonto() {
		return pagoMonto;
	}

	public void setPagoMonto(BigDecimal pagoMonto) {
		this.pagoMonto = pagoMonto;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdMetodoPago() {
		return idMetodoPago;
	}

	public void setIdMetodoPago(int idMetodoPago) {
		this.idMetodoPago = idMetodoPago;
	}

	public String getMetodoPagoDescripcion() {
		return metodoPagoDescripcion;
	}

	public void setMetodoPagoDescripcion(String metodoPagoDescripcion) {
		this.metodoPagoDescripcion = metodoPagoDescripcion;
	}

}
