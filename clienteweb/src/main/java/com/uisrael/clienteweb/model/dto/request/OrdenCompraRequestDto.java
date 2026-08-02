package com.uisrael.clienteweb.model.dto.request;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class OrdenCompraRequestDto {

	private int idOrdenCompra;

	private LocalDateTime ocFecha;

	private String ocProveedor;

}
