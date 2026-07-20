package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.response.HorarioRetiroResponseDto;
import com.uisrael.clienteweb.services.IHorarioRetiroService;

@Controller
@RequestMapping("/horario")
public class HorarioRetiroController {
	
	@Autowired
	public IHorarioRetiroService servicioHorarioRetiro;

	public HorarioRetiroController(IHorarioRetiroService servicioHorarioRetiro) {
		this.servicioHorarioRetiro = servicioHorarioRetiro;
	}

	@GetMapping
	public String listar() {
		List<HorarioRetiroResponseDto> resultadoBD = servicioHorarioRetiro.listarHorarioRetiro();
		System.out.println(resultadoBD);
		return "/horario/lista";
	}

}
