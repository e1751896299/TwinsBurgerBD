package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.MetodoPago;
import com.uisrael.twinsburger.presentacion.dto.request.MetodoPagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.MetodoPagoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IMetodoPagoDtoMapperImpl implements IMetodoPagoDtoMapper {

    @Override
    public MetodoPago toDomain(MetodoPagoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        MetodoPago metodoPago = new MetodoPago();

        metodoPago.setIdMetodoPago( dto.getIdMetodoPago() );
        metodoPago.setMpagoDescripcion( dto.getMpagoDescripcion() );

        return metodoPago;
    }

    @Override
    public MetodoPagoResponseDto toResponseDto(MetodoPago metodoPagoPojo) {
        if ( metodoPagoPojo == null ) {
            return null;
        }

        MetodoPagoResponseDto metodoPagoResponseDto = new MetodoPagoResponseDto();

        metodoPagoResponseDto.setIdMetodoPago( metodoPagoPojo.getIdMetodoPago() );
        metodoPagoResponseDto.setMpagoDescripcion( metodoPagoPojo.getMpagoDescripcion() );

        return metodoPagoResponseDto;
    }
}
