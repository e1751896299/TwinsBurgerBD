package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetallePedidoUseCase;
import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.dominio.repositorios.IDetallePedidoRepositorio;

public class DetallePedidoUseCaseImpl implements IDetallePedidoUseCase {
	
	private final IDetallePedidoRepositorio repositorio;
	

	public DetallePedidoUseCaseImpl(IDetallePedidoRepositorio repositorio) {
		super();
		this.repositorio = repositorio;
	}

	@Override
	public DetallePedido crear(DetallePedido detallePedido) {
		return repositorio.guardar(detallePedido);
	}

	@Override
	public DetallePedido buscarPorId(int idDetalle) {
		return repositorio.buscarId(idDetalle)
				.orElseThrow(() -> new RuntimeException("Detalle del pedido no encontrado"));
	}

	@Override
	public List<DetallePedido> listarTodos() {
		return repositorio.listarTodos();
	}

	@Override
	public void eliminar(int idDetalle) {
		repositorio.eliminar(idDetalle);
		
	}

}
