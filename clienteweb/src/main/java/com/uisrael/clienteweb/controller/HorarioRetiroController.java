package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.request.HorarioRetiroRequestDto;
import com.uisrael.clienteweb.model.dto.response.HorarioRetiroResponseDto;
import com.uisrael.clienteweb.services.IHorarioRetiroService;
import jakarta.validation.Valid;

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
	public String guardar(@Valid @ModelAttribute("horario") HorarioRetiroRequestDto horario,
			BindingResult resultado, Model model) {
		if (horario.getHrInicio() != null && horario.getHrFin() != null
				&& !horario.getHrFin().isAfter(horario.getHrInicio())) {
			resultado.rejectValue("hrFin", "horario.invalido",
					"La hora de fin debe ser posterior a la hora de inicio");
		}
		if (resultado.hasErrors()) return "/horario/nuevo";
		try {
			servicioHorarioRetiro.crear(horario);
			return "redirect:/horario?guardado";
		} catch (RuntimeException ex) {
			model.addAttribute("errorGuardado", "No se pudo guardar el horario. Verifica los datos.");
			return "/horario/nuevo";
		}
	}

	@PostMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioHorarioRetiro.eliminar(id);
	    return "redirect:/horario";
	}

}
