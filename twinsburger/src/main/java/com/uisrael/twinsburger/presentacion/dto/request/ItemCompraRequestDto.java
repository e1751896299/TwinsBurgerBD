package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.Min;

public class ItemCompraRequestDto {
    private int idProducto;
    private int idCombo;
    @Min(1)
    private int cantidad;

    public int getIdProducto() { return idProducto; }
    public void setIdProducto(int idProducto) { this.idProducto = idProducto; }
    public int getIdCombo() { return idCombo; }
    public void setIdCombo(int idCombo) { this.idCombo = idCombo; }
    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
