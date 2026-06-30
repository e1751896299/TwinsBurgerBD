package com.uisrael.twinsburger.presentacion.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AdministradorRequestDto {
	
	
	private int idAdmin;
	@NotBlank
	private String adminNombre;
	@NotBlank
	private String adminApellido;
	@NotBlank@NotBlank
	private String adminCorreo;
	@NotBlank
	private String adminContrasena;

}
