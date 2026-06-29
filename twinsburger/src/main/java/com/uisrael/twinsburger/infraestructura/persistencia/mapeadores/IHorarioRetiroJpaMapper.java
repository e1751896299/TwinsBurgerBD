package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;

@Mapper(componentModel = "spring")
public interface IHorarioRetiroJpaMapper {
	
	HorarioRetiro toDomain(HorarioRetiroEntity horarioRetiroEntity);
	
	HorarioRetiroEntity toEntity(HorarioRetiro horarioRetiroPojo);

}
