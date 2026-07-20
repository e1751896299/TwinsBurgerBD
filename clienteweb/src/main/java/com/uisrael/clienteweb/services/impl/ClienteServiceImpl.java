package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.ClienteResponseDto;
import com.uisrael.clienteweb.services.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService{
	
	private final WebClient webClient;
	
	public ClienteServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}


	@Override
	public List<ClienteResponseDto> listarCliente() {
		return webClient.get().uri("/cliente").retrieve().bodyToFlux(ClienteResponseDto.class).collectList().block();
	}

}
