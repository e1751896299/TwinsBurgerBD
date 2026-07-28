package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

public class PedidoResponseDto {
	
	private int idPedido;
	private Date pedidoFechaPedido;
	private LocalTime pedidoHoraRetiro;
	private BigDecimal pedidoTotal;
	private String pedidoDescripcion;
	private boolean pedidoEstado;
	

	public boolean isPedidoEstado() {
		return pedidoEstado;
	}

	public void setPedidoEstado(boolean pedidoEstado) {
		this.pedidoEstado = pedidoEstado;
	}

	public PedidoResponseDto() {
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Date getPedidoFechaPedido() {
		return pedidoFechaPedido;
	}

	public void setPedidoFechaPedido(Date pedidoFechaPedido) {
		this.pedidoFechaPedido = pedidoFechaPedido;
	}

	public LocalTime getPedidoHoraRetiro() {
		return pedidoHoraRetiro;
	}

	public void setPedidoHoraRetiro(LocalTime pedidoHoraRetiro) {
		this.pedidoHoraRetiro = pedidoHoraRetiro;
	}

	public BigDecimal getPedidoTotal() {
		return pedidoTotal;
	}

	public void setPedidoTotal(BigDecimal pedidoTotal) {
		this.pedidoTotal = pedidoTotal;
	}

	public String getPedidoDescripcion() {
		return pedidoDescripcion;
	}

	public void setPedidoDescripcion(String pedidoDescripcion) {
		this.pedidoDescripcion = pedidoDescripcion;
	}
		

}
