package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.presentacion.dto.request.PagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PagoResponseDto;

@Mapper(componentModel = "spring")
public interface IPagoDtoMapper {
	
	@Mapping(target = "pagoEstado", ignore = true)
	@Mapping(target = "idPedido", ignore = true)
	@Mapping(target = "metodoPago", ignore = true)
	Pago toDomain(PagoRequestDto dto);
	PagoResponseDto toResponseDto(Pago pagoPojo);

}
