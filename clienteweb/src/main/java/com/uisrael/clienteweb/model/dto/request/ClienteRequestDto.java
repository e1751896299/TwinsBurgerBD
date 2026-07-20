package com.uisrael.clienteweb.model.dto.request;

import lombok.Data;

@Data
public class ClienteRequestDto {
	
	private int idCliente;
	
	private String cliNombre;
	
	private String cliApellido;
	
	private String cliCorreo;
	
	private String cliTelefono;
	
	private boolean cliEstado;

}
