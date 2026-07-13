package com.uisrael.twinsburger.presentacion.dto.response;

import java.time.LocalTime;

public class HorarioRetiroresponseDto {
	
	private int idHorarioRetiro;
	private LocalTime hrInicio;
	private LocalTime hrFin;
	private boolean hrEstado;
	
	public HorarioRetiroresponseDto() {
		super();
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
	public boolean isHrEstado() {
		return hrEstado;
	}
	public void setHrEstado(boolean hrEstado) {
		this.hrEstado = hrEstado;
	}
	

}
