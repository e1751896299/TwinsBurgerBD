package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Administrador;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.AdministradorEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IAdministradorJpaMapperImpl implements IAdministradorJpaMapper {

    @Override
    public Administrador toDomain(AdministradorEntity administradorEntity) {
        if ( administradorEntity == null ) {
            return null;
        }

        Administrador administrador = new Administrador();

        administrador.setIdAdmin( administradorEntity.getIdAdmin() );
        administrador.setAdminNombre( administradorEntity.getAdminNombre() );
        administrador.setAdminApellido( administradorEntity.getAdminApellido() );
        administrador.setAdminCorreo( administradorEntity.getAdminCorreo() );
        administrador.setAdminContrasena( administradorEntity.getAdminContrasena() );
        administrador.setAdminEstado( administradorEntity.isAdminEstado() );

        return administrador;
    }

    @Override
    public AdministradorEntity toEntity(Administrador administradorPojo) {
        if ( administradorPojo == null ) {
            return null;
        }

        AdministradorEntity administradorEntity = new AdministradorEntity();

        administradorEntity.setAdminApellido( administradorPojo.getAdminApellido() );
        administradorEntity.setAdminContrasena( administradorPojo.getAdminContrasena() );
        administradorEntity.setAdminCorreo( administradorPojo.getAdminCorreo() );
        administradorEntity.setAdminEstado( administradorPojo.isAdminEstado() );
        administradorEntity.setAdminNombre( administradorPojo.getAdminNombre() );
        administradorEntity.setIdAdmin( administradorPojo.getIdAdmin() );

        return administradorEntity;
    }
}
