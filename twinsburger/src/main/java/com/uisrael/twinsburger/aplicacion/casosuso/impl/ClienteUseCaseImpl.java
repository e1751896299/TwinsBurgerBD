package com.uisrael.twinsburger.aplicacion.casosuso.impl;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.dominio.repositorios.IClienteRepositorio;

public class ClienteUseCaseImpl implements IClienteUseCase{
	
	private final IClienteRepositorio repositorio;
	private final PasswordEncoder passwordEncoder;

	public ClienteUseCaseImpl(IClienteRepositorio repositorio, PasswordEncoder passwordEncoder) {
		this.repositorio = repositorio;
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public Cliente guardar(Cliente nuevoCliente) {
		if (nuevoCliente.getCliCorreo() != null) {
			nuevoCliente.setCliCorreo(nuevoCliente.getCliCorreo().trim().toLowerCase());
		}
		String contrasena = nuevoCliente.getCliContrasena();
		if (nuevoCliente.getIdCliente() > 0 && (contrasena == null || contrasena.isBlank())) {
			nuevoCliente.setCliContrasena(buscarPorId(nuevoCliente.getIdCliente()).getCliContrasena());
		} else if (contrasena == null || contrasena.isBlank()) {
			throw new IllegalArgumentException("La contraseña es obligatoria");
		} else if (!contrasena.startsWith("$2")) {
			nuevoCliente.setCliContrasena(passwordEncoder.encode(contrasena));
		}
		return repositorio.guardar(nuevoCliente);
	}

	@Override
	public Cliente buscarPorId(int idCliente) {
		return repositorio.buscarId(idCliente)
				.orElseThrow(()-> new RuntimeException("Cliente no encontrado"));
	}

	@Override
	public List<Cliente> listarTodos() {
		return repositorio.listaTodos();
	}

	@Override
	public void eliminar(int idCliente) {
		 Cliente cliente = buscarPorId(idCliente);

		    cliente.setCliEstado(false);

		    repositorio.guardar(cliente);
		
	}

	@Override
	public Cliente findByCliCorreo(String correo) {
		return repositorio.findByCliCorreo(correo).orElseThrow(()->new RuntimeException("Correo no encontrado"));
	}

	@Override
	public List<Cliente> buscarPorNombre(String nombre) {
 		return repositorio.buscarPorNombre(nombre);
	}



}
