package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;

public interface IOrdenCompraRepositorio {

	OrdenCompra guardar(OrdenCompra nuevaOrden);

	Optional<OrdenCompra> buscarId(int idOrdenCompra);

	List<OrdenCompra> listaTodos();

	void eliminar(int idOrdenCompra);

}
