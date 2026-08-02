package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.request.DetalleOrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.DetalleOrdenCompraResponseDto;
import com.uisrael.clienteweb.services.IDetalleOrdenCompraService;

@Service
public class DetalleOrdenCompraServiceImpl implements IDetalleOrdenCompraService {

	private final WebClient webClient;

	public DetalleOrdenCompraServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<DetalleOrdenCompraResponseDto> listarDetalleOrdenCompra() {
		return webClient.get().uri("/detalleordencompra").retrieve().bodyToFlux(DetalleOrdenCompraResponseDto.class).collectList().block();
	}

	@Override
	public DetalleOrdenCompraResponseDto buscarPorId(int id) {
		return webClient.get().uri("/detalleordencompra/{id}", id).retrieve().bodyToMono(DetalleOrdenCompraResponseDto.class).block();
	}

	@Override
	public void crear(DetalleOrdenCompraRequestDto detalle) {
		webClient.post().uri("/detalleordencompra").bodyValue(detalle).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
		webClient.delete().uri("/detalleordencompra/{id}", id).retrieve().toBodilessEntity().block();
	}

}
