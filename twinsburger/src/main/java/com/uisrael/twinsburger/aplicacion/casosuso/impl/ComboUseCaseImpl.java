package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboUseCase;
import com.uisrael.twinsburger.dominio.entidades.Combo;
import com.uisrael.twinsburger.dominio.repositorios.IComboRepositorio;

public class ComboUseCaseImpl implements IComboUseCase {

	private final IComboRepositorio repositorio;

	public ComboUseCaseImpl(IComboRepositorio repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public Combo guardar(Combo nuevoCombo) {
		return repositorio.guardar(nuevoCombo);
	}

	@Override
	public Combo buscarPorId(int idCombo) {
		return repositorio.buscarId(idCombo)
				.orElseThrow(() -> new RuntimeException("Combo no encontrado"));
	}

	@Override
	public List<Combo> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idCombo) {
		Combo combo = buscarPorId(idCombo);
		combo.setComboEstado(false);
		repositorio.guardar(combo);
	}

}
