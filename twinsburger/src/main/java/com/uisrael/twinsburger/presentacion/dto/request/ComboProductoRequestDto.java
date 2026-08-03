package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.Min;

public record ComboProductoRequestDto(@Min(1) int idProducto, @Min(1) int cantidad) { }
