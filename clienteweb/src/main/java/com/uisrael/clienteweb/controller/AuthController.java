 package com.uisrael.clienteweb.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.uisrael.clienteweb.model.dto.request.ClienteRequestDto;
import com.uisrael.clienteweb.model.dto.request.RegistroClienteDto;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;
import com.uisrael.clienteweb.services.IClienteService;
import com.uisrael.clienteweb.services.IProductoService;
import com.uisrael.clienteweb.services.CarritoService;
import com.uisrael.clienteweb.services.IComboService;

import jakarta.validation.Valid;

@Controller
public class AuthController {

	private final IClienteService clienteService;
	private final IProductoService productoService;
	private final CarritoService carritoService;
	private final IComboService comboService;
	

	public AuthController(IClienteService clienteService, IProductoService productoService,
			CarritoService carritoService, IComboService comboService) {
		this.clienteService = clienteService;
		this.productoService = productoService;
		this.carritoService = carritoService;
		this.comboService = comboService;
	}

	@GetMapping("/login")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/registro")
	public String registro(Model model) {
		model.addAttribute("registro", new RegistroClienteDto());
		return "auth/registro";
	}

	@PostMapping("/registro")
	public String registrar(@Valid @ModelAttribute ("registro") RegistroClienteDto registro,
			BindingResult resultado, Model model) {
		if (!Objects.equals(
		        registro.getContrasena(),
		        registro.getConfirmarContrasena())) {
			resultado.rejectValue("confirmarContrasena", "contrasenas.distintas", "Las contraseñas no coinciden");
		}
		if (resultado.hasErrors()) {
			return "auth/registro";
		}

		ClienteRequestDto cliente = new ClienteRequestDto();
		cliente.setCliNombre(registro.getNombre().trim());
		cliente.setCliApellido(registro.getApellido().trim());
		cliente.setCliCorreo(registro.getCorreo().trim().toLowerCase());
		cliente.setCliTelefono(registro.getTelefono());
		cliente.setCliContrasena(registro.getContrasena());
		cliente.setCliActivo(true);

		try {
			clienteService.crear(cliente);
		} catch (RuntimeException ex) {
			model.addAttribute("errorRegistro", "No se pudo crear la cuenta. Verifica que el correo no esté registrado.");
			return "auth/registro";
		}
		return "redirect:/login?registro";
	}

	@GetMapping("/menu")
	public String menu(Model model) {
		model.addAttribute("cantidadCarrito", carritoService.getCantidadTotal());

	    try {
	        List<ProductoResponseDto> productos =
	                productoService.listarProducto();

	        List<String> categorias = productos.stream()
	                .map(ProductoResponseDto::getProdCategoria)
	                .filter(categoria ->
	                        categoria != null
	                        && !categoria.isBlank())
	                .map(String::trim)
	                .distinct()
	                .sorted()
	                .toList();

	        model.addAttribute(
	                "productos",
	                productos
	        );

	        model.addAttribute(
	                "categorias",
	                categorias
	        );
	        model.addAttribute("combos", comboService.listar());

	        model.addAttribute(
	                "apiDisponible",
	                true
	        );

	    } catch (RuntimeException ex) {

	        model.addAttribute(
	                "productos",
	                List.of()
	        );

	        model.addAttribute(
	                "categorias",
	                List.of()
	        );
	        model.addAttribute("combos", List.of());

	        model.addAttribute(
	                "apiDisponible",
	                false
	        );
	    }

	    return "cliente/menu";
	}
	
	@GetMapping("/acceso-denegado")
	public String accesoDenegado() {
		return "auth/acceso-denegado";
	}
}
