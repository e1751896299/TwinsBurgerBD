package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.Categoria;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.CategoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class ICategoriaJpaMapperImpl implements ICategoriaJpaMapper {

    @Override
    public Categoria toDomain(CategoriaEntity categoriaEntity) {
        if ( categoriaEntity == null ) {
            return null;
        }

        Categoria categoria = new Categoria();

        categoria.setIdCategoria( categoriaEntity.getIdCategoria() );
        categoria.setCategoriaNombre( categoriaEntity.getCategoriaNombre() );
        categoria.setCategoriaDescripcion( categoriaEntity.getCategoriaDescripcion() );
        categoria.setCategoriaEstado( categoriaEntity.isCategoriaEstado() );

        return categoria;
    }

    @Override
    public CategoriaEntity toEntity(Categoria categoriaPojo) {
        if ( categoriaPojo == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setCategoriaDescripcion( categoriaPojo.getCategoriaDescripcion() );
        categoriaEntity.setCategoriaEstado( categoriaPojo.isCategoriaEstado() );
        categoriaEntity.setCategoriaNombre( categoriaPojo.getCategoriaNombre() );
        categoriaEntity.setIdCategoria( categoriaPojo.getIdCategoria() );

        return categoriaEntity;
    }
}
