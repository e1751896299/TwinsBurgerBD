package com.uisrael.twinsburger.dominio.repositorios;

import java.util.List;
import java.util.Optional;

import com.uisrael.twinsburger.dominio.entidades.Combo;

public interface IComboRepositorio {

	Combo guardar(Combo nuevoCombo);

	Optional<Combo> buscarId(int idCombo);

	List<Combo> listaTodos();

	void eliminar(int idCombo);

}
