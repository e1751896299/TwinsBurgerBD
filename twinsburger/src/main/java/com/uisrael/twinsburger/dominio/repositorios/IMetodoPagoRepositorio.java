package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;

public interface IMetodoPagoRepositorio {
	
	MetodoPago guardar(MetodoPago nuevoMetodoPago);
	
	Optional<MetodoPago> buscarId(int idMetodoPago);
	
	List<MetodoPago> listaTodos();
	
	void eliminar(int idMetodoPago); 


}
