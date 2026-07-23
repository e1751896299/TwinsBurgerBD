package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PagoRequestDto {

	private int idPago;
	@NotNull
	private LocalDateTime pagoFecha;
	@NotNull
	private BigDecimal pagoMonto;

	private boolean pagoEstado;

}
