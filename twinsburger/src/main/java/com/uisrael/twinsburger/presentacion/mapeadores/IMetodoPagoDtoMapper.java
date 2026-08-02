package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.presentacion.dto.request.MetodoPagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.MetodoPagoResponseDto;

@Mapper(componentModel = "spring")
public interface IMetodoPagoDtoMapper {
	
	@Mapping(target = "mpagoEstado", ignore = true)
	MetodoPago toDomain(MetodoPagoRequestDto dto);
	MetodoPagoResponseDto toResponseDto(MetodoPago metodoPagoPojo);

}
