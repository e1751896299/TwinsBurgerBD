package com.uisrael.clienteweb.model.dto.request;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class DetalleOrdenCompraRequestDto {

	private int idDetalleOrdenCompra;

	private int docCantidad;

	private BigDecimal docPrecioUnitario;

	private int idOrdenCompra;

	private int idProducto;

}
