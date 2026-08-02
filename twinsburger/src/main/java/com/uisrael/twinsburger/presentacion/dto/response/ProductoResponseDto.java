package com.uisrael.twinsburger.presentacion.dto.response;

import java.time.LocalDateTime;

public class ProductoResponseDto {
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private int idCategoria;
	private String categoriaNombre;
	private LocalDateTime proFechaCreacion;
	
	public ProductoResponseDto() {
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

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(String categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	public LocalDateTime getProFechaCreacion() {
		return proFechaCreacion;
	}

	public void setProFechaCreacion(LocalDateTime proFechaCreacion) {
		this.proFechaCreacion = proFechaCreacion;
	}

	
}
