package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.response.AdministradorResponseDto;
import com.uisrael.clienteweb.services.IAdministradorService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {
	
	@Autowired
	public IAdministradorService servicioAdmin;
	
	public AdministradorController(IAdministradorService servicioAdmin) {
		this.servicioAdmin = servicioAdmin;
	}

	@GetMapping
	public String listar(Model model) {
		
		List<AdministradorResponseDto> resultadoBD = servicioAdmin.listarAdministrador();
		model.addAttribute("administradores", resultadoBD);
		return "/administrador/lista";
	}

}
