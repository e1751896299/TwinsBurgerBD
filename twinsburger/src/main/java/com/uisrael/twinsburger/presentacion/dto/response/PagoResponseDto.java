package com.uisrael.twinsburger.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDto {
	
	private int idPago;
	private LocalDateTime pagoFecha;
	private BigDecimal pagoMonto;
	private boolean pagoEstado;
	public PagoResponseDto() {
		super();
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
	public boolean isPagoEstado() {
		return pagoEstado;
	}
	public void setPagoEstado(boolean pagoEstado) {
		this.pagoEstado = pagoEstado;
	}
	

}
