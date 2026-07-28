package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DetallePedidoRequestDto {

	private int idDetallePedido;

	private int detalleCantidad;
	
	private BigDecimal detalleSubtotal;
	
	private BigDecimal detallePrecio;
	



}
