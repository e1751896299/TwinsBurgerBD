package com.uisrael.clienteweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.uisrael.clienteweb.model.dto.request.MetodoPagoRequestDto;
import com.uisrael.clienteweb.services.IMetodoPagoService;

@Controller
@RequestMapping("/metodo-pago")
public class MetodoPagoController {
    private final IMetodoPagoService servicio;
    public MetodoPagoController(IMetodoPagoService servicio) { this.servicio = servicio; }
    @GetMapping public String listar(Model model) {
        model.addAttribute("metodos", servicio.listarMetodoPago()); return "metodopago/lista";
    }
    @GetMapping("/nuevo") public String nuevo(Model model) {
        model.addAttribute("metodo", new MetodoPagoRequestDto()); return "metodopago/formulario";
    }
    @GetMapping("/editar/{id}") public String editar(@PathVariable int id, Model model) {
        var existente = servicio.buscarPorId(id); var metodo = new MetodoPagoRequestDto();
        metodo.setIdMetodoPago(existente.getIdMetodoPago()); metodo.setMpagoDescripcion(existente.getMpagoDescripcion());
        model.addAttribute("metodo", metodo); return "metodopago/formulario";
    }
    @PostMapping public String guardar(@ModelAttribute MetodoPagoRequestDto metodo) {
        servicio.guardar(metodo); return "redirect:/metodo-pago?guardado";
    }
    @PostMapping("/eliminar/{id}") public String eliminar(@PathVariable int id) {
        servicio.eliminar(id); return "redirect:/metodo-pago?eliminado";
    }
}
