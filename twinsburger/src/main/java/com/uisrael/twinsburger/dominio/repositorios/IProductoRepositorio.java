package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Producto;

public interface IProductoRepositorio {
	
	Producto guardar(Producto nuevoProducto);
	
	Optional<Producto> buscarId(int idProducto);
	
	List<Producto> listaTodos();
	
	void eliminar(int idProducto); 


}
