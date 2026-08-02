package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.presentacion.dto.request.HorarioRetiroRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.HorarioRetiroResponseDto;

@Mapper(componentModel = "spring")
public interface IHorarioRetiroDtoMapper {
	
	@Mapping(target = "hrEstado", ignore = true)
	HorarioRetiro toDomain(HorarioRetiroRequestDto dto);
	HorarioRetiroResponseDto toResponseDto(HorarioRetiro horarioRetiroPojo);

}
