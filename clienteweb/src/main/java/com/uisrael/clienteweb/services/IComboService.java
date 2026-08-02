package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.ComboRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboResponseDto;

public interface IComboService {

	List<ComboResponseDto> listarCombo();

	ComboResponseDto buscarPorId(int id);

	void crear(ComboRequestDto combo);

	void eliminar(int id);

}
