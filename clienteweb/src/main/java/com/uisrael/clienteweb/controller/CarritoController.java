package com.uisrael.clienteweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import com.uisrael.clienteweb.model.dto.request.CompraRequestDto;
import com.uisrael.clienteweb.model.dto.request.ItemCompraRequestDto;
import com.uisrael.clienteweb.services.CarritoService;
import com.uisrael.clienteweb.services.IProductoService;
import com.uisrael.clienteweb.configuration.UsuarioAutenticado;

@Controller
@RequestMapping("/carrito")
public class CarritoController {
    private final CarritoService carrito;
    private final IProductoService productos;
    private final WebClient webClient;

    public CarritoController(CarritoService carrito, IProductoService productos, WebClient webClient) {
        this.carrito = carrito;
        this.productos = productos;
        this.webClient = webClient;
    }

    @GetMapping
    public String ver(Model model) {
        model.addAttribute("items", carrito.getItems());
        model.addAttribute("total", carrito.getTotal());
        return "cliente/carrito";
    }

    @PostMapping("/agregar/{id}")
    public String agregar(@PathVariable int id, @RequestParam(defaultValue = "1") int cantidad) {
        try {
            carrito.agregar(productos.buscarPorId(id), cantidad);
            return "redirect:/menu?agregado";
        } catch (RuntimeException ex) {
            return "redirect:/menu?errorCarrito";
        }
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable int id, @RequestParam int cantidad) {
        try { carrito.actualizar(id, cantidad); }
        catch (RuntimeException ex) { return "redirect:/carrito?errorCantidad"; }
        return "redirect:/carrito";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        carrito.eliminar(id);
        return "redirect:/carrito";
    }

    @PostMapping("/confirmar")
    public String confirmar(@AuthenticationPrincipal UsuarioAutenticado usuario) {
        if (carrito.estaVacio()) return "redirect:/carrito?vacio";
        CompraRequestDto compra = new CompraRequestDto(usuario.getId(), carrito.getItems().stream()
                .map(i -> new ItemCompraRequestDto(i.getIdProducto(), i.getCantidad())).toList());
        try {
            webClient.post().uri("/compras").bodyValue(compra).retrieve().toBodilessEntity().block();
            carrito.vaciar();
            return "redirect:/carrito?compraExitosa";
        } catch (RuntimeException ex) {
            return "redirect:/carrito?errorCompra";
        }
    }

}
