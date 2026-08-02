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

import com.uisrael.clienteweb.model.dto.request.ComboDetalleRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboDetalleResponseDto;
import com.uisrael.clienteweb.services.IComboDetalleService;
import com.uisrael.clienteweb.services.IComboService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/combodetalle")
public class ComboDetalleController {

	@Autowired
	public IComboDetalleService servicioDetalle;

	private final IComboService servicioCombo;
	private final IProductoService servicioProducto;

	public ComboDetalleController(IComboDetalleService servicioDetalle, IComboService servicioCombo,
			IProductoService servicioProducto) {
		this.servicioDetalle = servicioDetalle;
		this.servicioCombo = servicioCombo;
		this.servicioProducto = servicioProducto;
	}

	private void agregarListasParaSelects(Model model) {
		model.addAttribute("combos", servicioCombo.listarCombo());
		model.addAttribute("productos", servicioProducto.listarProducto());
	}

	@GetMapping
	public String listar(Model model) {
		List<ComboDetalleResponseDto> resultadoBD = servicioDetalle.listarComboDetalle();
		model.addAttribute("detalles", resultadoBD);
		return "/combodetalle/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("detalle", new ComboDetalleRequestDto());
		agregarListasParaSelects(model);
		return "/combodetalle/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		ComboDetalleResponseDto existente = servicioDetalle.buscarPorId(id);
		ComboDetalleRequestDto detalle = new ComboDetalleRequestDto();
		detalle.setIdComboDetalle(existente.getIdComboDetalle());
		detalle.setCdCantidad(existente.getCdCantidad());
		detalle.setIdCombo(existente.getIdCombo());
		detalle.setIdProducto(existente.getIdProducto());
		model.addAttribute("detalle", detalle);
		agregarListasParaSelects(model);
		return "/combodetalle/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute ComboDetalleRequestDto detalle) {
		servicioDetalle.crear(detalle);
		return "redirect:/combodetalle";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		servicioDetalle.eliminar(id);
		return "redirect:/combodetalle";
	}

}
