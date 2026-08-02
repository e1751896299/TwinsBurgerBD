package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;
import com.uisrael.twinsburger.presentacion.dto.request.OrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.OrdenCompraResponseDto;

@Mapper(componentModel = "spring")
public interface IOrdenCompraDtoMapper {

	OrdenCompra toDomain(OrdenCompraRequestDto dto);
	OrdenCompraResponseDto toResponseDto(OrdenCompra ordenCompraPojo);

}
