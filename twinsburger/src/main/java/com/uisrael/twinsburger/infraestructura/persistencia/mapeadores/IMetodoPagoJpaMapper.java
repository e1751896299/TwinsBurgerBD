package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;

@Mapper(componentModel = "spring")
public interface IMetodoPagoJpaMapper {
	
	MetodoPago toDomain(MetodoPagoEntity metodoPagoEntity);
	
	MetodoPagoEntity  toEntity(MetodoPago metodoPagoPojo);
	
}
