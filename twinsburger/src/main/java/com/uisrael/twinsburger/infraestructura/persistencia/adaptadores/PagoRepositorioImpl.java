package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.dominio.repositorios.IPagoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IPagoJpaRepositorio;

public class PagoRepositorioImpl implements IPagoRepositorio{
	
	private final IPagoJpaRepositorio jpaRepositorio;
	private final IPagoJpaMapper entityMapper;
	
	public PagoRepositorioImpl(IPagoJpaRepositorio jpaRepositorio, IPagoJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}


	@Override
	public Pago guardar(Pago nuevoPago) {
		PagoEntity entity = entityMapper.toEntity(nuevoPago);
		PagoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Pago> buscarId(int idPago) {
		return jpaRepositorio.findById(idPago).map(entityMapper::toDomain);
	}

	@Override
	public List<Pago> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idPago) {
		jpaRepositorio.deleteById(idPago);
		
	}

}
