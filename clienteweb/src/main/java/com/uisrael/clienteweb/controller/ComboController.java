package com.uisrael.clienteweb.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.clienteweb.model.dto.request.ComboProductoRequestDto;
import com.uisrael.clienteweb.model.dto.request.ComboRequestDto;
import com.uisrael.clienteweb.services.IComboService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/combo")
public class ComboController {
    private final IComboService combos;
    private final IProductoService productos;
    public ComboController(IComboService combos, IProductoService productos) { this.combos = combos; this.productos = productos; }

    @GetMapping
    public String listar(Model model) { model.addAttribute("combos", combos.listar()); return "combo/lista"; }

    @GetMapping("/nuevo")
    public String nuevo(Model model) { preparar(model, new ComboRequestDto(), Map.of()); return "combo/formulario"; }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        var existente = combos.buscar(id);
        ComboRequestDto dto = new ComboRequestDto();
        dto.setIdCombo(existente.idCombo()); dto.setComboNombre(existente.comboNombre());
        dto.setComboDescripcion(existente.comboDescripcion()); dto.setComboPrecio(existente.comboPrecio());
        dto.setComboImagen(existente.comboImagen());
        Map<Integer,Integer> cantidades = new HashMap<>();
        existente.productos().forEach(p -> cantidades.put(p.idProducto(), p.cantidad()));
        preparar(model, dto, cantidades); return "combo/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute ComboRequestDto combo, @RequestParam Map<String,String> parametros) {
        var componentes = new ArrayList<ComboProductoRequestDto>();
        parametros.forEach((clave, valor) -> {
            if (clave.startsWith("cantidad_") && valor != null && !valor.isBlank()) {
                int cantidad = Integer.parseInt(valor);
                if (cantidad > 0) componentes.add(new ComboProductoRequestDto(
                        Integer.parseInt(clave.substring("cantidad_".length())), cantidad));
            }
        });
        if (componentes.isEmpty()) return "redirect:/combo/nuevo?sinProductos";
        combo.setProductos(componentes);
        try { combos.guardar(combo); return "redirect:/combo?guardado"; }
        catch (RuntimeException ex) { return "redirect:/combo?errorGuardado"; }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) { combos.eliminar(id); return "redirect:/combo?eliminado"; }

    private void preparar(Model model, ComboRequestDto combo, Map<Integer,Integer> cantidades) {
        model.addAttribute("combo", combo); model.addAttribute("productos", productos.listarProducto());
        model.addAttribute("cantidades", cantidades);
    }
}
