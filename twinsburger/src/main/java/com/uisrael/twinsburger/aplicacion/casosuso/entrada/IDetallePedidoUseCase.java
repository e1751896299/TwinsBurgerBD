package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;

public interface IDetallePedidoUseCase {
	
	DetallePedido crear(DetallePedido detallePedido);
	
	DetallePedido buscarPorId(int idDetalle);
	
	List<DetallePedido> listarTodos();
	
	void eliminar(int idDetalle);
		
	List<DetallePedido> obtenerDetallePedido(Integer idPedido);

}
