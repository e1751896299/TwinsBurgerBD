package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.dominio.repositorios.ICategoriaRepositorio;

public class CategoriaUseCaseImpl implements ICategoriaUseCase{
	
	private final ICategoriaRepositorio repositorio;
	

	public CategoriaUseCaseImpl(ICategoriaRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Categoria guardar(Categoria nuevaCategoria) {
		return repositorio.guardar(nuevaCategoria);
	}

	@Override
	public Categoria buscarPorId(int idCategoria) {
		return repositorio.buscarId(idCategoria)
				.orElseThrow(()-> new RuntimeException("Categoria no encontrada"));
	}

	@Override
	public List<Categoria> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idCtegoria) {
		repositorio.eliminar(idCtegoria);
		
	}

}
