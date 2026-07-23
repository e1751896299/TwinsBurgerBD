package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.PagoRequestDto;
import com.uisrael.clienteweb.model.dto.response.PagoResponseDto;

public interface IPagoService {

	List<PagoResponseDto> listarPago();

	void crear(PagoRequestDto pago);

}
