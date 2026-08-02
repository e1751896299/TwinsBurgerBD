package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.ComboDetalleRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboDetalleResponseDto;
import com.uisrael.clienteweb.services.IComboDetalleService;

@Service
public class ComboDetalleServiceImpl implements IComboDetalleService {

	private final WebClient webClient;

	public ComboDetalleServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<ComboDetalleResponseDto> listarComboDetalle() {
		return webClient.get().uri("/combodetalle").retrieve().bodyToFlux(ComboDetalleResponseDto.class).collectList().block();
	}

	@Override
	public ComboDetalleResponseDto buscarPorId(int id) {
		return webClient.get().uri("/combodetalle/{id}", id).retrieve().bodyToMono(ComboDetalleResponseDto.class).block();
	}

	@Override
	public void crear(ComboDetalleRequestDto detalle) {
		webClient.post().uri("/combodetalle").bodyValue(detalle).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
		webClient.delete().uri("/combodetalle/{id}", id).retrieve().toBodilessEntity().block();
	}

}
