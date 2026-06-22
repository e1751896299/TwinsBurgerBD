package com.uisrael.twinsburger.dominio.entidades;

public class Categoria {
	
	private int idCategoria;
	private String categoriaNombre;
	private String categoriaDescripcion;
	private boolean categoriaEstado;
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
	public String getCategoriaDescripcion() {
		return categoriaDescripcion;
	}
	public void setCategoriaDescripcion(String categoriaDescripcion) {
		this.categoriaDescripcion = categoriaDescripcion;
	}
	public boolean isCategoriaEstado() {
		return categoriaEstado;
	}
	public void setCategoriaEstado(boolean categoriaEstado) {
		this.categoriaEstado = categoriaEstado;
	}
	
	

}
