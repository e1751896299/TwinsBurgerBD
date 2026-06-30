package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;

public interface IHorarioRetiroUseCase {
	
	HorarioRetiro guardar(HorarioRetiro nuevoHorarioRetiro);
	HorarioRetiro buscarPorId(int idHorarioRetiro);
	List<HorarioRetiro> listarTodos();
	void eliminar(int idHorarioRetiro);

}
