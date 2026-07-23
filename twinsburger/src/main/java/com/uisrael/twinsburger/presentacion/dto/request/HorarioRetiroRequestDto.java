package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalTime;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class HorarioRetiroRequestDto {


	private int idHorarioRetiro;
	@NotNull
	private LocalTime hrInicio;
	@NotNull
	private LocalTime hrFin;

	private boolean hrEstado;

}
