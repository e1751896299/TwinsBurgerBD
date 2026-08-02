package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DetalleOrdenCompraRequestDto {

	private int idDetalleOrdenCompra;
	private int docCantidad;
	@NotNull
	private BigDecimal docPrecioUnitario;
	private int idOrdenCompra;
	private int idProducto;

}
