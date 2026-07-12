package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {
	
	DetallePedido toDomain(DetallePedidoEntity detalleEntity );
	
	DetallePedidoEntity toEntity(DetallePedido detallePojo);

}
