package com.uisrael.clienteweb.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class RegistroClienteDto {

	@NotBlank(message = "El nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "El apellido es obligatorio")
	private String apellido;
	@NotBlank(message = "El correo es obligatorio")
	@Email(message = "Ingresa un correo válido")
	private String correo;
	@Pattern(regexp = "^$|[0-9+() -]{7,20}$", message = "Ingresa un teléfono válido")
	private String telefono;
	@NotBlank(message = "La contraseña es obligatoria")
	@Size(min = 8, max = 72, message = "La contraseña debe tener entre 8 y 72 caracteres")
	private String contrasena;
	@NotBlank(message = "Confirma la contraseña")
	private String confirmarContrasena;

	public String getNombre() { return nombre; }
	public void setNombre(String nombre) { this.nombre = nombre; }
	public String getApellido() { return apellido; }
	public void setApellido(String apellido) { this.apellido = apellido; }
	public String getCorreo() { return correo; }
	public void setCorreo(String correo) { this.correo = correo; }
	public String getTelefono() { return telefono; }
	public void setTelefono(String telefono) { this.telefono = telefono; }
	public String getContrasena() { return contrasena; }
	public void setContrasena(String contrasena) { this.contrasena = contrasena; }
	public String getConfirmarContrasena() { return confirmarContrasena; }
	public void setConfirmarContrasena(String confirmarContrasena) { this.confirmarContrasena = confirmarContrasena; }
}
