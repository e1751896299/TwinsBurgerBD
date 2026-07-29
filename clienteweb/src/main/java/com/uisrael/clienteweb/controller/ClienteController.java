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

import com.uisrael.clienteweb.model.dto.request.ClienteRequestDto;
import com.uisrael.clienteweb.model.dto.response.ClienteResponseDto;
import com.uisrael.clienteweb.services.IClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	public IClienteService servicioCliente;

	public ClienteController(IClienteService servicioCliente) {
		this.servicioCliente = servicioCliente;
	}

	@GetMapping
	public String listar(Model model) {
		List<ClienteResponseDto> resultadoBD = servicioCliente.listarCliente();
		model.addAttribute("clientes", resultadoBD);
		return "/cliente/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("cliente", new ClienteRequestDto());
		return "/cliente/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute ClienteRequestDto cliente) {
		servicioCliente.crear(cliente);
		return "redirect:/cliente";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioCliente.eliminar(id);
	    return "redirect:/cliente";
	}

}
