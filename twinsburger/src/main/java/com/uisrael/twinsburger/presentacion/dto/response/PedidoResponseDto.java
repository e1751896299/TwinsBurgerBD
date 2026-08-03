package com.uisrael.twinsburger.presentacion.dto.response;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.Date;

import com.uisrael.twinsburger.dominio.entidades.EstadoPedido;

public class PedidoResponseDto {
	
	private int idPedido;
	private Date pedidoFechaPedido;
	private LocalTime pedidoHoraRetiro;
	private BigDecimal pedidoTotal;
	private String pedidoDescripcion;
	private boolean pedidoEntrega;
	private EstadoPedido pedidoEstadoProceso;

	
	public EstadoPedido getPedidoEstadoProceso() {
		return pedidoEstadoProceso;
	}

	public void setPedidoEstadoProceso(EstadoPedido pedidoEstadoProceso) {
		this.pedidoEstadoProceso = pedidoEstadoProceso;
	}

	public boolean isPedidoEntrega() {
		return pedidoEntrega;
	}

	public void setPedidoEntrega(boolean pedidoEntrega) {
		this.pedidoEntrega = pedidoEntrega;
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
