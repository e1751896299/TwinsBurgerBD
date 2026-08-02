package com.uisrael.clienteweb.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.uisrael.clienteweb.model.carrito.ItemCarrito;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;

@Service
@SessionScope
public class CarritoService {
    private final List<ItemCarrito> items = new ArrayList<>();

    public void agregar(ProductoResponseDto producto, int cantidad) {
        if (producto.getProdPrecio() == null || producto.getProdStock() <= 0) {
            throw new IllegalArgumentException("El producto no está disponible");
        }
        int cantidadValida = Math.max(1, cantidad);
        ItemCarrito existente = items.stream()
                .filter(item -> item.getIdProducto() == producto.getIdProducto())
                .findFirst().orElse(null);
        int nuevaCantidad = cantidadValida + (existente == null ? 0 : existente.getCantidad());
        if (nuevaCantidad > producto.getProdStock()) {
            throw new IllegalArgumentException("La cantidad supera el stock disponible");
        }
        if (existente == null) {
            items.add(new ItemCarrito(producto.getIdProducto(), producto.getProdNombre(),
                    producto.getProdPrecio(), cantidadValida, producto.getProdStock()));
        } else {
            existente.setCantidad(nuevaCantidad);
        }
    }

    public void actualizar(int idProducto, int cantidad) {
        ItemCarrito item = buscar(idProducto);
        if (cantidad <= 0) { eliminar(idProducto); return; }
        if (cantidad > item.getStockDisponible()) {
            throw new IllegalArgumentException("La cantidad supera el stock disponible");
        }
        item.setCantidad(cantidad);
    }

    private ItemCarrito buscar(int idProducto) {
        return items.stream().filter(i -> i.getIdProducto() == idProducto).findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado en el carrito"));
    }

    public void eliminar(int idProducto) { items.removeIf(i -> i.getIdProducto() == idProducto); }
    public List<ItemCarrito> getItems() { return List.copyOf(items); }
    public int getCantidadTotal() { return items.stream().mapToInt(ItemCarrito::getCantidad).sum(); }
    public BigDecimal getTotal() { return items.stream().map(ItemCarrito::getSubtotal).reduce(BigDecimal.ZERO, BigDecimal::add); }
    public boolean estaVacio() { return items.isEmpty(); }
    public void vaciar() { items.clear(); }

}
