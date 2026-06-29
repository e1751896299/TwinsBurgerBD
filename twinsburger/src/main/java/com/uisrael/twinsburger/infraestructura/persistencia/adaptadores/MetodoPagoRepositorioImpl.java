package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.dominio.repositorios.IMetodoPagoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IMetodoPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IMetodoPagoJpaRepositorio;

public class MetodoPagoRepositorioImpl implements IMetodoPagoRepositorio{
	
	private final IMetodoPagoJpaRepositorio jpaRepositorio;
	private final IMetodoPagoJpaMapper entityMapper;

	public MetodoPagoRepositorioImpl(IMetodoPagoJpaRepositorio jpaRepositorio, IMetodoPagoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}


	@Override
	public MetodoPago guardar(MetodoPago nuevoMetodoPago) {
		MetodoPagoEntity entity = entityMapper.toEntity(nuevoMetodoPago);
		MetodoPagoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<MetodoPago> buscarId(int idMetodoPago) {
		return jpaRepositorio.findById(idMetodoPago).map(entityMapper::toDomain);
	}

	@Override
	public List<MetodoPago> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idMetodoPago) {
		jpaRepositorio.deleteById(idMetodoPago);
		
	}

}
