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

import com.uisrael.clienteweb.model.dto.request.ComboRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboResponseDto;
import com.uisrael.clienteweb.services.IComboService;

@Controller
@RequestMapping("/combo")
public class ComboController {

	@Autowired
	public IComboService servicioCombo;

	public ComboController(IComboService servicioCombo) {
		this.servicioCombo = servicioCombo;
	}

	@GetMapping
	public String listar(Model model) {
		List<ComboResponseDto> resultadoBD = servicioCombo.listarCombo();
		model.addAttribute("combos", resultadoBD);
		return "/combo/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("combo", new ComboRequestDto());
		return "/combo/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		ComboResponseDto existente = servicioCombo.buscarPorId(id);
		ComboRequestDto combo = new ComboRequestDto();
		combo.setIdCombo(existente.getIdCombo());
		combo.setComboNombre(existente.getComboNombre());
		combo.setComboDescripcion(existente.getComboDescripcion());
		combo.setComboPrecio(existente.getComboPrecio());
		model.addAttribute("combo", combo);
		return "/combo/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute ComboRequestDto combo) {
		servicioCombo.crear(combo);
		return "redirect:/combo";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		servicioCombo.eliminar(id);
		return "redirect:/combo";
	}

}
