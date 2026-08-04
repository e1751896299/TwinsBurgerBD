package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.model.dto.request.ProductoRequestDto;
import com.uisrael.clienteweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;
import com.uisrael.clienteweb.services.ICategoriaService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    private final IProductoService servicioProducto;
    private final ICategoriaService categoriaService;

    public ProductoController(
            IProductoService servicioProducto,
            ICategoriaService categoriaService) {

        this.servicioProducto = servicioProducto;
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public String listar(Model model) {

        List<ProductoResponseDto> productos =
                servicioProducto.listarProducto();

        model.addAttribute("productos", productos);

        return "producto/lista";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {

        model.addAttribute(
            "producto",
            new ProductoRequestDto()
        );

        cargarCategorias(model);

        return "producto/nuevo";
    }

    @PostMapping("/nuevo")
    public String guardarNuevo(
            @ModelAttribute("producto")
            ProductoRequestDto producto) {

        producto.setIdProducto(0);

        servicioProducto.crear(producto);

        return "redirect:/producto?creado";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(
            @PathVariable int id,
            Model model) {

        ProductoResponseDto existente =
                servicioProducto.buscarPorId(id);

        ProductoRequestDto producto =
                new ProductoRequestDto();

        producto.setIdProducto(
                existente.getIdProducto()
        );

        producto.setProdNombre(
                existente.getProdNombre()
        );

        producto.setProdDescripcion(
                existente.getProdDescripcion()
        );

        producto.setProdStock(
                existente.getProdStock()
        );

        producto.setProdCategoria(
                existente.getProdCategoria()
        );

        producto.setProdPrecio(
                existente.getProdPrecio()
        );

        producto.setProdImagen(
                existente.getProdImagen()
        );

        model.addAttribute("producto", producto);

        cargarCategorias(model);

        return "producto/editar";
    }

    @PostMapping("/editar/{id}")
    public String guardarEdicion(
            @PathVariable int id,
            @ModelAttribute("producto")
            ProductoRequestDto producto) {

        producto.setIdProducto(id);

        servicioProducto.crear(producto);

        return "redirect:/producto?editado";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(
            @PathVariable int id) {

        servicioProducto.eliminar(id);

        return "redirect:/producto?eliminado";
    }

    private void cargarCategorias(Model model) {

        List<CategoriaResponseDto> categorias =
                categoriaService.listarCategoria()
                    .stream()
                    .filter(
                        CategoriaResponseDto::isCategoriaEstado
                    )
                    .toList();

        model.addAttribute(
            "categorias",
            categorias
        );
    }
}