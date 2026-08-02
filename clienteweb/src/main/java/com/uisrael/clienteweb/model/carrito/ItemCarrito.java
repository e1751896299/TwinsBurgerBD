package com.uisrael.clienteweb.model.carrito;

import java.math.BigDecimal;

public class ItemCarrito {
    private int idProducto;
    private String nombre;
    private BigDecimal precio;
    private int cantidad;
    private int stockDisponible;

    public ItemCarrito() { }

    public ItemCarrito(int idProducto, String nombre, BigDecimal precio, int cantidad, int stockDisponible) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.stockDisponible = stockDisponible;
    }

    public BigDecimal getSubtotal() { return precio.multiply(BigDecimal.valueOf(cantidad)); }
    public int getIdProducto() { return idProducto; }
    public String getNombre() { return nombre; }
    public BigDecimal getPrecio() { return precio; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
    public int getStockDisponible() { return stockDisponible; }
}
