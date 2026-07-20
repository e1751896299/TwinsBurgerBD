package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String listar() {
		List<ProductoResponseDto> resultadoBD = servicioProducto.listarProducto();
		System.out.println(resultadoBD);
		return "/producto/lista";
	}

}
