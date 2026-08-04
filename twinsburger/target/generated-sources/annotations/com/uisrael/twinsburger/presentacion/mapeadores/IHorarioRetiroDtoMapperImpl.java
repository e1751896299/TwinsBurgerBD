package com.uisrael.twinsburger.presentacion.mapeadores;

import com.uisrael.twinsburger.dominio.entidades.HorarioRetiro;
import com.uisrael.twinsburger.presentacion.dto.request.HorarioRetiroRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.HorarioRetiroResponseDto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-08-04T14:01:44-0500",
    comments = "version: 1.6.3, compiler: Eclipse JDT (IDE) 3.46.0.v20260528-0407, environment: Java 25.0.3 (Eclipse Adoptium)"
)
@Component
public class IHorarioRetiroDtoMapperImpl implements IHorarioRetiroDtoMapper {

    @Override
    public HorarioRetiro toDomain(HorarioRetiroRequestDto dto) {
        if ( dto == null ) {
            return null;
        }

        HorarioRetiro horarioRetiro = new HorarioRetiro();

        horarioRetiro.setIdHorarioRetiro( dto.getIdHorarioRetiro() );
        horarioRetiro.setHrInicio( dto.getHrInicio() );
        horarioRetiro.setHrFin( dto.getHrFin() );

        return horarioRetiro;
    }

    @Override
    public HorarioRetiroResponseDto toResponseDto(HorarioRetiro horarioRetiroPojo) {
        if ( horarioRetiroPojo == null ) {
            return null;
        }

        HorarioRetiroResponseDto horarioRetiroResponseDto = new HorarioRetiroResponseDto();

        horarioRetiroResponseDto.setIdHorarioRetiro( horarioRetiroPojo.getIdHorarioRetiro() );
        horarioRetiroResponseDto.setHrInicio( horarioRetiroPojo.getHrInicio() );
        horarioRetiroResponseDto.setHrFin( horarioRetiroPojo.getHrFin() );
        horarioRetiroResponseDto.setHrEstado( horarioRetiroPojo.isHrEstado() );

        return horarioRetiroResponseDto;
    }
}
