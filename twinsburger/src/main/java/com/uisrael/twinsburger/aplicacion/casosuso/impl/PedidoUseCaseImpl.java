package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPedidoUseCase;
import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.dominio.repositorios.IPedidoRepositorio;

public class PedidoUseCaseImpl implements IPedidoUseCase{
	
	private final IPedidoRepositorio repositorio;
	
	public PedidoUseCaseImpl(IPedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public Pedido guardar(Pedido nuevoPedido) {
		return repositorio.guardar(nuevoPedido);
	}

	@Override
	public Pedido buscarPorId(int idPedido) {
		return repositorio.buscarId(idPedido)
				.orElseThrow(()-> new RuntimeException("Pedido no encontrado"));
	}

	@Override
	public List<Pedido> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idPedido) {
		repositorio.eliminar(idPedido);
	}

}
