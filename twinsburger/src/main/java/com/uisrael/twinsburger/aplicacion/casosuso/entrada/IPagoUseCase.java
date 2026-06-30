package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Pago;

public interface IPagoUseCase {
	
	Pago guardar(Pago nuevoPago);
	Pago buscarPorId(int idPago);
	List<Pago> listarTodos();
	void eliminar(int idPago);

}
