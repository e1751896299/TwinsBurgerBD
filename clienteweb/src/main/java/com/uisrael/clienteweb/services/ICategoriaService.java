package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.CategoriaRequestDto;
import com.uisrael.clienteweb.model.dto.response.CategoriaResponseDto;

public interface ICategoriaService {

	List<CategoriaResponseDto> listarCategoria();

	CategoriaResponseDto buscarPorId(int id);

	void crear(CategoriaRequestDto categoria);

	void eliminar(int id);

}
