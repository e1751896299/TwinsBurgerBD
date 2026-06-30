package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Producto;

public interface IProductoUseCase {
	
	Producto guardar(Producto nuevoProducto);
	Producto buscarPorId(int idProducto);
	List<Producto> listarTodo();
	void eliminar(int idProducto);

}
