package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PagoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPagoJpaMapperImpl implements IPagoJpaMapper {

    @Override
    public Pago toDomain(PagoEntity pagoEntity) {
        if ( pagoEntity == null ) {
            return null;
        }

        Pago pago = new Pago();

        pago.setIdPago( pagoEntity.getIdPago() );
        pago.setPagoFecha( pagoEntity.getPagoFecha() );
        pago.setPagoMonto( pagoEntity.getPagoMonto() );
        pago.setPagoEstado( pagoEntity.isPagoEstado() );

        pago.setIdPedido( pagoEntity.getFkPedido() == null ? 0 : pagoEntity.getFkPedido().getIdPedido() );
        pago.setMetodoPago( pagoEntity.getFkMetodoPago() == null ? null : pagoEntity.getFkMetodoPago().getMpagoDescripcion() );

        return pago;
    }

    @Override
    public PagoEntity toEntity(Pago pagoPojo) {
        if ( pagoPojo == null ) {
            return null;
        }

        PagoEntity pagoEntity = new PagoEntity();

        pagoEntity.setIdPago( pagoPojo.getIdPago() );
        pagoEntity.setPagoEstado( pagoPojo.isPagoEstado() );
        pagoEntity.setPagoFecha( pagoPojo.getPagoFecha() );
        pagoEntity.setPagoMonto( pagoPojo.getPagoMonto() );

        return pagoEntity;
    }
}
