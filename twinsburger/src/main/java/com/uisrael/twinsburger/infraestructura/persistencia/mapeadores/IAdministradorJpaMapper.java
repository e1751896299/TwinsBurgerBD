package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;

@Mapper(componentModel = "spring")
public interface IAdministradorJpaMapper {
	
	Administrador toDomain(AdministradorEntity administradorEntity);
	
	@Mapping(target = "pedidos", ignore = true)
	AdministradorEntity toEntity(Administrador administradorPojo);
	
}
