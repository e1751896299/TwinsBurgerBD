package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.DetalleOrdenCompra;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetalleOrdenCompraEntity;

@Mapper(componentModel = "spring")
public interface IDetalleOrdenCompraJpaMapper {

	@Mapping(target = "idOrdenCompra", source = "fkOrdenCompra.idOrdenCompra")
	@Mapping(target = "idProducto", source = "fkProducto.idProducto")
	@Mapping(target = "productoNombre", source = "fkProducto.prodNombre")
	DetalleOrdenCompra toDomain(DetalleOrdenCompraEntity detalleEntity);

	@Mapping(target = "fkOrdenCompra", ignore = true)
	@Mapping(target = "fkProducto", ignore = true)
	DetalleOrdenCompraEntity toEntity(DetalleOrdenCompra detallePojo);

}
