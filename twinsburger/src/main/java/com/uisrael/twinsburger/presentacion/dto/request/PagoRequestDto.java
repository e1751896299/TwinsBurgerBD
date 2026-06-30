package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PagoRequestDto {
	
	private int idPago;
	@NotBlank
	private LocalDateTime pagoFecha;
	@NotBlank
	private BigDecimal pagoMonto;
	@NotBlank
	private boolean pagoEstado;

}
