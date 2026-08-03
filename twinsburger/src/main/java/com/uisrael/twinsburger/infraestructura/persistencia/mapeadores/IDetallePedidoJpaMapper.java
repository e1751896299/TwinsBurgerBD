package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;

@Mapper(componentModel = "spring")
public interface IDetallePedidoJpaMapper {
	
	@Mapping(target = "idProducto", expression = "java(detalleEntity.getFkProducto() == null ? 0 : detalleEntity.getFkProducto().getIdProducto())")
	@Mapping(target = "prodNombre", expression = "java(detalleEntity.getFkProducto() != null ? detalleEntity.getFkProducto().getProdNombre() : detalleEntity.getFkCombo().getComboNombre())")
	DetallePedido toDomain(DetallePedidoEntity detalleEntity );
	
	@Mapping(target = "fkPedido", ignore = true)
	@Mapping(target = "fkProducto", ignore = true)
	@Mapping(target = "fkCombo", ignore = true)
	DetallePedidoEntity toEntity(DetallePedido detallePojo);

}
