package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;
import java.util.List;

public record ComboResponseDto(int idCombo, String comboNombre, String comboDescripcion,
        BigDecimal comboPrecio, String comboImagen, int comboStockDisponible,
        List<ComboProductoResponseDto> productos) { }
