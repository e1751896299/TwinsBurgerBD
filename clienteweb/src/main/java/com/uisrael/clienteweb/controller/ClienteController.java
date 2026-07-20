package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String listar() {
		List<ClienteResponseDto> resultadoBD = servicioCliente.listarCliente();
		System.out.println(resultadoBD);
		return "/cliente/lista";
	}

}
