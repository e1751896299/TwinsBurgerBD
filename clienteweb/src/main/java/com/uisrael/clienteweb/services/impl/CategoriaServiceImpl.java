package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.CategoriaRequestDto;
import com.uisrael.clienteweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.clienteweb.services.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService{

	public final WebClient webClient;

	public CategoriaServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<CategoriaResponseDto> listarCategoria() {
		return webClient.get().uri("/categoria").retrieve().bodyToFlux(CategoriaResponseDto.class).collectList().block();

	}

	@Override
	public CategoriaResponseDto buscarPorId(int id) {
		return webClient.get().uri("/categoria/{id}", id).retrieve().bodyToMono(CategoriaResponseDto.class).block();
	}

	@Override
	public void crear(CategoriaRequestDto categoria) {
		webClient.post().uri("/categoria").bodyValue(categoria).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
	    webClient.delete()
	            .uri("/categoria/{id}", id).retrieve().toBodilessEntity().block();
	}

}
