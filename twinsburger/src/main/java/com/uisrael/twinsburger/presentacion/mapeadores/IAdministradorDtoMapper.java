package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.presentacion.dto.request.AdministradorRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.AdministradorResponseDto;

@Mapper(componentModel = "spring")
public interface IAdministradorDtoMapper {
	
    @Mapping(target = "adminEstado", ignore = true)
	Administrador toDomain(AdministradorRequestDto dto);
	AdministradorResponseDto toResponseDto(Administrador administradorPojo);

}
