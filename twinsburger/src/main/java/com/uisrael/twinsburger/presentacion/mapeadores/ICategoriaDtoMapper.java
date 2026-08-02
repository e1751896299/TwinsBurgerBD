package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CategoriaResponseDto;

@Mapper(componentModel = "spring")
public interface ICategoriaDtoMapper {
	
    @Mapping(target = "categoriaEstado", ignore = true)
	Categoria toDomain(CategoriaRequestDto dto);
	CategoriaResponseDto toResponseDto(Categoria categoriaPojo);

}
