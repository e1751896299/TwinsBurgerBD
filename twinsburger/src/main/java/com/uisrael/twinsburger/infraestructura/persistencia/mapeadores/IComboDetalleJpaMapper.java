package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.ComboDetalle;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboDetalleEntity;

@Mapper(componentModel = "spring")
public interface IComboDetalleJpaMapper {

	@Mapping(target = "idCombo", source = "fkCombo.idCombo")
	@Mapping(target = "idProducto", source = "fkProducto.idProducto")
	@Mapping(target = "productoNombre", source = "fkProducto.prodNombre")
	ComboDetalle toDomain(ComboDetalleEntity detalleEntity);

	@Mapping(target = "fkCombo", ignore = true)
	@Mapping(target = "fkProducto", ignore = true)
	ComboDetalleEntity toEntity(ComboDetalle detallePojo);

}
