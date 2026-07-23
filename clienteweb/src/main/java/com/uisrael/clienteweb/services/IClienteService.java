package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.ClienteRequestDto;
import com.uisrael.clienteweb.model.dto.response.ClienteResponseDto;

public interface IClienteService {

	List<ClienteResponseDto> listarCliente();

	void crear(ClienteRequestDto cliente);

}
