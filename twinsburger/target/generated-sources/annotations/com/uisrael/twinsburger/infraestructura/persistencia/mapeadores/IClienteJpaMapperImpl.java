package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ClienteEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IClienteJpaMapperImpl implements IClienteJpaMapper {

    @Override
    public Cliente toDomain(ClienteEntity clienteEntity) {
        if ( clienteEntity == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCliActivo( clienteEntity.isCliActivo() );
        cliente.setIdCliente( clienteEntity.getIdCliente() );
        cliente.setCliNombre( clienteEntity.getCliNombre() );
        cliente.setCliApellido( clienteEntity.getCliApellido() );
        cliente.setCliCorreo( clienteEntity.getCliCorreo() );
        cliente.setCliTelefono( clienteEntity.getCliTelefono() );
        cliente.setCliContrasena( clienteEntity.getCliContrasena() );
        cliente.setCliEstado( clienteEntity.isCliEstado() );

        return cliente;
    }

    @Override
    public ClienteEntity toEntity(Cliente clientePojo) {
        if ( clientePojo == null ) {
            return null;
        }

        ClienteEntity clienteEntity = new ClienteEntity();

        clienteEntity.setCliActivo( clientePojo.isCliActivo() );
        clienteEntity.setCliApellido( clientePojo.getCliApellido() );
        clienteEntity.setCliContrasena( clientePojo.getCliContrasena() );
        clienteEntity.setCliCorreo( clientePojo.getCliCorreo() );
        clienteEntity.setCliEstado( clientePojo.isCliEstado() );
        clienteEntity.setCliNombre( clientePojo.getCliNombre() );
        clienteEntity.setCliTelefono( clientePojo.getCliTelefono() );
        clienteEntity.setIdCliente( clientePojo.getIdCliente() );

        return clienteEntity;
    }
}
