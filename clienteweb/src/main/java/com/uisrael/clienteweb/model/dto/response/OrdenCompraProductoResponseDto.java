package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;

public record OrdenCompraProductoResponseDto(int idProducto, String prodNombre, int cantidad,
        BigDecimal precioUnitario) { }
