package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.presentacion.dto.request.AdministradorRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.AdministradorResponseDto;

@Mapper(componentModel = "spring")
public interface IAdministradorDtoMapper {
	
	Administrador toDomain(AdministradorRequestDto dto);
	AdministradorResponseDto toResponseDto(Administrador administradorPojo);

}
