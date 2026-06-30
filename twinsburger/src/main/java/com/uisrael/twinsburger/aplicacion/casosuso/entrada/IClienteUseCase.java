package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Cliente;

public interface IClienteUseCase {
	
	Cliente guardar(Cliente nuevoCliente);
	Cliente buscarPorId(int idCliente);
	List<Cliente> listarTodos();
	void eliminar(int idCliente);

}
