package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.presentacion.dto.request.DetallePedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.DetallePedidoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IDetallePedidoDtoMapperImpl implements IDetallePedidoDtoMapper {

    @Override
    public DetallePedido toDomain(DetallePedidoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        DetallePedido detallePedido = new DetallePedido();

        detallePedido.setIdDetallePedido( dto.getIdDetallePedido() );
        detallePedido.setDetalleCantidad( dto.getDetalleCantidad() );
        detallePedido.setDetalleSubtotal( dto.getDetalleSubtotal() );
        detallePedido.setDetallePrecio( dto.getDetallePrecio() );

        return detallePedido;
    }

    @Override
    public DetallePedidoResponseDto toResponseDto(DetallePedido detallePojo) {
        if ( detallePojo == null ) {
            return null;
        }

        DetallePedidoResponseDto detallePedidoResponseDto = new DetallePedidoResponseDto();

        detallePedidoResponseDto.setIdProducto( detallePojo.getIdProducto() );
        detallePedidoResponseDto.setProdNombre( detallePojo.getProdNombre() );
        detallePedidoResponseDto.setIdDetallePedido( detallePojo.getIdDetallePedido() );
        detallePedidoResponseDto.setDetalleCantidad( detallePojo.getDetalleCantidad() );
        detallePedidoResponseDto.setDetalleSubtotal( detallePojo.getDetalleSubtotal() );
        detallePedidoResponseDto.setDetallePrecio( detallePojo.getDetallePrecio() );

        return detallePedidoResponseDto;
    }
}
