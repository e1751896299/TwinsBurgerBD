package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pago;


public interface IPagoRepositorio {
	
	Pago guardar(Pago nuevoPago);
	
	Optional<Pago> buscarId(int idPago);
	
	List<Pago> listaTodos();
	
	void eliminar(int idPago); 


}
