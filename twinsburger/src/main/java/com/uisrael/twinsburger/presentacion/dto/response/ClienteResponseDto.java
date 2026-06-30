package com.uisrael.twinsburger.presentacion.dto.response;

public class ClienteResponseDto {
	
	private int idCliente;
	private String cliNombre;
	private String cliApellido;
	private String cliCorreo;
	private String cliTelefono;
	private boolean cliEstado;
	public ClienteResponseDto() {
		super();
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getCliNombre() {
		return cliNombre;
	}
	public void setCliNombre(String cliNombre) {
		this.cliNombre = cliNombre;
	}
	public String getCliApellido() {
		return cliApellido;
	}
	public void setCliApellido(String cliApellido) {
		this.cliApellido = cliApellido;
	}
	public String getCliCorreo() {
		return cliCorreo;
	}
	public void setCliCorreo(String cliCorreo) {
		this.cliCorreo = cliCorreo;
	}
	public String getCliTelefono() {
		return cliTelefono;
	}
	public void setCliTelefono(String cliTelefono) {
		this.cliTelefono = cliTelefono;
	}
	public boolean isCliEstado() {
		return cliEstado;
	}
	public void setCliEstado(boolean cliEstado) {
		this.cliEstado = cliEstado;
	}
	
	

}
