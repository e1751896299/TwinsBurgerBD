package com.uisrael.twinsburger.presentacion.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;
import com.uisrael.twinsburger.presentacion.dto.request.ComboDetalleRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboDetalleResponseDto;

@Mapper(componentModel = "spring")
public interface IComboDetalleDtoMapper {

	ComboDetalle toDomain(ComboDetalleRequestDto dto);
	ComboDetalleResponseDto toResponseDto(ComboDetalle detallePojo);

}
