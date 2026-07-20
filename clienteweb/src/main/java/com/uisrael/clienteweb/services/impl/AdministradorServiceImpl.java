package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.clienteweb.model.dto.response.AdministradorResponseDto;
import com.uisrael.clienteweb.services.IAdministradorService;

@Service
public class AdministradorServiceImpl implements IAdministradorService{
	
	private final WebClient webClient;

	public AdministradorServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public List<AdministradorResponseDto> listarAdministrador() {
		return webClient.get().uri("/administrador").retrieve().bodyToFlux(AdministradorResponseDto.class).collectList().block();
	}

}
