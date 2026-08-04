package com.uisrael.twinsburger.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PagoResponseDto {
	
	private int idPago;
	private LocalDateTime pagoFecha;
	private BigDecimal pagoMonto;
	private boolean pagoEstado;
	private int idPedido;
	private String metodoPago;
	
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
	public boolean isPagoEstado() { return pagoEstado; }
	public void setPagoEstado(boolean pagoEstado) { this.pagoEstado = pagoEstado; }
	public int getIdPedido() { return idPedido; }
	public void setIdPedido(int idPedido) { this.idPedido = idPedido; }
	public String getMetodoPago() { return metodoPago; }
	public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }


		

}
