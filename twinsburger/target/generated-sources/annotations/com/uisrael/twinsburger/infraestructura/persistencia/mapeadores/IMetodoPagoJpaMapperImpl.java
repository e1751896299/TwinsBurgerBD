package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.MetodoPagoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IMetodoPagoJpaMapperImpl implements IMetodoPagoJpaMapper {

    @Override
    public MetodoPago toDomain(MetodoPagoEntity metodoPagoEntity) {
        if ( metodoPagoEntity == null ) {
            return null;
        }

        MetodoPago metodoPago = new MetodoPago();

        metodoPago.setIdMetodoPago( metodoPagoEntity.getIdMetodoPago() );
        metodoPago.setMpagoDescripcion( metodoPagoEntity.getMpagoDescripcion() );
        metodoPago.setMpagoEstado( metodoPagoEntity.isMpagoEstado() );

        return metodoPago;
    }

    @Override
    public MetodoPagoEntity toEntity(MetodoPago metodoPagoPojo) {
        if ( metodoPagoPojo == null ) {
            return null;
        }

        MetodoPagoEntity metodoPagoEntity = new MetodoPagoEntity();

        metodoPagoEntity.setIdMetodoPago( metodoPagoPojo.getIdMetodoPago() );
        metodoPagoEntity.setMpagoDescripcion( metodoPagoPojo.getMpagoDescripcion() );
        metodoPagoEntity.setMpagoEstado( metodoPagoPojo.isMpagoEstado() );

        return metodoPagoEntity;
    }
}
