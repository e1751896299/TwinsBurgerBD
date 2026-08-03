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
		   return webClient.get().uri("/detallepedido").retrieve().bodyToFlux(DetallePedidoResponseDto.class).collectList().block();
		}

	@Override
	public List<DetallePedidoResponseDto> listarPorPedido(int idPedido) {

	    return webClient.get().uri("/detallepedido/idPedido/{idPedido}", idPedido).retrieve().bodyToFlux(DetallePedidoResponseDto.class).collectList().block();
	}

}
