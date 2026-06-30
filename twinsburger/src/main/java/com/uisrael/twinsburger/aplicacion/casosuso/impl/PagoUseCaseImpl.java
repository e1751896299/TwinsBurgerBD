package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPagoUseCase;
import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.dominio.repositorios.IPagoRepositorio;

public class PagoUseCaseImpl implements IPagoUseCase{
	
	private final IPagoRepositorio repositorio;
	
	public PagoUseCaseImpl(IPagoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Pago guardar(Pago nuevoPago) {
		return repositorio.guardar(nuevoPago);
	}

	@Override
	public Pago buscarPorId(int idPago) {
		return repositorio.buscarId(idPago)
				.orElseThrow(()-> new RuntimeException("Pago no encontrado"));
	}

	@Override
	public List<Pago> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idPago) {
		repositorio.eliminar(idPago);
	}

}
