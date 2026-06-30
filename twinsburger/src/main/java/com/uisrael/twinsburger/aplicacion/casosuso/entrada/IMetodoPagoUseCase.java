package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;

public interface IMetodoPagoUseCase {
	
	MetodoPago guardar(MetodoPago nuevoMetodoPago);
	MetodoPago buscarPorId(int idMetodoPago);
	List<MetodoPago> listarTodos();
	void eliminar(int idMetodoPago);

}
