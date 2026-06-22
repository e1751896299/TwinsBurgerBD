package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;

public class Pedido {
	
	private int idPedido;
	private Date pedidoFechaPedido;
	private LocalTime pedidoHoraRetiro;
	private boolean pedidoEstado;
	private BigDecimal pedidoTotal;
	private String pedidoDescripcion;
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
	public boolean isPedidoEstado() {
		return pedidoEstado;
	}
	public void setPedidoEstado(boolean pedidoEstado) {
		this.pedidoEstado = pedidoEstado;
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
