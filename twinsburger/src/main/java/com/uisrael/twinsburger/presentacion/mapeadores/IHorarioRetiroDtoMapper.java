package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.presentacion.dto.request.HorarioRetiroRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.HorarioRetiroResponseDto;

@Mapper(componentModel = "spring")
public interface IHorarioRetiroDtoMapper {
	
	HorarioRetiro toDomain(HorarioRetiroRequestDto dto);
	HorarioRetiroResponseDto toResponseDto(HorarioRetiro horarioRetiroPojo);

}
