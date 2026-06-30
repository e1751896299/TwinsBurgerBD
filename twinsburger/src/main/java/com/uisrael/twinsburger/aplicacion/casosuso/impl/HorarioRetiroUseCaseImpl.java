package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IHorarioRetiroUseCase;
import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.dominio.repositorios.IHorarioRetiroRepositorio;

public class HorarioRetiroUseCaseImpl implements IHorarioRetiroUseCase{
	
	private final IHorarioRetiroRepositorio repositorio;
	
	public HorarioRetiroUseCaseImpl(IHorarioRetiroRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public HorarioRetiro guardar(HorarioRetiro nuevoHorarioRetiro) {
		return repositorio.guardar(nuevoHorarioRetiro);
	}

	@Override
	public HorarioRetiro buscarPorId(int idHorarioRetiro) {
		return repositorio.buscarId(idHorarioRetiro)
				.orElseThrow(()-> new RuntimeException("Horario no encontrado"));
	}

	@Override
	public List<HorarioRetiro> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idHorarioRetiro) {
		repositorio.eliminar(idHorarioRetiro);
	}

}
