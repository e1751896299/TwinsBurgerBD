package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;

@Mapper(componentModel = "spring")
public interface IPagoJpaMapper {
	
	Pago toDomain(PagoEntity pagoEntity);
	
	PagoEntity toEntity(Pago pagoPojo);

}
