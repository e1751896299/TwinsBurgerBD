package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.response.MetodoPagoResponseDto;

public interface IMetodoPagoService {
	
	List<MetodoPagoResponseDto> listarMetodoPago();

}
