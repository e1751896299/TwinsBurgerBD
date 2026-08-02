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

import com.uisrael.clienteweb.model.dto.request.DetalleOrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.DetalleOrdenCompraResponseDto;
import com.uisrael.clienteweb.services.IDetalleOrdenCompraService;
import com.uisrael.clienteweb.services.IOrdenCompraService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/detalleordencompra")
public class DetalleOrdenCompraController {

	@Autowired
	public IDetalleOrdenCompraService servicioDetalle;

	private final IOrdenCompraService servicioOrdenCompra;
	private final IProductoService servicioProducto;

	public DetalleOrdenCompraController(IDetalleOrdenCompraService servicioDetalle, IOrdenCompraService servicioOrdenCompra,
			IProductoService servicioProducto) {
		this.servicioDetalle = servicioDetalle;
		this.servicioOrdenCompra = servicioOrdenCompra;
		this.servicioProducto = servicioProducto;
	}

	private void agregarListasParaSelects(Model model) {
		model.addAttribute("ordenesCompra", servicioOrdenCompra.listarOrdenCompra());
		model.addAttribute("productos", servicioProducto.listarProducto());
	}

	@GetMapping
	public String listar(Model model) {
		List<DetalleOrdenCompraResponseDto> resultadoBD = servicioDetalle.listarDetalleOrdenCompra();
		model.addAttribute("detalles", resultadoBD);
		return "/detalleordencompra/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("detalle", new DetalleOrdenCompraRequestDto());
		agregarListasParaSelects(model);
		return "/detalleordencompra/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		DetalleOrdenCompraResponseDto existente = servicioDetalle.buscarPorId(id);
		DetalleOrdenCompraRequestDto detalle = new DetalleOrdenCompraRequestDto();
		detalle.setIdDetalleOrdenCompra(existente.getIdDetalleOrdenCompra());
		detalle.setDocCantidad(existente.getDocCantidad());
		detalle.setDocPrecioUnitario(existente.getDocPrecioUnitario());
		detalle.setIdOrdenCompra(existente.getIdOrdenCompra());
		detalle.setIdProducto(existente.getIdProducto());
		model.addAttribute("detalle", detalle);
		agregarListasParaSelects(model);
		return "/detalleordencompra/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute DetalleOrdenCompraRequestDto detalle) {
		servicioDetalle.crear(detalle);
		return "redirect:/detalleordencompra";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
		servicioDetalle.eliminar(id);
		return "redirect:/detalleordencompra";
	}

}
