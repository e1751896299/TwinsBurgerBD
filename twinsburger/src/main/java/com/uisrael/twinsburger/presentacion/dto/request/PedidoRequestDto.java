package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PedidoRequestDto {

	private int idPedido;
	@NotNull
	private Date pedidoFechaPedido;
	@NotNull
	private LocalTime pedidoHoraRetiro;
	@NotNull
	private BigDecimal pedidoTotal;
	
	private String pedidoDescripcion;

	private int idCliente;
	private int idAdministrador;
	private int idHorarioRetiro;

}
