package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HorarioRetiroRequestDto {
	
	
	private int idHorarioRetiro;
	@NotBlank
	private LocalTime hrInicio;
	@NotBlank
	private LocalTime hrFin;
	@NotBlank
	private boolean hrEstado;

}
