package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;
import com.uisrael.twinsburger.dominio.repositorios.IOrdenCompraRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IOrdenCompraJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IOrdenCompraJpaRepositorio;

public class OrdenCompraRepositorioImpl implements IOrdenCompraRepositorio {

	private final IOrdenCompraJpaRepositorio jpaRepositorio;
	private final IOrdenCompraJpaMapper entityMapper;

	public OrdenCompraRepositorioImpl(IOrdenCompraJpaRepositorio jpaRepositorio, IOrdenCompraJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public OrdenCompra guardar(OrdenCompra nuevaOrden) {
		OrdenCompraEntity entity = entityMapper.toEntity(nuevaOrden);
		OrdenCompraEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<OrdenCompra> buscarId(int idOrdenCompra) {
		return jpaRepositorio.findById(idOrdenCompra).map(entityMapper::toDomain);
	}

	@Override
	public List<OrdenCompra> listaTodos() {
		return jpaRepositorio.findByOcEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idOrdenCompra) {
		OrdenCompraEntity orden = jpaRepositorio.findById(idOrdenCompra)
				.orElseThrow(() -> new RuntimeException("Orden de compra no encontrada"));
		orden.setOcEstado(false);
		jpaRepositorio.save(orden);
	}

}
