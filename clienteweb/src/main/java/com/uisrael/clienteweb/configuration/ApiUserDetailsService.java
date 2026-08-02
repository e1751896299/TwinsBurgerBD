package com.uisrael.clienteweb.configuration;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.clienteweb.model.dto.response.AdministradorResponseDto;
import com.uisrael.clienteweb.model.dto.response.ClienteResponseDto;

@Service
public class ApiUserDetailsService implements UserDetailsService {

	private final WebClient webClient;

	public ApiUserDetailsService(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String correo = username.trim().toLowerCase();

		try {
			AdministradorResponseDto admin = webClient.get()
					.uri(uri -> uri.path("/administrador/correo/{correo}").build(correo))
					.retrieve()
					.bodyToMono(AdministradorResponseDto.class)
					.block();
			if (admin != null && admin.isAdminEstado()) {
				return new UsuarioAutenticado(admin.getIdAdmin(),
						admin.getAdminNombre() + " " + admin.getAdminApellido(), correo, "ADMIN");
			}
		} catch (WebClientResponseException ignored) {
			// Si no es administrador se intenta como cliente.
		}

		try {
			ClienteResponseDto cliente = webClient.get()
					.uri(uri -> uri.path("/cliente/correo/{correo}").build(correo))
					.retrieve()
					.bodyToMono(ClienteResponseDto.class)
					.block();
			if (cliente != null && cliente.isCliEstado()) {
				return new UsuarioAutenticado(cliente.getIdCliente(),
						cliente.getCliNombre() + " " + cliente.getCliApellido(), correo, "CLIENTE");
			}
		} catch (WebClientResponseException ignored) {
			// La respuesta no revela qué tipo de cuenta se buscó.
		}

		throw new UsernameNotFoundException("Usuario no encontrado o inactivo");
	}
}
