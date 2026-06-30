package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.presentacion.dto.request.MetodoPagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.MetodoPagoResponseDto;

@Mapper(componentModel = "spring")
public interface IMetodoPagoDtoMapper {
	
	MetodoPago toDomain(MetodoPagoRequestDto dto);
	MetodoPagoResponseDto toResponseDto(MetodoPago metodoPagoPojo);

}
