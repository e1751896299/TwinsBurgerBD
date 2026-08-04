package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Producto;
import com.uisrael.twinsburger.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ProductoResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IProductoDtoMapperImpl implements IProductoDtoMapper {

    @Override
    public Producto toDomain(ProductoRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setProdPrecio( dto.getProdPrecio() );
        producto.setProdImagen( dto.getProdImagen() );
        producto.setIdProducto( dto.getIdProducto() );
        producto.setProdNombre( dto.getProdNombre() );
        producto.setProdDescripcion( dto.getProdDescripcion() );
        producto.setProdStock( dto.getProdStock() );
        producto.setProdCategoria( dto.getProdCategoria() );

        return producto;
    }

    @Override
    public ProductoResponseDto toResponseDto(Producto productoPojo) {
        if ( productoPojo == null ) {
            return null;
        }

        ProductoResponseDto productoResponseDto = new ProductoResponseDto();

        productoResponseDto.setProdPrecio( productoPojo.getProdPrecio() );
        productoResponseDto.setProdImagen( productoPojo.getProdImagen() );
        productoResponseDto.setIdProducto( productoPojo.getIdProducto() );
        productoResponseDto.setProdNombre( productoPojo.getProdNombre() );
        productoResponseDto.setProdDescripcion( productoPojo.getProdDescripcion() );
        productoResponseDto.setProdStock( productoPojo.getProdStock() );
        productoResponseDto.setProdCategoria( productoPojo.getProdCategoria() );
        productoResponseDto.setProFechaCreacion( productoPojo.getProFechaCreacion() );

        return productoResponseDto;
    }
}
