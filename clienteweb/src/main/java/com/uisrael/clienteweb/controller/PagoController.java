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

import com.uisrael.clienteweb.model.dto.request.PagoRequestDto;
import com.uisrael.clienteweb.model.dto.response.PagoResponseDto;
import com.uisrael.clienteweb.services.IPagoService;

@Controller
@RequestMapping("/pago")
public class PagoController {

	@Autowired
	public IPagoService servicioPago;


	public PagoController(IPagoService servicioPago) {
		this.servicioPago = servicioPago;
	}


	@GetMapping
	public String listar(Model model) {
		List<PagoResponseDto> resultadoBD = servicioPago.listarPago();
		model.addAttribute("pagos", resultadoBD);
		return"/pago/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pago", new PagoRequestDto());
		return "/pago/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute PagoRequestDto pago) {
		servicioPago.crear(pago);
		return "redirect:/pago";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioPago.eliminar(id);
	    return "redirect:/pago";
	}

}
