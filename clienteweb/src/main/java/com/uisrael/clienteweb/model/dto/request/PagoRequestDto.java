package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PagoRequestDto {

	private int idPago;
	
	private LocalDateTime pagoFecha;
	
	private BigDecimal pagoMonto;

	

}
