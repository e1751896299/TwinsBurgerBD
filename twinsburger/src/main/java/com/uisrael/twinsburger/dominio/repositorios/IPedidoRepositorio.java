package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pedido;


public interface IPedidoRepositorio {
	
	Pedido guardar(Pedido nuevoPedido);
	
	Optional<Pedido> buscarId(int idPedido);
	
	List<Pedido> listaTodos();
	
	void eliminar(int idPedido); 


}
