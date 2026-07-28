package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.dominio.repositorios.IAdministradorRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IAdministradorJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IAdministradorJpaRepositorio;

public class AdministradorRepositorioImpl implements IAdministradorRepositorio {
	
	private final IAdministradorJpaRepositorio jpaRepositorio;
	private final IAdministradorJpaMapper entityMapper;

	public AdministradorRepositorioImpl(IAdministradorJpaRepositorio jpaRepositorio,
			IAdministradorJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Administrador guardar(Administrador nuevoAdministrador) {
		AdministradorEntity entity = entityMapper.toEntity(nuevoAdministrador);
		AdministradorEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Administrador> buscarId(int idAdministrador) {
		return jpaRepositorio.findById(idAdministrador).map(entityMapper::toDomain);
	}

	@Override
	public List<Administrador> listaTodos() {
		return jpaRepositorio.findByAdminEstadoTrue	().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idAdminsitrador) {
		 AdministradorEntity administrador = jpaRepositorio.findById(idAdminsitrador)
		            .orElseThrow(() -> new RuntimeException("Administrador no encontrado"));
		 administrador.setAdminEstado(false);
		 jpaRepositorio.save(administrador);	
	}

	@Override
	public Optional<Administrador> findByAdminCorreo(String correo) {
		return jpaRepositorio.findByAdminCorreo(correo).map(entityMapper::toDomain);
	}

}
