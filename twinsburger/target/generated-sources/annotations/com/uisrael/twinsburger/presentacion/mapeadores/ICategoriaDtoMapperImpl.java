package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CategoriaResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class ICategoriaDtoMapperImpl implements ICategoriaDtoMapper {

    @Override
    public Categoria toDomain(CategoriaRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( dto.getIdCategoria() );
        categoria.setCategoriaNombre( dto.getCategoriaNombre() );
        categoria.setCategoriaDescripcion( dto.getCategoriaDescripcion() );

        return categoria;
    }

    @Override
    public CategoriaResponseDto toResponseDto(Categoria categoriaPojo) {
        if ( categoriaPojo == null ) {
            return null;
        }

        CategoriaResponseDto categoriaResponseDto = new CategoriaResponseDto();

        categoriaResponseDto.setIdCategoria( categoriaPojo.getIdCategoria() );
        categoriaResponseDto.setCategoriaNombre( categoriaPojo.getCategoriaNombre() );
        categoriaResponseDto.setCategoriaDescripcion( categoriaPojo.getCategoriaDescripcion() );
        categoriaResponseDto.setCategoriaEstado( categoriaPojo.isCategoriaEstado() );

        return categoriaResponseDto;
    }
}
