package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.presentacion.dto.request.ClienteRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ClienteResponseDto;

@Mapper(componentModel = "spring")
public interface IClienteDtoMapper {
	
	Cliente toDomain(ClienteRequestDto dto);
	ClienteResponseDto toResponseDto(Cliente clientePojo);

}
