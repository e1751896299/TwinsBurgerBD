package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;

public interface IDetalleOrdenCompraRepositorio {

	DetalleOrdenCompra guardar(DetalleOrdenCompra nuevoDetalle);

	Optional<DetalleOrdenCompra> buscarId(int idDetalle);

	List<DetalleOrdenCompra> listarTodos();

	void eliminar(int idDetalle);

	List<DetalleOrdenCompra> obtenerDetalleOrdenCompra(Integer idOrdenCompra);

}
