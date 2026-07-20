package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;

@Mapper(componentModel = "spring")
public interface IPedidoJpaMapper {

	Pedido toDomain(PedidoEntity pedidoEntity);
	
	@Mapping(target = "detallesPedidos", ignore = true)
	@Mapping(target = "fkCliente", ignore = true)
	@Mapping(target = "fkAdministrador", ignore = true)
	@Mapping(target = "fkHorarioRetiro", ignore = true)
	@Mapping(target = "pagos", ignore = true)
	PedidoEntity toEntity(Pedido pedidoPojo);
}
