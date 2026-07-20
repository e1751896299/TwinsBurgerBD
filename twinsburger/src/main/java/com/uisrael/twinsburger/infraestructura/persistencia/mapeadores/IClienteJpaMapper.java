package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ClienteEntity;

@Mapper(componentModel = "spring")
public interface IClienteJpaMapper {
	
	Cliente toDomain(ClienteEntity clienteEntity);
	
	@Mapping(target = "pedidos", ignore = true)
	ClienteEntity toEntity(Cliente clientePojo);

}
