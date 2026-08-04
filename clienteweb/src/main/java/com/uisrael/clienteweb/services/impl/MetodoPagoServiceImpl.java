package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.MetodoPagoResponseDto;
import com.uisrael.clienteweb.model.dto.request.MetodoPagoRequestDto;
import com.uisrael.clienteweb.services.IMetodoPagoService;

@Service
public class MetodoPagoServiceImpl implements IMetodoPagoService{
	
	private final WebClient webClient;


	public MetodoPagoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}
	@Override public MetodoPagoResponseDto buscarPorId(int id) {
		return webClient.get().uri("/metodopago/{id}", id).retrieve().bodyToMono(MetodoPagoResponseDto.class).block();
	}
	@Override public void guardar(MetodoPagoRequestDto metodo) {
		webClient.post().uri("/metodopago").bodyValue(metodo).retrieve().toBodilessEntity().block();
	}
	@Override public void eliminar(int id) {
		webClient.delete().uri("/metodopago/{id}", id).retrieve().toBodilessEntity().block();
	}


	@Override
	public List<MetodoPagoResponseDto> listarMetodoPago() {
		return webClient.get().uri("/metodopago").retrieve().bodyToFlux(MetodoPagoResponseDto.class).collectList().block();


	}

}
