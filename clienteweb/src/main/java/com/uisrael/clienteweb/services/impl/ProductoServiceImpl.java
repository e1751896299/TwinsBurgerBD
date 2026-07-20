package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;
import com.uisrael.clienteweb.services.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	private final WebClient webClient;
	

	public ProductoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}


	@Override
	public List<ProductoResponseDto> listarProducto() {
		return webClient.get().uri("/producto").retrieve().bodyToFlux(ProductoResponseDto.class).collectList().block();
	}
	

}
