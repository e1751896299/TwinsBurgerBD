package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PedidoRequestDto {
	
	private int idPedido;
	@NotBlank
	private Date pedidoFechaPedido;
	@NotBlank
	private LocalTime pedidoHoraRetiro;
	@NotBlank
	private boolean pedidoEstado;
	@NotBlank
	private BigDecimal pedidoTotal;
	
	private String pedidoDescripcion;

}
