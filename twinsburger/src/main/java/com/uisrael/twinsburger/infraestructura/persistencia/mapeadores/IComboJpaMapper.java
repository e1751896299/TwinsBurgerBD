package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Combo;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ComboEntity;

@Mapper(componentModel = "spring")
public interface IComboJpaMapper {

	Combo toDomain(ComboEntity comboEntity);

	@Mapping(target = "detalles", ignore = true)
	ComboEntity toEntity(Combo comboPojo);

}
