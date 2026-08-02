package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;

public class DetalleOrdenCompra {

	private int idDetalleOrdenCompra;
	private int docCantidad;
	private BigDecimal docPrecioUnitario;
	private boolean docEstado = true;
	private int idOrdenCompra;
	private int idProducto;
	private String productoNombre;

	public DetalleOrdenCompra() {
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
	public boolean isDocEstado() {
		return docEstado;
	}
	public void setDocEstado(boolean docEstado) {
		this.docEstado = docEstado;
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
