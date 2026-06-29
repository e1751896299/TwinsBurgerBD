package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.ICategoriaJpaRepositorio;

public class CategoriaRepositorioImpl implements ICategoriaRepositorio{
	
	private final ICategoriaJpaRepositorio jpaRepositorio;
	private final ICategoriaJpaMapper entityMapper;
	
	

	public CategoriaRepositorioImpl(ICategoriaJpaRepositorio jpaRepositorio, ICategoriaJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Categoria guardar(Categoria nuevaCategoria) {
		CategoriaEntity entity = entityMapper.toEntity(nuevaCategoria);
		CategoriaEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Categoria> buscarId(int idCategoria) {
		return jpaRepositorio.findById(idCategoria).map(entityMapper::toDomain);
	}

	@Override
	public List<Categoria> listaTodos() {
		return jpaRepositorio.findAll().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCategoria) {
		jpaRepositorio.deleteById(idCategoria);
	}

}
