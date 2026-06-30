package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.dominio.repositorios.IClienteRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{
	
	private final IClienteRepositorio repositorio;

	public ClienteUseCaseImpl(IClienteRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		return repositorio.guardar(nuevoCliente);
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return repositorio.buscarId(idCliente)
				.orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Cliente> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idCliente) {
		repositorio.eliminar(idCliente);
		
	}

}
