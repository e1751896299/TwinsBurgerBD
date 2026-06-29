package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Cliente;

public interface IClienteRepositorio {
	
	Cliente guardar(Cliente nuevoCliente);
	
	Optional<Cliente> buscarId(int idCliente);
	
	List<Cliente> listaTodos();
	
	void eliminar(int idCliente); 

}
