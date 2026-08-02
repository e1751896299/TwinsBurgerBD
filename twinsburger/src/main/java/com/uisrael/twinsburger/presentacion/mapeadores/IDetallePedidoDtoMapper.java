package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.presentacion.dto.request.DetallePedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.DetallePedidoResponseDto;

@Mapper(componentModel = "spring")
public interface IDetallePedidoDtoMapper {
	
	@Mapping(target = "detalleEstado", ignore = true)
	DetallePedido toDomain(DetallePedidoRequestDto dto);
	
	DetallePedidoResponseDto toResponseDto(DetallePedido detallePojo);
}
