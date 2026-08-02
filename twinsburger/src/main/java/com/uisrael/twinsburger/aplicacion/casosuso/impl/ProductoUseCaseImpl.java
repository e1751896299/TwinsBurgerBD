package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.time.LocalDateTime;
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

		    if (nuevoProducto.getIdProducto() == 0) {

		        nuevoProducto.setProFechaCreacion(
		                LocalDateTime.now()
		        );

		        nuevoProducto.setProdEstado(true);

		    } else {

		        Producto productoActual =
		                buscarPorId(nuevoProducto.getIdProducto());

		        nuevoProducto.setProFechaCreacion(
		                productoActual.getProFechaCreacion()
		        );

		        nuevoProducto.setProdEstado(
		                productoActual.isProdEstado()
		        );
		    }

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
		Producto producto = buscarPorId(idProducto);

		    producto.setProdEstado(false);

		    repositorio.guardar(producto);
		
	}

	@Override
	public List<Producto> findByProdNombre(String nombre) {
		return repositorio.findByProdNombre(nombre);
	}

	@Override
	public List<Producto> buscarPorCategoria(Integer idCategoria) {
		return repositorio.buscarPorCategoria(idCategoria);
	}


}
