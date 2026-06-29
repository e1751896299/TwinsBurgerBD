package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;

@Mapper(componentModel = "spring")
public interface IProductoJpaMapper {
	
	Producto toDomain(ProductoEntity productoEntity);
	
	ProductoEntity toEntity(Producto productoPojo);

}
