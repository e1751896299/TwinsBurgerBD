package com.uisrael.twinsburger.presentacion.dto.response;

public class AdministradorResponseDto {
	
	private int idAdmin;
	private String adminNombre;
	private String adminApellido;
	private String adminCorreo;
	private boolean adminEstado;
	
	public AdministradorResponseDto() {
		
	}

	public int getIdAdmin() {
		return idAdmin;
	}

	public void setIdAdmin(int idAdmin) {
		this.idAdmin = idAdmin;
	}

	public String getAdminNombre() {
		return adminNombre;
	}

	public void setAdminNombre(String adminNombre) {
		this.adminNombre = adminNombre;
	}

	public String getAdminApellido() {
		return adminApellido;
	}

	public void setAdminApellido(String adminApellido) {
		this.adminApellido = adminApellido;
	}

	public String getAdminCorreo() {
		return adminCorreo;
	}

	public void setAdminCorreo(String adminCorreo) {
		this.adminCorreo = adminCorreo;
	}

	public boolean isAdminEstado() {
		return adminEstado;
	}

	public void setAdminEstado(boolean adminEstado) {
		this.adminEstado = adminEstado;
	}


	
	

}
