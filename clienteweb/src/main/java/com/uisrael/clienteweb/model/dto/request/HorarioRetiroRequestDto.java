package com.uisrael.clienteweb.model.dto.request;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class HorarioRetiroRequestDto {


	private int idHorarioRetiro;
	
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "La hora de inicio es obligatoria")
	private LocalTime hrInicio;
	
	@DateTimeFormat(pattern = "HH:mm")
	@NotNull(message = "La hora de fin es obligatoria")
	private LocalTime hrFin;



}
