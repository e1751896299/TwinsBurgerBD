package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.HorarioRetiroRequestDto;
import com.uisrael.clienteweb.model.dto.response.HorarioRetiroResponseDto;
import com.uisrael.clienteweb.services.IHorarioRetiroService;

@Service
public class HorarioRetiroServiceImpl implements IHorarioRetiroService{

	private final WebClient webClient;

	public HorarioRetiroServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<HorarioRetiroResponseDto> listarHorarioRetiro() {
		return webClient.get().uri("/horarioretiro").retrieve().bodyToFlux(HorarioRetiroResponseDto.class).collectList().block();


	}

	@Override
	public HorarioRetiroResponseDto buscarPorId(int id) {
		return webClient.get().uri("/horarioretiro/{id}", id).retrieve().bodyToMono(HorarioRetiroResponseDto.class).block();
	}

	@Override
	public void crear(HorarioRetiroRequestDto horarioRetiro) {
		webClient.post().uri("/horarioretiro").bodyValue(horarioRetiro).retrieve().toBodilessEntity().block();
	}

}
