package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Pedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.PedidoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IPedidoJpaMapperImpl implements IPedidoJpaMapper {

    @Override
    public Pedido toDomain(PedidoEntity pedidoEntity) {
        if ( pedidoEntity == null ) {
            return null;
        }

        Pedido pedido = new Pedido();

        pedido.setPedidoEstadoProceso( pedidoEntity.getPedidoEstadoProceso() );
        pedido.setPedidoEntrega( pedidoEntity.isPedidoEntrega() );
        pedido.setIdPedido( pedidoEntity.getIdPedido() );
        pedido.setPedidoFechaPedido( pedidoEntity.getPedidoFechaPedido() );
        pedido.setPedidoHoraRetiro( pedidoEntity.getPedidoHoraRetiro() );
        pedido.setPedidoEstado( pedidoEntity.isPedidoEstado() );
        pedido.setPedidoTotal( pedidoEntity.getPedidoTotal() );
        pedido.setPedidoDescripcion( pedidoEntity.getPedidoDescripcion() );

        return pedido;
    }

    @Override
    public PedidoEntity toEntity(Pedido pedidoPojo) {
        if ( pedidoPojo == null ) {
            return null;
        }

        PedidoEntity pedidoEntity = new PedidoEntity();

        pedidoEntity.setIdPedido( pedidoPojo.getIdPedido() );
        pedidoEntity.setPedidoDescripcion( pedidoPojo.getPedidoDescripcion() );
        pedidoEntity.setPedidoEntrega( pedidoPojo.isPedidoEntrega() );
        pedidoEntity.setPedidoEstado( pedidoPojo.isPedidoEstado() );
        pedidoEntity.setPedidoEstadoProceso( pedidoPojo.getPedidoEstadoProceso() );
        pedidoEntity.setPedidoFechaPedido( pedidoPojo.getPedidoFechaPedido() );
        pedidoEntity.setPedidoHoraRetiro( pedidoPojo.getPedidoHoraRetiro() );
        pedidoEntity.setPedidoTotal( pedidoPojo.getPedidoTotal() );

        return pedidoEntity;
    }
}
