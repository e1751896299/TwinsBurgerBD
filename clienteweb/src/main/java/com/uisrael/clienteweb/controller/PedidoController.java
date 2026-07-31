package com.uisrael.clienteweb.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.request.PedidoRequestDto;
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

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true) {
			@Override
			public void setValue(Object value) {
				if (value instanceof java.util.Date && !(value instanceof Date)) {
					super.setValue(new Date(((java.util.Date) value).getTime()));
				} else {
					super.setValue(value);
				}
			}
		});
	}

	@GetMapping
	public String listar(Model model) {
		List<PedidoResponseDto> resultadoBD = servicioPedido.listarPedido();
		model.addAttribute("pedidos", resultadoBD);
		return "/pedido/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("pedido", new PedidoRequestDto());
		return "/pedido/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		PedidoResponseDto existente = servicioPedido.buscarPorId(id);
		PedidoRequestDto pedido = new PedidoRequestDto();
		pedido.setIdPedido(existente.getIdPedido());
		pedido.setPedidoFechaPedido(new Date(existente.getPedidoFechaPedido().getTime()));
		pedido.setPedidoHoraRetiro(existente.getPedidoHoraRetiro());
		pedido.setPedidoTotal(existente.getPedidoTotal());
		pedido.setPedidoDescripcion(existente.getPedidoDescripcion());
		model.addAttribute("pedido", pedido);
		return "/pedido/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute PedidoRequestDto pedido) {
		servicioPedido.crear(pedido);
		return "redirect:/pedido";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioPedido.eliminar(id);
	    return "redirect:/pedido";
	}

}
