package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.DetallePedidoResponseDto;
import com.uisrael.clienteweb.services.IDetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements IDetallePedidoService {
	
	private final WebClient webClient;

	public DetallePedidoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<DetallePedidoResponseDto> listarDetallePedido() {
		return webClient.get().uri("/detalleproducto").retrieve().bodyToFlux(DetallePedidoResponseDto.class).collectList().block();

	}

}
