package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String listar() {
		List<PagoResponseDto> resultadoBD = servicioPago.listarPago();
		System.out.println(resultadoBD);
		return"/pago/lista";
	}

}
