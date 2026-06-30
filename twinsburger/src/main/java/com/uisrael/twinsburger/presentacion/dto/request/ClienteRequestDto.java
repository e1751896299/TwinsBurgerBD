package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ClienteRequestDto {
	
	private int idCliente;
	@NotBlank
	private String cliNombre;
	@NotBlank
	private String cliApellido;
	@NotBlank
	private String cliCorreo;
	
	private String cliTelefono;
	@NotBlank
	private boolean cliEstado;

}
