package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Combo;
import com.uisrael.twinsburger.presentacion.dto.request.ComboRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboResponseDto;

@Mapper(componentModel = "spring")
public interface IComboDtoMapper {

	Combo toDomain(ComboRequestDto dto);
	ComboResponseDto toResponseDto(Combo comboPojo);

}
