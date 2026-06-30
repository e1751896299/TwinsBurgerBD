package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Categoria;

public interface ICategoriaUseCase {
	
	Categoria guardar(Categoria nuevaCategoria);
	Categoria buscarPorId(int idCategoria);
	List<Categoria> listarTodos();
	void eliminar(int idCtegoria);

}
