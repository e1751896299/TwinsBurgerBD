package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {
	@Mapping(source = "prodPrecio", target = "prodPrecio")
	@Mapping(source = "prodImagen", target = "prodImagen")
	Producto toDomain(ProductoEntity productoEntity);
	
	@Mapping(target = "detallesPedidos", ignore = true)
	@Mapping(target = "fkCategoria", ignore = true)
	@Mapping(source = "prodPrecio", target = "prodPrecio")
	@Mapping(source = "prodImagen", target = "prodImagen")
	ProductoEntity toEntity(Producto productoPojo);

}
