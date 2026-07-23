package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.CategoriaRequestDto;
import com.uisrael.clienteweb.model.dto.response.CategoriaResponseDto;

public interface ICategoriaService {

	List<CategoriaResponseDto> listarCategoria();

	void crear(CategoriaRequestDto categoria);

}
