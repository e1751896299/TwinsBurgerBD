package com.uisrael.twinsburger.infraestructura.persistencia.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.infraestructura.persistencia.jpa.HorarioRetiroEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IHorarioRetiroJpaMapperImpl implements IHorarioRetiroJpaMapper {

    @Override
    public HorarioRetiro toDomain(HorarioRetiroEntity horarioRetiroEntity) {
        if ( horarioRetiroEntity == null ) {
            return null;
        }

        HorarioRetiro horarioRetiro = new HorarioRetiro();

        horarioRetiro.setIdHorarioRetiro( horarioRetiroEntity.getIdHorarioRetiro() );
        horarioRetiro.setHrInicio( horarioRetiroEntity.getHrInicio() );
        horarioRetiro.setHrFin( horarioRetiroEntity.getHrFin() );
        horarioRetiro.setHrEstado( horarioRetiroEntity.isHrEstado() );

        return horarioRetiro;
    }

    @Override
    public HorarioRetiroEntity toEntity(HorarioRetiro horarioRetiroPojo) {
        if ( horarioRetiroPojo == null ) {
            return null;
        }

        HorarioRetiroEntity horarioRetiroEntity = new HorarioRetiroEntity();

        horarioRetiroEntity.setHrEstado( horarioRetiroPojo.isHrEstado() );
        horarioRetiroEntity.setHrFin( horarioRetiroPojo.getHrFin() );
        horarioRetiroEntity.setHrInicio( horarioRetiroPojo.getHrInicio() );
        horarioRetiroEntity.setIdHorarioRetiro( horarioRetiroPojo.getIdHorarioRetiro() );

        return horarioRetiroEntity;
    }
}
