package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetallePedidoRequestDto {

	private int idDetallePedido;

	private int detalleCantidad;
	@NotNull
	private BigDecimal detalleSubtotal;
	@NotNull
	private BigDecimal detallePrecio;
	



}
