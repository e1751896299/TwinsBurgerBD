package com.uisrael.clienteweb.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.clienteweb.model.dto.request.OrdenCompraProductoRequestDto;
import com.uisrael.clienteweb.model.dto.request.OrdenCompraRequestDto;
import com.uisrael.clienteweb.services.IOrdenCompraService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/ordencompra")
public class OrdenCompraController {
    private final IOrdenCompraService ordenesCompra;
    private final IProductoService productos;
    public OrdenCompraController(IOrdenCompraService ordenesCompra, IProductoService productos) {
        this.ordenesCompra = ordenesCompra; this.productos = productos;
    }

    @GetMapping
    public String listar(Model model) { model.addAttribute("ordenesCompra", ordenesCompra.listar()); return "ordencompra/lista"; }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        OrdenCompraRequestDto dto = new OrdenCompraRequestDto();
        dto.setOcFecha(LocalDateTime.now().withSecond(0).withNano(0));
        model.addAttribute("ordenCompra", dto);
        model.addAttribute("productos", productos.listarProducto());
        return "ordencompra/formulario";
    }

    @PostMapping
    public String guardar(@ModelAttribute OrdenCompraRequestDto ordenCompra, @RequestParam Map<String, String> parametros) {
        var items = new ArrayList<OrdenCompraProductoRequestDto>();
        parametros.forEach((clave, valor) -> {
            if (clave.startsWith("cantidad_") && valor != null && !valor.isBlank()) {
                int idProducto = Integer.parseInt(clave.substring("cantidad_".length()));
                int cantidad = Integer.parseInt(valor);
                String precioTexto = parametros.get("precio_" + idProducto);
                if (cantidad > 0 && precioTexto != null && !precioTexto.isBlank()) {
                    items.add(new OrdenCompraProductoRequestDto(idProducto, cantidad, new BigDecimal(precioTexto)));
                }
            }
        });
        if (items.isEmpty()) return "redirect:/ordencompra/nuevo?sinProductos";
        ordenCompra.setProductos(items);
        try { ordenesCompra.guardar(ordenCompra); return "redirect:/ordencompra?guardado"; }
        catch (RuntimeException ex) { return "redirect:/ordencompra?errorGuardado"; }
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        ordenesCompra.eliminar(id); return "redirect:/ordencompra?eliminado";
    }
}
