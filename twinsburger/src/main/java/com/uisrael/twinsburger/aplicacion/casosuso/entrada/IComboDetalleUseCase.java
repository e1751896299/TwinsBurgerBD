package com.uisrael.twinsburger.aplicacion.casosuso.entrada;

import java.util.List;

import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;

public interface IComboDetalleUseCase {

	ComboDetalle crear(ComboDetalle detalle);

	ComboDetalle buscarPorId(int idDetalle);

	List<ComboDetalle> listarTodos();

	void eliminar(int idDetalle);

	List<ComboDetalle> obtenerComboDetalle(Integer idCombo);

}
