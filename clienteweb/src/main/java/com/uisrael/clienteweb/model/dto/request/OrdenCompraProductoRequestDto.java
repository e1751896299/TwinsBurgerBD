package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;

public record OrdenCompraProductoRequestDto(int idProducto, int cantidad, BigDecimal precioUnitario) { }
