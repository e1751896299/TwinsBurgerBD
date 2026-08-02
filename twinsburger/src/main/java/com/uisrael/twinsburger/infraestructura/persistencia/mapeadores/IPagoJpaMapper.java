package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;

@Mapper(componentModel = "spring")
public interface IPagoJpaMapper {
	
	@Mapping(target = "idPedido", source = "fkPedido.idPedido")
	@Mapping(target = "idMetodoPago", source = "fkMetodoPago.idMetodoPago")
	@Mapping(target = "metodoPagoDescripcion", source = "fkMetodoPago.mpagoDescripcion")
	Pago toDomain(PagoEntity pagoEntity);

	@Mapping(target = "fkMetodoPago", ignore = true)
	@Mapping(target = "fkPedido", ignore = true)
	PagoEntity toEntity(Pago pagoPojo);

}
