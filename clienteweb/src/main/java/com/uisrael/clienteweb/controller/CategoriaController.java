package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.clienteweb.services.ICategoriaService;

@Controller
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	public ICategoriaService servicioCategoria;
	
	public CategoriaController(ICategoriaService servicioCategoria) {
		this.servicioCategoria = servicioCategoria;
	}

	@GetMapping
	public String listar() {
		List<CategoriaResponseDto> resultadoBD = servicioCategoria.listarCategoria();
		System.out.println(resultadoBD);
		return "/categoria/lista";
	}

}
