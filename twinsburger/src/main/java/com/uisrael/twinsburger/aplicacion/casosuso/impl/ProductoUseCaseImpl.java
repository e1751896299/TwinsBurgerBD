package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.dominio.repositorios.IProductoRepositorio;

public class ProductoUseCaseImpl implements IProductoUseCase{
	
	private final IProductoRepositorio repositorio;
	

	public ProductoUseCaseImpl(IProductoRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		return repositorio.guardar(nuevoProducto);
	}

	@Override
	public Producto buscarPorId(int idProducto) {
		return repositorio.buscarId(idProducto)
				.orElseThrow(()-> new RuntimeException("Producto no encontrado"));
	}

	@Override
	public List<Producto> listarTodo() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idProducto) {
		repositorio.eliminar(idProducto);
		
	}

}
