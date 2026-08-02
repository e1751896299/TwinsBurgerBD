package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;

public interface IDetalleOrdenCompraUseCase {

	DetalleOrdenCompra crear(DetalleOrdenCompra detalle);

	DetalleOrdenCompra buscarPorId(int idDetalle);

	List<DetalleOrdenCompra> listarTodos();

	void eliminar(int idDetalle);

	List<DetalleOrdenCompra> obtenerDetalleOrdenCompra(Integer idOrdenCompra);

}
