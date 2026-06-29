package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;

@Mapper(componentModel = "spring")
public interface ICategoriaJpaMapper {
	
	Categoria toDomain(CategoriaEntity categoriaEntity);
	
	CategoriaEntity toEntity(Categoria categoriaPojo);

}
