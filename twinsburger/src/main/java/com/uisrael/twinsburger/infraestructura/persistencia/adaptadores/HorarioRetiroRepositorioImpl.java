package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.dominio.repositorios.IHorarioRetiroRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IHorarioRetiroJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IHorarioRetiroJpaRepositorio;

public class HorarioRetiroRepositorioImpl implements IHorarioRetiroRepositorio{
	
	private final IHorarioRetiroJpaRepositorio jpaRepositorio;
	private final IHorarioRetiroJpaMapper entityMapper;
	

	public HorarioRetiroRepositorioImpl(IHorarioRetiroJpaRepositorio jpaRepositorio,
			IHorarioRetiroJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public HorarioRetiro guardar(HorarioRetiro nuevoHorario) {
		HorarioRetiroEntity entity = entityMapper.toEntity(nuevoHorario);
		HorarioRetiroEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<HorarioRetiro> buscarId(int idHorarioRetiro) {
		return jpaRepositorio.findById(idHorarioRetiro).map(entityMapper::toDomain);
	}

	@Override
	public List<HorarioRetiro> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idHorarioRetiro) {
		jpaRepositorio.deleteById(idHorarioRetiro);
		
	}

}
