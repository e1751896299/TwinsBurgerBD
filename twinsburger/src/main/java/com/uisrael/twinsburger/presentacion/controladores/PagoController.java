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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPagoUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.PagoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PagoResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IPagoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pago")
public class PagoController {
	
	private final IPagoUseCase pagoUseCase;
	private final IPagoDtoMapper mapper;
	public PagoController(IPagoUseCase pagoUseCase, IPagoDtoMapper mapper) {
		super();
		this.pagoUseCase = pagoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PagoResponseDto guardar(@Valid @RequestBody PagoRequestDto pagoRequestdto) {
		return mapper.toResponsedDto(pagoUseCase.guardar(mapper.toDomain(pagoRequestdto)));
	}
	
	@GetMapping
	public List<PagoResponseDto> listar(){
		return pagoUseCase.listarTodos()
				.stream().map(mapper::toResponsedDto).toList();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable int idPago){
		pagoUseCase.eliminar(idPago);
		return ResponseEntity.noContent().build();
	}

}
