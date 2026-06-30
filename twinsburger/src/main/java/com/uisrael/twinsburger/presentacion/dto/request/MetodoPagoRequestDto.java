package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class MetodoPagoRequestDto {
	
	private int idMetodoPago;
	@NotBlank
	private String mpagoDescripcion;
	@NotBlank
	private boolean mpagoEstado;

}
