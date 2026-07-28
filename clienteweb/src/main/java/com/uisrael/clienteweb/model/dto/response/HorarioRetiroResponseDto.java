package com.uisrael.clienteweb.model.dto.response;

import java.time.LocalTime;

public class HorarioRetiroResponseDto {
	
	private int idHorarioRetiro;
	private LocalTime hrInicio;
	private LocalTime hrFin;
	
	public HorarioRetiroResponseDto() {
	}

	public int getIdHorarioRetiro() {
		return idHorarioRetiro;
	}

	public void setIdHorarioRetiro(int idHorarioRetiro) {
		this.idHorarioRetiro = idHorarioRetiro;
	}

	public LocalTime getHrInicio() {
		return hrInicio;
	}

	public void setHrInicio(LocalTime hrInicio) {
		this.hrInicio = hrInicio;
	}

	public LocalTime getHrFin() {
		return hrFin;
	}

	public void setHrFin(LocalTime hrFin) {
		this.hrFin = hrFin;
	}


	
	
}
