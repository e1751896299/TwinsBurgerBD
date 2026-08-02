package com.uisrael.clienteweb.configuration;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import com.uisrael.clienteweb.model.dto.request.LoginRequestDto;
import com.uisrael.clienteweb.model.dto.response.LoginResponseDto;

@Component
public class ApiAuthenticationProvider implements AuthenticationProvider {

	private final WebClient webClient;

	public ApiAuthenticationProvider(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String correo = authentication.getName().trim().toLowerCase();
		String contrasena = authentication.getCredentials().toString();

		try {
			LoginResponseDto usuario = webClient.post()
					.uri("/auth/login")
					.bodyValue(new LoginRequestDto(correo, contrasena))
					.retrieve()
					.bodyToMono(LoginResponseDto.class)
					.block();

			if (usuario == null) {
				throw new BadCredentialsException("Credenciales incorrectas");
			}

			UsuarioAutenticado principal = new UsuarioAutenticado(
					usuario.id(), usuario.nombre(), usuario.correo(), usuario.rol());
			return UsernamePasswordAuthenticationToken.authenticated(
					principal, null, principal.getAuthorities());
		} catch (WebClientResponseException.Unauthorized ex) {
			throw new BadCredentialsException("Credenciales incorrectas");
		} catch (WebClientRequestException ex) {
			throw new AuthenticationServiceException("La API de Twins Burger no está disponible", ex);
		} catch (WebClientResponseException ex) {
			throw new AuthenticationServiceException("No se pudo validar el inicio de sesión", ex);
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}
}
