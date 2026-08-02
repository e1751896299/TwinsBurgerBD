package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.request.AdministradorRequestDto;
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

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("administrador", new AdministradorRequestDto());
		return "/administrador/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		AdministradorResponseDto existente = servicioAdmin.buscarPorId(id);
		AdministradorRequestDto administrador = new AdministradorRequestDto();
		administrador.setIdAdmin(existente.getIdAdmin());
		administrador.setAdminNombre(existente.getAdminNombre());
		administrador.setAdminApellido(existente.getAdminApellido());
		administrador.setAdminCorreo(existente.getAdminCorreo());
<<<<<<< HEAD
=======
		administrador.setAdminContrasena(existente.getAdminContrasena());
>>>>>>> 3347d3e92094bc42e2f20cd536cbc2fc2cd9c596
		model.addAttribute("administrador", administrador);
		return "/administrador/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute AdministradorRequestDto administrador) {
		servicioAdmin.crear(administrador);
		return "redirect:/administrador";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioAdmin.eliminar(id);
	    return "redirect:/administrador";
	}

}
