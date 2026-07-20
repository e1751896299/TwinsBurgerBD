package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {
	
	DetallePedido toDomain(DetallePedidoEntity detalleEntity );
	
	@Mapping(target = "fkPedido", ignore = true)
	@Mapping(target = "fkProducto", ignore = true)
	DetallePedidoEntity toEntity(DetallePedido detallePojo);

}
