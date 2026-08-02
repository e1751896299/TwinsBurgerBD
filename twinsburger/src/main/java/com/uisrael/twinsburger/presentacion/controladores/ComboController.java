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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.ComboRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IComboDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/combo")
public class ComboController {

	private final IComboUseCase comboUseCase;
	private final IComboDtoMapper mapper;

	public ComboController(IComboUseCase comboUseCase, IComboDtoMapper mapper) {
		this.comboUseCase = comboUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComboResponseDto guardar(@Valid @RequestBody ComboRequestDto comboRequestDto) {
		return mapper.toResponseDto(comboUseCase.guardar(mapper.toDomain(comboRequestDto)));
	}

	@GetMapping
	public List<ComboResponseDto> listar() {
		return comboUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idCombo}")
	public ComboResponseDto buscarPorId(@PathVariable int idCombo) {
		return mapper.toResponseDto(comboUseCase.buscarPorId(idCombo));
	}

	@DeleteMapping("/{idCombo}")
	public ResponseEntity<Void> eliminar(@PathVariable int idCombo) {
		comboUseCase.eliminar(idCombo);
		return ResponseEntity.noContent().build();
	}

}
