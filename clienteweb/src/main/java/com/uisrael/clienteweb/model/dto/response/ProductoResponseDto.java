package com.uisrael.clienteweb.model.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductoResponseDto {
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private String prodCategoria;
	private LocalDateTime proFechaCreacion;
	private BigDecimal prodPrecio;
	private String prodImagen;
	
	public BigDecimal getProdPrecio() {
		return prodPrecio;
	}

	public void setProdPrecio(BigDecimal prodPrecio) {
		this.prodPrecio = prodPrecio;
	}

	public String getProdImagen() {
		return prodImagen;
	}

	public void setProdImagen(String prodImagen) {
		this.prodImagen = prodImagen;
	}

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
