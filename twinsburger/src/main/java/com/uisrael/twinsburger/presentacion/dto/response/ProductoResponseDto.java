package com.uisrael.twinsburger.presentacion.dto.response;

import java.time.LocalDateTime;

public class ProductoResponseDto {
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private String prodCategoria;
	private LocalDateTime proFechaCreacion;
	public ProductoResponseDto() {
		super();
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getProdNombre() {
		return prodNombre;
	}
	public void setProdNombre(String prodNombre) {
		this.prodNombre = prodNombre;
	}
	public String getProdDescripcion() {
		return prodDescripcion;
	}
	public void setProdDescripcion(String prodDescripcion) {
		this.prodDescripcion = prodDescripcion;
	}
	public int getProdStock() {
		return prodStock;
	}
	public void setProdStock(int prodStock) {
		this.prodStock = prodStock;
	}
	public String getProdCategoria() {
		return prodCategoria;
	}
	public void setProdCategoria(String prodCategoria) {
		this.prodCategoria = prodCategoria;
	}
	public LocalDateTime getProFechaCreacion() {
		return proFechaCreacion;
	}
	public void setProFechaCreacion(LocalDateTime proFechaCreacion) {
		this.proFechaCreacion = proFechaCreacion;
	}
	

}
