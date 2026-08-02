package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.OrdenCompra;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.OrdenCompraEntity;

@Mapper(componentModel = "spring")
public interface IOrdenCompraJpaMapper {

	OrdenCompra toDomain(OrdenCompraEntity ordenCompraEntity);

	@Mapping(target = "detalles", ignore = true)
	OrdenCompraEntity toEntity(OrdenCompra ordenCompraPojo);

}
