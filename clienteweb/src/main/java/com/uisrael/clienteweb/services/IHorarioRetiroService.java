package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.HorarioRetiroRequestDto;
import com.uisrael.clienteweb.model.dto.response.HorarioRetiroResponseDto;

public interface IHorarioRetiroService {

	List<HorarioRetiroResponseDto> listarHorarioRetiro();

	HorarioRetiroResponseDto buscarPorId(int id);

	void crear(HorarioRetiroRequestDto horarioRetiro);

	void eliminar(int id);
}
