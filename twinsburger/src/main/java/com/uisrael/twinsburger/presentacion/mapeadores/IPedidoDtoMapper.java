package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.presentacion.dto.request.PedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PedidoResponseDto;

@Mapper(componentModel = "spring")
public interface IPedidoDtoMapper {
	
	@Mapping(target = "pedidoEstado", ignore = true)
	@Mapping(target = "pedidoEstadoProceso", ignore = true)
	Pedido toDomain(PedidoRequestDto dto);
	
	PedidoResponseDto toResponseDto(Pedido pedidoPojo);

}
