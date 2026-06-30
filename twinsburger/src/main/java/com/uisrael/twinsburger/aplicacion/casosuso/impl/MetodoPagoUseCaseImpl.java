package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IMetodoPagoUseCase;
import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.dominio.repositorios.IMetodoPagoRepositorio;

public class MetodoPagoUseCaseImpl implements IMetodoPagoUseCase{
	
	private final IMetodoPagoRepositorio repositorio;

	public MetodoPagoUseCaseImpl(IMetodoPagoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public MetodoPago guardar(MetodoPago nuevoMetodoPago) {
		return repositorio.guardar(nuevoMetodoPago);
	}

	@Override
	public MetodoPago buscarPorId(int idMetodoPago) {
		return repositorio.buscarId(idMetodoPago)
				.orElseThrow(()-> new RuntimeException("Metodo de Pago no encontrado"));
	}

	@Override
	public List<MetodoPago> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idMetodoPago) {
		repositorio.eliminar(idMetodoPago);
	}

}
