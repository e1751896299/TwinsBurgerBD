package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;

@Mapper(componentModel = "spring")
public interface IPedidoJpaMapper {

	Pedido toDomain(PedidoEntity pedidoEntity);
	
	PedidoEntity toEntity(Pedido pedidoPojo);
}
