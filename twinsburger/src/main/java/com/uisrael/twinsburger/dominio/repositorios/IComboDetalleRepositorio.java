package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;

public interface IComboDetalleRepositorio {

	ComboDetalle guardar(ComboDetalle nuevoDetalle);

	Optional<ComboDetalle> buscarId(int idDetalle);

	List<ComboDetalle> listarTodos();

	void eliminar(int idDetalle);

	List<ComboDetalle> obtenerComboDetalle(Integer idCombo);

}
