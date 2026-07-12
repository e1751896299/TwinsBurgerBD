package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DetallePedidoRequestDto {
	
	@NotBlank
	private int idDetallePedido;
	@NotBlank
	private int detalleCantidad;
	@NotBlank
	private BigDecimal detalleSubtotal;
	@NotBlank
	private BigDecimal detallePrecio;

}
