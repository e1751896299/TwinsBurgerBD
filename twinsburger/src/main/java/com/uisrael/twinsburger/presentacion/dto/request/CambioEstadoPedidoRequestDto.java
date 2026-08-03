package com.uisrael.twinsburger.presentacion.dto.request;

import com.uisrael.twinsburger.dominio.entidades.EstadoPedido;

import jakarta.validation.constraints.NotNull;

public class CambioEstadoPedidoRequestDto {

    @NotNull(message = "El estado es obligatorio")
    private EstadoPedido estado;

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }
}
