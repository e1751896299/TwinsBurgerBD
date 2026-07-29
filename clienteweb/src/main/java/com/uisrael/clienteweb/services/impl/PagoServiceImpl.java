package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.PagoRequestDto;
import com.uisrael.clienteweb.model.dto.response.PagoResponseDto;
import com.uisrael.clienteweb.services.IPagoService;

@Service
public class PagoServiceImpl implements IPagoService{

	private final WebClient webClient;

	public PagoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<PagoResponseDto> listarPago() {
		return webClient.get().uri("/pago").retrieve().bodyToFlux(PagoResponseDto.class).collectList().block();

	}

	@Override
	public void crear(PagoRequestDto pago) {
		webClient.post().uri("/pago").bodyValue(pago).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
	    webClient.delete()
	            .uri("/pago/{id}", id).retrieve().toBodilessEntity().block();
	}

}
