package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CategoriaResponseDto;

@Mapper(componentModel = "spring")
public interface ICategoriaDtoMapper {
	
	Categoria toDomain(CategoriaRequestDto dto);
	CategoriaResponseDto toResponseDto(Categoria categoriaPojo);

}
