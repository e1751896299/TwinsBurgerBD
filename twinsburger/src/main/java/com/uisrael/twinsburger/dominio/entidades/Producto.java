package com.uisrael.twinsburger.dominio.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Producto {
	
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private int idCategoria;
	private String categoriaNombre;
	private LocalDateTime proFechaCreacion;
	private boolean prodEstado = true;
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
	public Producto() {
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
	public boolean isProdEstado() {
		return prodEstado;
	}
	public void setProdEstado(boolean prodEstado) {
		this.prodEstado = prodEstado;
	}
	
	
	
	 

}
