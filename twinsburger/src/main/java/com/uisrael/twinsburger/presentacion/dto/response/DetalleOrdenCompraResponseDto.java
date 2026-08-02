package com.uisrael.twinsburger.presentacion.dto.response;

import java.math.BigDecimal;

public class DetalleOrdenCompraResponseDto {

	private int idDetalleOrdenCompra;
	private int docCantidad;
	private BigDecimal docPrecioUnitario;
	private int idOrdenCompra;
	private int idProducto;
	private String productoNombre;

	public DetalleOrdenCompraResponseDto() {
	}

	public int getIdDetalleOrdenCompra() {
		return idDetalleOrdenCompra;
	}

	public void setIdDetalleOrdenCompra(int idDetalleOrdenCompra) {
		this.idDetalleOrdenCompra = idDetalleOrdenCompra;
	}

	public int getDocCantidad() {
		return docCantidad;
	}

	public void setDocCantidad(int docCantidad) {
		this.docCantidad = docCantidad;
	}

	public BigDecimal getDocPrecioUnitario() {
		return docPrecioUnitario;
	}

	public void setDocPrecioUnitario(BigDecimal docPrecioUnitario) {
		this.docPrecioUnitario = docPrecioUnitario;
	}

	public int getIdOrdenCompra() {
		return idOrdenCompra;
	}

	public void setIdOrdenCompra(int idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getProductoNombre() {
		return productoNombre;
	}

	public void setProductoNombre(String productoNombre) {
		this.productoNombre = productoNombre;
	}

}
