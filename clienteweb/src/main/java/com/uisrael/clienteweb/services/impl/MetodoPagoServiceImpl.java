package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.MetodoPagoResponseDto;
import com.uisrael.clienteweb.services.IMetodoPagoService;

public class MetodoPagoServiceImpl implements IMetodoPagoService{
	
	private final WebClient webClient;


	public MetodoPagoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}


	@Override
	public List<MetodoPagoResponseDto> listarMetodoPago() {
		return webClient.get().uri("/metodopago").retrieve().bodyToFlux(MetodoPagoResponseDto.class).collectList().block();


	}

}
