package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Categoria;

public interface ICategoriaRepositorio {
	
	Categoria guardar(Categoria nuevaCategoria);
	
	Optional<Categoria> buscarId(int idCategoria);
	
	List<Categoria> listaTodos();
	
	void eliminar(int idCategoria); 


}
