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
import com.uisrael.clienteweb.services.IMetodoPagoService;
import com.uisrael.clienteweb.services.IPagoService;
import com.uisrael.clienteweb.services.IPedidoService;

@Controller
@RequestMapping("/pago")
public class PagoController {

	@Autowired
	public IPagoService servicioPago;

	private final IPedidoService servicioPedido;
	private final IMetodoPagoService servicioMetodoPago;

	public PagoController(IPagoService servicioPago, IPedidoService servicioPedido, IMetodoPagoService servicioMetodoPago) {
		this.servicioPago = servicioPago;
		this.servicioPedido = servicioPedido;
		this.servicioMetodoPago = servicioMetodoPago;
	}

	private void agregarListasParaSelects(Model model) {
		model.addAttribute("pedidos", servicioPedido.listarPedido());
		model.addAttribute("metodosPago", servicioMetodoPago.listarMetodoPago());
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
		agregarListasParaSelects(model);
		return "/pago/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		PagoResponseDto existente = servicioPago.buscarPorId(id);
		PagoRequestDto pago = new PagoRequestDto();
		pago.setIdPago(existente.getIdPago());
		pago.setPagoFecha(existente.getPagoFecha());
		pago.setPagoMonto(existente.getPagoMonto());
		pago.setIdPedido(existente.getIdPedido());
		pago.setIdMetodoPago(existente.getIdMetodoPago());
		model.addAttribute("pago", pago);
		agregarListasParaSelects(model);
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
