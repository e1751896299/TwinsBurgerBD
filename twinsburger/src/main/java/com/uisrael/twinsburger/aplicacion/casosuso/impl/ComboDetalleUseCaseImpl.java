package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboDetalleUseCase;
import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;
import com.uisrael.twinsburger.dominio.repositorios.IComboDetalleRepositorio;

public class ComboDetalleUseCaseImpl implements IComboDetalleUseCase {

	private final IComboDetalleRepositorio repositorio;

	public ComboDetalleUseCaseImpl(IComboDetalleRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public ComboDetalle crear(ComboDetalle detalle) {
		return repositorio.guardar(detalle);
	}

	@Override
	public ComboDetalle buscarPorId(int idDetalle) {
		return repositorio.buscarId(idDetalle)
				.orElseThrow(() -> new RuntimeException("Detalle de combo no encontrado"));
	}

	@Override
	public List<ComboDetalle> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDetalle) {
		ComboDetalle detalle = buscarPorId(idDetalle);
		detalle.setCdEstado(false);
		repositorio.guardar(detalle);
	}

	@Override
	public List<ComboDetalle> obtenerComboDetalle(Integer idCombo) {
		return repositorio.obtenerComboDetalle(idCombo);
	}

}
