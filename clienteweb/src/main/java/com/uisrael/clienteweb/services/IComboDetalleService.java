package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.ComboDetalleRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboDetalleResponseDto;

public interface IComboDetalleService {

	List<ComboDetalleResponseDto> listarComboDetalle();

	ComboDetalleResponseDto buscarPorId(int id);

	void crear(ComboDetalleRequestDto detalle);

	void eliminar(int id);

}
