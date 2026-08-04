package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Cliente;
import com.uisrael.twinsburger.presentacion.dto.request.ClienteRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ClienteResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IClienteDtoMapperImpl implements IClienteDtoMapper {

    @Override
    public Cliente toDomain(ClienteRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setCliActivo( dto.isCliActivo() );
        cliente.setIdCliente( dto.getIdCliente() );
        cliente.setCliNombre( dto.getCliNombre() );
        cliente.setCliApellido( dto.getCliApellido() );
        cliente.setCliCorreo( dto.getCliCorreo() );
        cliente.setCliTelefono( dto.getCliTelefono() );
        cliente.setCliContrasena( dto.getCliContrasena() );

        return cliente;
    }

    @Override
    public ClienteResponseDto toResponseDto(Cliente clientePojo) {
        if ( clientePojo == null ) {
            return null;
        }

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto();

        clienteResponseDto.setCliActivo( clientePojo.isCliActivo() );
        clienteResponseDto.setCliEstado( clientePojo.isCliEstado() );
        clienteResponseDto.setIdCliente( clientePojo.getIdCliente() );
        clienteResponseDto.setCliNombre( clientePojo.getCliNombre() );
        clienteResponseDto.setCliApellido( clientePojo.getCliApellido() );
        clienteResponseDto.setCliCorreo( clientePojo.getCliCorreo() );
        clienteResponseDto.setCliTelefono( clientePojo.getCliTelefono() );

        return clienteResponseDto;
    }
}
