package com.uisrael.clienteweb.configuration;

import java.io.Serial;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioAutenticado implements UserDetails {

	@Serial
	private static final long serialVersionUID = 1L;

	private final int id;
	private final String nombre;
	private final String correo;
	private final String rol;

	public UsuarioAutenticado(int id, String nombre, String correo, String rol) {
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.rol = rol;
	}

	public int getId() { return id; }
	public String getNombre() { return nombre; }
	public String getRol() { return rol; }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority("ROLE_" + rol));
	}

	@Override
	public String getPassword() { return ""; }

	@Override
	public String getUsername() { return correo; }
}
