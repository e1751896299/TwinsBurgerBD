package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;

import lombok.Data;

@Data
public class PedidoRequestDto {

	private int idPedido;
	
	private Date pedidoFechaPedido;
	
	private LocalTime pedidoHoraRetiro;

	private BigDecimal pedidoTotal;
	
	private String pedidoDescripcion;
	
	private boolean pedidoEntrega;


}
