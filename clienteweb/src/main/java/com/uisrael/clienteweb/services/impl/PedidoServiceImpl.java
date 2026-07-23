package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.PedidoRequestDto;
import com.uisrael.clienteweb.model.dto.response.PedidoResponseDto;
import com.uisrael.clienteweb.services.IPedidoService;

@Service
public class PedidoServiceImpl implements IPedidoService{

	private final WebClient webClient;

	public PedidoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<PedidoResponseDto> listarPedido() {
		return webClient.get().uri("/pedido").retrieve().bodyToFlux(PedidoResponseDto.class).collectList().block();

	}

	@Override
	public void crear(PedidoRequestDto pedido) {
		webClient.post().uri("/pedido").bodyValue(pedido).retrieve().toBodilessEntity().block();
	}

}
