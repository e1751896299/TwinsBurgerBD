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

import com.uisrael.clienteweb.model.dto.request.CategoriaRequestDto;
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
	public String listar(Model model) {
		List<CategoriaResponseDto> resultadoBD = servicioCategoria.listarCategoria();
		model.addAttribute("categorias", resultadoBD);
		return "/categoria/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("categoria", new CategoriaRequestDto());
		return "/categoria/editar";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		CategoriaResponseDto existente = servicioCategoria.buscarPorId(id);
		CategoriaRequestDto categoria = new CategoriaRequestDto();
		categoria.setIdCategoria(existente.getIdCategoria());
		categoria.setCategoriaNombre(existente.getCategoriaNombre());
		categoria.setCategoriaDescripcion(existente.getCategoriaDescripcion());
		model.addAttribute("categoria", categoria);
		return "/categoria/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute CategoriaRequestDto categoria) {
		servicioCategoria.crear(categoria);
		return "redirect:/categoria";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioCategoria.eliminar(id);
	    return "redirect:/categoria";
	}

}
