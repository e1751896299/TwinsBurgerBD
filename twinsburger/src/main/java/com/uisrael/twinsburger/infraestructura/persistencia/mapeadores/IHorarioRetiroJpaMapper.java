package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;

@Mapper(componentModel = "spring")
public interface IHorarioRetiroJpaMapper {
	
	HorarioRetiro toDomain(HorarioRetiroEntity horarioRetiroEntity);
	
	@Mapping(target = "pedidos", ignore = true)
	HorarioRetiroEntity toEntity(HorarioRetiro horarioRetiroPojo);

}
