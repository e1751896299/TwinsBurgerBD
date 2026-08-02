package com.uisrael.twinsburger.presentacion.dto.request;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

public class CompraRequestDto {
    private int idCliente;
    @Valid
    @NotEmpty
    private List<ItemCompraRequestDto> items = new ArrayList<>();

    public List<ItemCompraRequestDto> getItems() { return items; }
    public void setItems(List<ItemCompraRequestDto> items) { this.items = items; }
    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
}
