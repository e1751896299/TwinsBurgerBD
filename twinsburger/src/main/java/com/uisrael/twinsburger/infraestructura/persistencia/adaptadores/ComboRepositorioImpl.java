package com.uisrael.twinsburger.infraestructura.persistencia.adaptadores;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Combo;
import com.uisrael.twinsburger.dominio.repositorios.IComboRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IComboJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboJpaRepositorio;

public class ComboRepositorioImpl implements IComboRepositorio {

	private final IComboJpaRepositorio jpaRepositorio;
	private final IComboJpaMapper entityMapper;

	public ComboRepositorioImpl(IComboJpaRepositorio jpaRepositorio, IComboJpaMapper entityMapper) {
		this.jpaRepositorio = jpaRepositorio;
		this.entityMapper = entityMapper;
	}

	@Override
	public Combo guardar(Combo nuevoCombo) {
		ComboEntity entity = entityMapper.toEntity(nuevoCombo);
		ComboEntity guardado = jpaRepositorio.save(entity);
		return entityMapper.toDomain(guardado);
	}

	@Override
	public Optional<Combo> buscarId(int idCombo) {
		return jpaRepositorio.findById(idCombo).map(entityMapper::toDomain);
	}

	@Override
	public List<Combo> listaTodos() {
		return jpaRepositorio.findByComboEstadoTrue().stream().map(entityMapper::toDomain).toList();
	}

	@Override
	public void eliminar(int idCombo) {
		ComboEntity combo = jpaRepositorio.findById(idCombo)
				.orElseThrow(() -> new RuntimeException("Combo no encontrado"));
		combo.setComboEstado(false);
		jpaRepositorio.save(combo);
	}

}
