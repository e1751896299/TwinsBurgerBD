package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.response.MetodoPagoResponseDto;
import com.uisrael.clienteweb.model.dto.request.MetodoPagoRequestDto;

public interface IMetodoPagoService {
	
	List<MetodoPagoResponseDto> listarMetodoPago();
	MetodoPagoResponseDto buscarPorId(int id);
	void guardar(MetodoPagoRequestDto metodo);
	void eliminar(int id);

}
