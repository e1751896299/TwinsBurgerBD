package com.uisrael.twinsburger.presentacion.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.presentacion.dto.request.LoginRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.LoginResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private final IAdministradorUseCase administradorUseCase;
	private final IClienteUseCase clienteUseCase;
	private final PasswordEncoder passwordEncoder;

	public AuthController(IAdministradorUseCase administradorUseCase,
			IClienteUseCase clienteUseCase, PasswordEncoder passwordEncoder) {
		this.administradorUseCase = administradorUseCase;
		this.clienteUseCase = clienteUseCase;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.OK)
	public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request) {
		String correo = request.correo().trim().toLowerCase();

		try {
			Administrador admin = administradorUseCase.findByAdminCorreo(correo);
			if (admin.isAdminEstado() && contrasenaValida(request.contrasena(), admin.getAdminContrasena())) {
				migrarContrasenaAdministrador(admin, request.contrasena());
				return new LoginResponseDto(admin.getIdAdmin(),
						admin.getAdminNombre() + " " + admin.getAdminApellido(), correo, "ADMIN");
			}
		} catch (RuntimeException ignored) {
			// Se intenta como cliente sin revelar si el correo existe.
		}

		try {
			Cliente cliente = clienteUseCase.findByCliCorreo(correo);
			if (cliente.isCliEstado() && contrasenaValida(request.contrasena(), cliente.getCliContrasena())) {
				migrarContrasenaCliente(cliente, request.contrasena());
				return new LoginResponseDto(cliente.getIdCliente(),
						cliente.getCliNombre() + " " + cliente.getCliApellido(), correo, "CLIENTE");
			}
		} catch (RuntimeException ignored) {
			// La respuesta es deliberadamente genérica.
		}

		throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales incorrectas");
	}

	private boolean contrasenaValida(String enviada, String almacenada) {
		if (almacenada == null || almacenada.isBlank()) {
			return false;
		}
		return almacenada.startsWith("$2")
				? passwordEncoder.matches(enviada, almacenada)
				: enviada.equals(almacenada);
	}

	private void migrarContrasenaAdministrador(Administrador admin, String contrasena) {
		if (!admin.getAdminContrasena().startsWith("$2")) {
			admin.setAdminContrasena(contrasena);
			administradorUseCase.guardar(admin);
		}
	}

	private void migrarContrasenaCliente(Cliente cliente, String contrasena) {
		if (!cliente.getCliContrasena().startsWith("$2")) {
			cliente.setCliContrasena(contrasena);
			clienteUseCase.guardar(cliente);
		}
	}
}
