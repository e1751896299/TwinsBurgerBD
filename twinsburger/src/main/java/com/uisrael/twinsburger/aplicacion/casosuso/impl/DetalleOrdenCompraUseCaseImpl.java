package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetalleOrdenCompraUseCase;
import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;
import com.uisrael.twinsburger.dominio.repositorios.IDetalleOrdenCompraRepositorio;

public class DetalleOrdenCompraUseCaseImpl implements IDetalleOrdenCompraUseCase {

	private final IDetalleOrdenCompraRepositorio repositorio;

	public DetalleOrdenCompraUseCaseImpl(IDetalleOrdenCompraRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public DetalleOrdenCompra crear(DetalleOrdenCompra detalle) {
		return repositorio.guardar(detalle);
	}

	@Override
	public DetalleOrdenCompra buscarPorId(int idDetalle) {
		return repositorio.buscarId(idDetalle)
				.orElseThrow(() -> new RuntimeException("Detalle de orden de compra no encontrado"));
	}

	@Override
	public List<DetalleOrdenCompra> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDetalle) {
		DetalleOrdenCompra detalle = buscarPorId(idDetalle);
		detalle.setDocEstado(false);
		repositorio.guardar(detalle);
	}

	@Override
	public List<DetalleOrdenCompra> obtenerDetalleOrdenCompra(Integer idOrdenCompra) {
		return repositorio.obtenerDetalleOrdenCompra(idOrdenCompra);
	}

}
