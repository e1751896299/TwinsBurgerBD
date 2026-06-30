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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IMetodoPagoUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.MetodoPagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.MetodoPagoResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IMetodoPagoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/metodoPago")
public class MetodoPagoController {
	
	private final IMetodoPagoUseCase metodoUseCase;
	private final IMetodoPagoDtoMapper mapper;
	public MetodoPagoController(IMetodoPagoUseCase metodoUseCase, IMetodoPagoDtoMapper mapper) {
		super();
		this.metodoUseCase = metodoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MetodoPagoResponseDto guardar(@Valid @RequestBody MetodoPagoRequestDto metodoRequestdto) {
		return mapper.toResponseDto(metodoUseCase.guardar(mapper.toDomain(metodoRequestdto)));
	}
	
	@GetMapping
	public List<MetodoPagoResponseDto> listar(){
		return metodoUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idMetodoPago){
			metodoUseCase.eliminar(idMetodoPago);
			return ResponseEntity.noContent().build();
		}

}
