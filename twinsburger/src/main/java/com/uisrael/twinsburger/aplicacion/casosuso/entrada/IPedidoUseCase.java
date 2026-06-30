package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Pedido;

public interface IPedidoUseCase {
	
	Pedido guardar(Pedido nuevoPedido);
	Pedido buscarPorId(int idPedido);
	List<Pedido> listarTodos();
	void eliminar(int idPedido);

}
