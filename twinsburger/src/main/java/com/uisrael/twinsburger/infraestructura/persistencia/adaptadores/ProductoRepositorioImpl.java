 package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.dominio.repositorios.IProductoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

public class ProductoRepositorioImpl implements IProductoRepositorio{

	private final IProductoJpaRepositorio jpaRepositorio;
	private final IProductoJpaMapper entityMapper;
	private final ICategoriaJpaRepositorio categoriaJpaRepositorio;


	public ProductoRepositorioImpl(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper entityMapper, ICategoriaJpaRepositorio categoriaJpaRepositorio) {
		super();
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
		this.categoriaJpaRepositorio = categoriaJpaRepositorio;
	}

	@Override
	public Producto guardar(Producto nuevoProducto) {
		ProductoEntity entity = entityMapper.toEntity(nuevoProducto);
		CategoriaEntity categoria = categoriaJpaRepositorio.findById(nuevoProducto.getIdCategoria())
				.orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
		entity.setFkCategoria(categoria);
		ProductoEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Producto> buscarId(int idProducto) {
		return jpaRepositorio.findById(idProducto).map(entityMapper::toDomain);
	}

	@Override
	public List<Producto> listaTodos() {
		return jpaRepositorio.findByProdEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idProducto) {
		ProductoEntity producto = jpaRepositorio.findById(idProducto)
	            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
	 producto.setProdEstado(false);
	 jpaRepositorio.save(producto);
		
	}


	@Override
	public List<Producto> findByProdNombre(String nombre) {
		return jpaRepositorio.findByProdNombre(nombre).stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public List<Producto> buscarPorCategoria(Integer idCategoria) {
		return jpaRepositorio.buscarPorCategoria(idCategoria).stream().map(entityMapper::toDomain).toList();
	}

	
}
