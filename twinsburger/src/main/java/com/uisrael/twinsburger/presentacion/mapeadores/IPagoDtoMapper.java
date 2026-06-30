package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.presentacion.dto.request.PagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PagoResponseDto;

@Mapper(componentModel = "spring")
public interface IPagoDtoMapper {
	
	Pago toDomain(PagoRequestDto dto);
	PagoResponseDto toResponsedDto(Pago pagoPojo);

}
