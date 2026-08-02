package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IOrdenCompraUseCase;
import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;
import com.uisrael.twinsburger.dominio.repositorios.IOrdenCompraRepositorio;

public class OrdenCompraUseCaseImpl implements IOrdenCompraUseCase {

	private final IOrdenCompraRepositorio repositorio;

	public OrdenCompraUseCaseImpl(IOrdenCompraRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public OrdenCompra guardar(OrdenCompra nuevaOrden) {
		return repositorio.guardar(nuevaOrden);
	}

	@Override
	public OrdenCompra buscarPorId(int idOrdenCompra) {
		return repositorio.buscarId(idOrdenCompra)
				.orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));
	}

	@Override
	public List<OrdenCompra> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idOrdenCompra) {
		OrdenCompra orden = buscarPorId(idOrdenCompra);
		orden.setOcEstado(false);
		repositorio.guardar(orden);
	}

}
