package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Administrador;

public interface IAdministradorRepositorio {
	
	Administrador guardar(Administrador nuevoAdministrador);
	
	Optional<Administrador> buscarId(int idAdministrador);
	
	List<Administrador> listaTodos();
	
	void eliminar(int idAdminsitrador ); 


}
