package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {
	
	Producto toDomain(ProductoRequestDto dto);
	ProductoResponseDto toResponseDto(Producto productoPojo);

}
