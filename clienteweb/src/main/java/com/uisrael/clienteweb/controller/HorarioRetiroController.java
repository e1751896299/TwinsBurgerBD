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

import com.uisrael.clienteweb.model.dto.request.HorarioRetiroRequestDto;
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
	public String listar(Model model) {
		List<HorarioRetiroResponseDto> resultadoBD = servicioHorarioRetiro.listarHorarioRetiro();
		model.addAttribute("horarios", resultadoBD);
		return "/horario/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("horario", new HorarioRetiroRequestDto());
		return "/horario/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		HorarioRetiroResponseDto existente = servicioHorarioRetiro.buscarPorId(id);
		HorarioRetiroRequestDto horario = new HorarioRetiroRequestDto();
		horario.setIdHorarioRetiro(existente.getIdHorarioRetiro());
		horario.setHrInicio(existente.getHrInicio());
		horario.setHrFin(existente.getHrFin());
		model.addAttribute("horario", horario);
		return "/horario/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute HorarioRetiroRequestDto horario) {
		servicioHorarioRetiro.crear(horario);
		return "redirect:/horario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioHorarioRetiro.eliminar(id);
	    return "redirect:/horario";
	}

}
