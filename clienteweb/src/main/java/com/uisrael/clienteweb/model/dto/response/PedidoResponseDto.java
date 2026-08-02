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
	private int idCliente;
	private String clienteNombre;
	private int idAdministrador;
	private String administradorNombre;
	private int idHorarioRetiro;
	private LocalTime horarioInicio;
	private LocalTime horarioFin;


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

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getAdministradorNombre() {
		return administradorNombre;
	}

	public void setAdministradorNombre(String administradorNombre) {
		this.administradorNombre = administradorNombre;
	}

	public int getIdHorarioRetiro() {
		return idHorarioRetiro;
	}

	public void setIdHorarioRetiro(int idHorarioRetiro) {
		this.idHorarioRetiro = idHorarioRetiro;
	}

	public LocalTime getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(LocalTime horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public LocalTime getHorarioFin() {
		return horarioFin;
	}

	public void setHorarioFin(LocalTime horarioFin) {
		this.horarioFin = horarioFin;
	}

}
