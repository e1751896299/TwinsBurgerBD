package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.Combo;

public interface IComboUseCase {

	Combo guardar(Combo nuevoCombo);

	Combo buscarPorId(int idCombo);

	List<Combo> listarTodos();

	void eliminar(int idCombo);

}
