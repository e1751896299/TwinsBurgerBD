package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ProductoResponseDto;

@Mapper(componentModel = "spring")
public interface IProductoDtoMapper {
	@Mapping(source = "prodPrecio", target = "prodPrecio")
	@Mapping(source = "prodImagen", target = "prodImagen")
	@Mapping(target = "proFechaCreacion", ignore = true)
	@Mapping(target = "prodEstado", ignore = true)
	Producto toDomain(ProductoRequestDto dto);

	@Mapping(source = "prodPrecio", target = "prodPrecio")
	@Mapping(source = "prodImagen", target = "prodImagen")
	ProductoResponseDto toResponseDto(Producto productoPojo);

}
