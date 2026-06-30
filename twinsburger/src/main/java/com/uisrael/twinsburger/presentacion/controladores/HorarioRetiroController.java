package com.uisrael.twinsburger.presentacion.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IHorarioRetiroUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.HorarioRetiroRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.HorarioRetiroresponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IHorarioRetiroDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/horarioRetiro")
public class HorarioRetiroController {
	
	private final IHorarioRetiroUseCase horarioUseCase;
	private final IHorarioRetiroDtoMapper mapper;
	public HorarioRetiroController(IHorarioRetiroUseCase horarioUseCase, IHorarioRetiroDtoMapper mapper) {
		super();
		this.horarioUseCase = horarioUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public HorarioRetiroresponseDto guardar(@Valid @RequestBody HorarioRetiroRequestDto horarioRequestdto) {
		return mapper.toResponseDto(horarioUseCase.guardar(mapper.toDomain(horarioRequestdto)));
	}
	
	@GetMapping
	public List<HorarioRetiroresponseDto> listar(){
		return horarioUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int idHorarioRetiro){
		horarioUseCase.eliminar(idHorarioRetiro);
		return ResponseEntity.noContent().build();
	}

}
