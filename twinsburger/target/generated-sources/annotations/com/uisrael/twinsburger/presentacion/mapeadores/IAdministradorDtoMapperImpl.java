package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.presentacion.dto.request.AdministradorRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.AdministradorResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IAdministradorDtoMapperImpl implements IAdministradorDtoMapper {

    @Override
    public Administrador toDomain(AdministradorRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Administrador administrador = new Administrador();

        administrador.setIdAdmin( dto.getIdAdmin() );
        administrador.setAdminNombre( dto.getAdminNombre() );
        administrador.setAdminApellido( dto.getAdminApellido() );
        administrador.setAdminCorreo( dto.getAdminCorreo() );
        administrador.setAdminContrasena( dto.getAdminContrasena() );

        return administrador;
    }

    @Override
    public AdministradorResponseDto toResponseDto(Administrador administradorPojo) {
        if ( administradorPojo == null ) {
            return null;
        }

        AdministradorResponseDto administradorResponseDto = new AdministradorResponseDto();

        administradorResponseDto.setIdAdmin( administradorPojo.getIdAdmin() );
        administradorResponseDto.setAdminNombre( administradorPojo.getAdminNombre() );
        administradorResponseDto.setAdminApellido( administradorPojo.getAdminApellido() );
        administradorResponseDto.setAdminCorreo( administradorPojo.getAdminCorreo() );
        administradorResponseDto.setAdminEstado( administradorPojo.isAdminEstado() );

        return administradorResponseDto;
    }
}
