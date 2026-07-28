package com.uisrael.clienteweb.model.dto.request;

import java.time.LocalTime;

import lombok.Data;

@Data
public class HorarioRetiroRequestDto {


	private int idHorarioRetiro;
	
	private LocalTime hrInicio;
	
	private LocalTime hrFin;



}
