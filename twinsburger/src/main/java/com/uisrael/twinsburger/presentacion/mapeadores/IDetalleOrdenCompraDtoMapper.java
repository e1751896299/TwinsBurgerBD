package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;
import com.uisrael.twinsburger.presentacion.dto.request.DetalleOrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.DetalleOrdenCompraResponseDto;

@Mapper(componentModel = "spring")
public interface IDetalleOrdenCompraDtoMapper {

	DetalleOrdenCompra toDomain(DetalleOrdenCompraRequestDto dto);
	DetalleOrdenCompraResponseDto toResponseDto(DetalleOrdenCompra detallePojo);

}
