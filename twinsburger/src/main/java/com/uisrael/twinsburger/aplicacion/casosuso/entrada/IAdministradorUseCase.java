package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Administrador;

public interface IAdministradorUseCase {
	
	Administrador guardar(Administrador nuevoAdministrador);
	Administrador buscarPorId(int idAdministrador);
	List<Administrador> listarTodos();
	void eliminar(int idAdministrador);

}
