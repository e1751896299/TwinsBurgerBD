package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;

public interface IDetallePedidoRepositorio {
	
	DetallePedido guardar(DetallePedido nuevoDetalle);
	
	Optional<DetallePedido> buscarId(int idDetalle);
	
	List<DetallePedido> listarTodos();
	
	void eliminar(int idDetalle);

}
