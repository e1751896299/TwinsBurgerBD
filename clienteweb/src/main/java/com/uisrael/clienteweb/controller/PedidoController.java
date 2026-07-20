package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.response.PedidoResponseDto;
import com.uisrael.clienteweb.services.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	public IPedidoService servicioPedido;
	
	public PedidoController(IPedidoService servicioPedido) {
		this.servicioPedido = servicioPedido;
	}

	@GetMapping
	public String listar() {
		List<PedidoResponseDto> resultadoBD = servicioPedido.listarPedido();
		System.out.println(resultadoBD);
		return "/pedido/lista";
	}

}
