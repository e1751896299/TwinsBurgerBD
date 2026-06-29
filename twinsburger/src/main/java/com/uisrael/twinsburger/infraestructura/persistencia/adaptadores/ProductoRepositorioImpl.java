 package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.dominio.repositorios.IProductoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio{
	
	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;
	

	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		ProductoEntity entity = entityMapper.toEntity(nuevoProducto);
		ProductoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Producto> buscarId(int idProducto) {
		return jpaRepositorio.findById(idProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProducto) {
		jpaRepositorio.deleteById(idProducto);
		
	}

}
