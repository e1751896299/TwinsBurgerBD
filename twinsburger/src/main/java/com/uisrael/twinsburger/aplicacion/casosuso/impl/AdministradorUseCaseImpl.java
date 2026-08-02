package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.dominio.repositorios.IAdministradorRepositorio;

public class AdministradorUseCaseImpl implements IAdministradorUseCase{
	
	private final IAdministradorRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;
	
	public AdministradorUseCaseImpl(IAdministradorRepositorio repositorio, PasswordEncoder passwordEncoder) {
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Administrador guardar(Administrador nuevoAdministrador) {
		if (nuevoAdministrador.getAdminCorreo() != null) {
			nuevoAdministrador.setAdminCorreo(nuevoAdministrador.getAdminCorreo().trim().toLowerCase());
		}
		String contrasena = nuevoAdministrador.getAdminContrasena();
		if (nuevoAdministrador.getIdAdmin() > 0 && (contrasena == null || contrasena.isBlank())) {
			nuevoAdministrador.setAdminContrasena(buscarPorId(nuevoAdministrador.getIdAdmin()).getAdminContrasena());
		} else if (contrasena == null || contrasena.isBlank()) {
			throw new IllegalArgumentException("La contraseña es obligatoria");
		} else if (!contrasena.startsWith("$2")) {
			nuevoAdministrador.setAdminContrasena(passwordEncoder.encode(contrasena));
		}
		return repositorio.guardar(nuevoAdministrador);
	}

	@Override
	public Administrador buscarPorId(int idAdministrador) {
		return repositorio.buscarId(idAdministrador)
				.orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
	}

	@Override
	public List<Administrador> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idAdministrador) {
		 Administrador admin = buscarPorId(idAdministrador);

		    admin.setAdminEstado(false);

		    repositorio.guardar(admin);
	}

	@Override
	public Administrador findByAdminCorreo(String correo) {
		return repositorio.findByAdminCorreo(correo)
				.orElseThrow(()-> new RuntimeException("No encontrado"));
				
	}

}
