package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.Min;

public class ItemCompraRequestDto {
    @Min(1)
    private int idProducto;
    @Min(1)
    private int cantidad;

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
