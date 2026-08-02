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

import com.uisrael.clienteweb.model.dto.request.ProductoRequestDto;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	public IProductoService servicioProducto;

	public ProductoController(IProductoService servicioProducto) {
		this.servicioProducto = servicioProducto;
	}

	@GetMapping
	public String listar(Model model) {
		List<ProductoResponseDto> resultadoBD = servicioProducto.listarProducto();
		model.addAttribute("productos", resultadoBD);
		return "/producto/lista";
	}

	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("producto", new ProductoRequestDto());
		return "/producto/nuevo";
	}

	@GetMapping("/editar/{id}")
	public String mostrarFormularioEditar(@PathVariable int id, Model model) {
		ProductoResponseDto existente = servicioProducto.buscarPorId(id);
		ProductoRequestDto producto = new ProductoRequestDto();
		producto.setIdProducto(existente.getIdProducto());
		producto.setProdNombre(existente.getProdNombre());
		producto.setProdDescripcion(existente.getProdDescripcion());
		producto.setProdStock(existente.getProdStock());
		producto.setProdCategoria(existente.getProdCategoria());
		producto.setProdPrecio(existente.getProdPrecio());
		producto.setProdImagen(existente.getProdImagen());
		model.addAttribute("producto", producto);
		return "/producto/nuevo";
	}

	@PostMapping
	public String guardar(@ModelAttribute ProductoRequestDto producto) {
		servicioProducto.crear(producto);
		return "redirect:/producto";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable int id) {
	    servicioProducto.eliminar(id);
	    return "redirect:/producto";
	}

}
