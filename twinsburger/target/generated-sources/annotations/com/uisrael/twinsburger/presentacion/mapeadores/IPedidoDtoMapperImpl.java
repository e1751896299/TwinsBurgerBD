package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.presentacion.dto.request.PedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PedidoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPedidoDtoMapperImpl implements IPedidoDtoMapper {

    @Override
    public Pedido toDomain(PedidoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setPedidoEntrega( dto.isPedidoEntrega() );
        pedido.setIdPedido( dto.getIdPedido() );
        pedido.setPedidoFechaPedido( dto.getPedidoFechaPedido() );
        pedido.setPedidoHoraRetiro( dto.getPedidoHoraRetiro() );
        pedido.setPedidoTotal( dto.getPedidoTotal() );
        pedido.setPedidoDescripcion( dto.getPedidoDescripcion() );

        return pedido;
    }

    @Override
    public PedidoResponseDto toResponseDto(Pedido pedidoPojo) {
        if ( pedidoPojo == null ) {
            return null;
        }

        PedidoResponseDto pedidoResponseDto = new PedidoResponseDto();

        pedidoResponseDto.setPedidoEstadoProceso( pedidoPojo.getPedidoEstadoProceso() );
        pedidoResponseDto.setPedidoEntrega( pedidoPojo.isPedidoEntrega() );
        pedidoResponseDto.setIdPedido( pedidoPojo.getIdPedido() );
        pedidoResponseDto.setPedidoFechaPedido( pedidoPojo.getPedidoFechaPedido() );
        pedidoResponseDto.setPedidoHoraRetiro( pedidoPojo.getPedidoHoraRetiro() );
        pedidoResponseDto.setPedidoTotal( pedidoPojo.getPedidoTotal() );
        pedidoResponseDto.setPedidoDescripcion( pedidoPojo.getPedidoDescripcion() );

        return pedidoResponseDto;
    }
}
