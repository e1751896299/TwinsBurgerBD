package com.uisrael.twinsburger.presentacion.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public record OrdenCompraResponseDto(int idOrdenCompra, LocalDateTime ocFecha, String ocProveedor,
        List<OrdenCompraProductoResponseDto> productos) { }
