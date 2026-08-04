package com.uisrael.clienteweb.model.dto.request;

import java.util.List;

public record CompraRequestDto(int idCliente, int idMetodoPago, List<ItemCompraRequestDto> items) { }
