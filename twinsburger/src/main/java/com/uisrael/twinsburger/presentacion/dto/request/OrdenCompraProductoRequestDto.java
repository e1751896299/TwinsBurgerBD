package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrdenCompraProductoRequestDto(@Min(1) int idProducto, @Min(1) int cantidad,
        @NotNull @DecimalMin("0.01") BigDecimal precioUnitario) { }
