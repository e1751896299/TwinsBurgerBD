package com.uisrael.clienteweb.services.impl;

import com.uisrael.clienteweb.model.dto.request.CambioEstadoPedidoRequestDto;
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
	public PedidoResponseDto buscarPorId(int id) {
		return webClient.get().uri("/pedido/{id}", id).retrieve().bodyToMono(PedidoResponseDto.class).block();
	}

	@Override
	public void crear(PedidoRequestDto pedido) {
		webClient.post().uri("/pedido").bodyValue(pedido).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
	    webClient.delete()
	            .uri("/pedido/{id}", id).retrieve().toBodilessEntity().block();
	}

	@Override
	public List<PedidoResponseDto> listarPorCliente(int idCliente) {

	    return webClient.get().uri("/pedido/idCliente/{idCliente}", idCliente).retrieve().bodyToFlux(PedidoResponseDto.class).collectList().block();
	}

	@Override
	public void cambiarEstado(int idPedido, String estado) {
		CambioEstadoPedidoRequestDto request = new CambioEstadoPedidoRequestDto(estado);

		webClient.patch().uri("/pedido/{idPedido}/estado", idPedido).bodyValue(request).retrieve().toBodilessEntity().block();
		
	}

}
