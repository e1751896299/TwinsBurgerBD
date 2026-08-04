package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.ProductoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IProductoJpaMapperImpl implements IProductoJpaMapper {

    @Override
    public Producto toDomain(ProductoEntity productoEntity) {
        if ( productoEntity == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setProdPrecio( productoEntity.getProdPrecio() );
        producto.setProdImagen( productoEntity.getProdImagen() );
        producto.setIdProducto( productoEntity.getIdProducto() );
        producto.setProdNombre( productoEntity.getProdNombre() );
        producto.setProdDescripcion( productoEntity.getProdDescripcion() );
        producto.setProdStock( productoEntity.getProdStock() );
        producto.setProdCategoria( productoEntity.getProdCategoria() );
        producto.setProFechaCreacion( productoEntity.getProFechaCreacion() );
        producto.setProdEstado( productoEntity.isProdEstado() );

        return producto;
    }

    @Override
    public ProductoEntity toEntity(Producto productoPojo) {
        if ( productoPojo == null ) {
            return null;
        }

        ProductoEntity productoEntity = new ProductoEntity();

        productoEntity.setProdPrecio( productoPojo.getProdPrecio() );
        productoEntity.setProdImagen( productoPojo.getProdImagen() );
        productoEntity.setIdProducto( productoPojo.getIdProducto() );
        productoEntity.setProFechaCreacion( productoPojo.getProFechaCreacion() );
        productoEntity.setProdCategoria( productoPojo.getProdCategoria() );
        productoEntity.setProdDescripcion( productoPojo.getProdDescripcion() );
        productoEntity.setProdEstado( productoPojo.isProdEstado() );
        productoEntity.setProdNombre( productoPojo.getProdNombre() );
        productoEntity.setProdStock( productoPojo.getProdStock() );

        return productoEntity;
    }
}
