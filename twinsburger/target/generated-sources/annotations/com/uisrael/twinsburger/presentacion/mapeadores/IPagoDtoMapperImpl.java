package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Pago;
import com.uisrael.twinsburger.presentacion.dto.request.PagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PagoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPagoDtoMapperImpl implements IPagoDtoMapper {

    @Override
    public Pago toDomain(PagoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Pago pago = new Pago();

        pago.setIdPago( dto.getIdPago() );
        pago.setPagoFecha( dto.getPagoFecha() );
        pago.setPagoMonto( dto.getPagoMonto() );

        return pago;
    }

    @Override
    public PagoResponseDto toResponseDto(Pago pagoPojo) {
        if ( pagoPojo == null ) {
            return null;
        }

        PagoResponseDto pagoResponseDto = new PagoResponseDto();

        pagoResponseDto.setIdPago( pagoPojo.getIdPago() );
        pagoResponseDto.setPagoFecha( pagoPojo.getPagoFecha() );
        pagoResponseDto.setPagoMonto( pagoPojo.getPagoMonto() );
        pagoResponseDto.setPagoEstado( pagoPojo.isPagoEstado() );
        pagoResponseDto.setIdPedido( pagoPojo.getIdPedido() );
        pagoResponseDto.setMetodoPago( pagoPojo.getMetodoPago() );

        return pagoResponseDto;
    }
}
