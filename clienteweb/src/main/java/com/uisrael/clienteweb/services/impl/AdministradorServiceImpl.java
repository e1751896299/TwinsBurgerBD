package com.uisrael.clienteweb.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.clienteweb.model.dto.request.AdministradorRequestDto;
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

	@Override
	public AdministradorResponseDto buscarPorId(int id) {
		return webClient.get().uri("/administrador/{id}", id).retrieve().bodyToMono(AdministradorResponseDto.class).block();
	}

	@Override
	public AdministradorResponseDto buscarPorCorreo(String correo) {
		try {
			return webClient.get().uri("/administrador/correo/{correo}", correo).retrieve()
					.bodyToMono(AdministradorResponseDto.class).block();
		} catch (WebClientResponseException ex) {
			return null;
		}
	}

	@Override
	public void crear(AdministradorRequestDto administrador) {
		webClient.post().uri("/administrador").bodyValue(administrador).retrieve().toBodilessEntity().block();
	}

	@Override
	public void eliminar(int id) {
	    webClient.delete()
	            .uri("/administrador/{id}", id).retrieve().toBodilessEntity().block();
		
	}


	@Override
	public void actualizar(int id, AdministradorRequestDto administrador) {
		// TODO Auto-generated method stub
		
	}

}
