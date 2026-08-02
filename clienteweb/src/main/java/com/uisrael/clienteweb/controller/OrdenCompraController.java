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

import com.uisrael.clienteweb.model.dto.request.OrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.OrdenCompraResponseDto;
import com.uisrael.clienteweb.services.IOrdenCompraService;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {

	@Autowired
	public IOrdenCompraService servicioOrdenCompra;

	public OrdenCompraController(IOrdenCompraService servicioOrdenCompra) {
		this.servicioOrdenCompra = servicioOrdenCompra;
	}

	@GetMapping
	public String listar(Model model) {
		List<OrdenCompraResponseDto> resultadoBD = servicioOrdenCompra.listarOrdenCompra();
		model.addAttribute("ordenesCompra", resultadoBD);
		return "/ordencompra/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("ordenCompra", new OrdenCompraRequestDto());
		return "/ordencompra/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		OrdenCompraResponseDto existente = servicioOrdenCompra.buscarPorId(id);
		OrdenCompraRequestDto ordenCompra = new OrdenCompraRequestDto();
		ordenCompra.setIdOrdenCompra(existente.getIdOrdenCompra());
		ordenCompra.setOcFecha(existente.getOcFecha());
		ordenCompra.setOcProveedor(existente.getOcProveedor());
		model.addAttribute("ordenCompra", ordenCompra);
		return "/ordencompra/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute OrdenCompraRequestDto ordenCompra) {
		servicioOrdenCompra.crear(ordenCompra);
		return "redirect:/ordencompra";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		servicioOrdenCompra.eliminar(id);
		return "redirect:/ordencompra";
	}

}
