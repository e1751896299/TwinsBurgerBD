package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.dominio.repositorios.IAdministradorRepositorio;

public class AdministradorUseCaseImpl implements IAdministradorUseCase{
	
	private final IAdministradorRepositorio repositorio;
	
	public AdministradorUseCaseImpl(IAdministradorRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Administrador guardar(Administrador nuevoAdministrador) {
		return repositorio.guardar(nuevoAdministrador);
	}

	@Override
	public Administrador buscarPorId(int idAdministrador) {
		return repositorio.buscarId(idAdministrador)
				.orElseThrow(() -> new RuntimeException("Equipo no encontrado"));
	}

	@Override
	public List<Administrador> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idAdministrador) {
		repositorio.eliminar(idAdministrador);
	}

}
