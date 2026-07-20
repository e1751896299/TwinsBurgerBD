package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.PagoResponseDto;
import com.uisrael.clienteweb.services.IPagoService;

public class PagoServiceImpl implements IPagoService{
	
	private final WebClient webClient;

	public PagoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<PagoResponseDto> listarPago() {
		return webClient.get().uri("/pago").retrieve().bodyToFlux(PagoResponseDto.class).collectList().block();

	}

}
