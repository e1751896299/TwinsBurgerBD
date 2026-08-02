package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;

public interface IOrdenCompraUseCase {

	OrdenCompra guardar(OrdenCompra nuevaOrden);

	OrdenCompra buscarPorId(int idOrdenCompra);

	List<OrdenCompra> listarTodos();

	void eliminar(int idOrdenCompra);

}
