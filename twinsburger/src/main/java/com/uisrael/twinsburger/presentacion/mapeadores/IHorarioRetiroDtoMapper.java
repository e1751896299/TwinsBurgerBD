package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.presentacion.dto.request.HorarioRetiroRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.HorarioRetiroresponseDto;

@Mapper(componentModel = "spring")
public interface IHorarioRetiroDtoMapper {
	
	HorarioRetiro toDomain(HorarioRetiroRequestDto dto);
	HorarioRetiroresponseDto toResponseDto(HorarioRetiro horarioRetiroPojo);

}
