package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {
	
	Producto toDomain(ProductoEntity productoEntity);
	
	@Mapping(target = "detallesPedidos", ignore = true)
	@Mapping(target = "fkCategoria", ignore = true)
	ProductoEntity toEntity(Producto productoPojo);

}
