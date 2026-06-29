package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;


public interface IHorarioRetiroRepositorio {
	
	HorarioRetiro guardar(HorarioRetiro nuevoHorario);
	
	Optional<HorarioRetiro> buscarId(int idHorarioRetiro);
	
	List<HorarioRetiro> listaTodos();
	
	void eliminar(int idHorarioRetiro); 


}
