package com.uisrael.clienteweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.clienteweb.model.dto.response.AdministradorResponseDto;
import com.uisrael.clienteweb.services.IAdministradorService;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

	private final IAdministradorService servicioAdministrador;

	public LoginController(IAdministradorService servicioAdministrador) {
		this.servicioAdministrador = servicioAdministrador;
	}

	@GetMapping("/login")
	public String mostrarFormulario() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String correo, @RequestParam String contrasena, HttpSession session, Model model) {
		AdministradorResponseDto administrador = servicioAdministrador.buscarPorCorreo(correo);
		if (administrador == null || !administrador.getAdminContrasena().equals(contrasena)) {
			model.addAttribute("error", "Correo o contraseña incorrectos");
			return "login";
		}
		session.setAttribute("adminLogueado", administrador);
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}

}
