package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.HorarioRetiroRequestDto;
import com.uisrael.clienteweb.model.dto.response.HorarioRetiroResponseDto;

public interface IHorarioRetiroService {

	List<HorarioRetiroResponseDto> listarHorarioRetiro();

	void crear(HorarioRetiroRequestDto horarioRetiro);
}
