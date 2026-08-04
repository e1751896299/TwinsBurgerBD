package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.DetallePedido;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.DetallePedidoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IDetallePedidoJpaMapperImpl implements IDetallePedidoJpaMapper {

    @Override
    public DetallePedido toDomain(DetallePedidoEntity detalleEntity) {
        if ( detalleEntity == null ) {
            return null;
        }

        DetallePedido detallePedido = new DetallePedido();

        detallePedido.setDetalleEstado( detalleEntity.isDetalleEstado() );
        detallePedido.setIdDetallePedido( detalleEntity.getIdDetallePedido() );
        detallePedido.setDetalleCantidad( detalleEntity.getDetalleCantidad() );
        detallePedido.setDetalleSubtotal( detalleEntity.getDetalleSubtotal() );
        detallePedido.setDetallePrecio( detalleEntity.getDetallePrecio() );

        detallePedido.setIdProducto( detalleEntity.getFkProducto() == null ? 0 : detalleEntity.getFkProducto().getIdProducto() );
        detallePedido.setProdNombre( detalleEntity.getFkProducto() != null ? detalleEntity.getFkProducto().getProdNombre() : detalleEntity.getFkCombo().getComboNombre() );

        return detallePedido;
    }

    @Override
    public DetallePedidoEntity toEntity(DetallePedido detallePojo) {
        if ( detallePojo == null ) {
            return null;
        }

        DetallePedidoEntity detallePedidoEntity = new DetallePedidoEntity();

        detallePedidoEntity.setDetalleCantidad( detallePojo.getDetalleCantidad() );
        detallePedidoEntity.setDetalleEstado( detallePojo.isDetalleEstado() );
        detallePedidoEntity.setDetallePrecio( detallePojo.getDetallePrecio() );
        detallePedidoEntity.setDetalleSubtotal( detallePojo.getDetalleSubtotal() );
        detallePedidoEntity.setIdDetallePedido( detallePojo.getIdDetallePedido() );

        return detallePedidoEntity;
    }
}
