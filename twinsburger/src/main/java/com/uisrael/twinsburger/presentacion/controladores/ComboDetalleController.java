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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboDetalleUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.ComboDetalleRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboDetalleResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IComboDetalleDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/combodetalle")
public class ComboDetalleController {

	private final IComboDetalleUseCase detalleUseCase;
	private final IComboDetalleDtoMapper mapper;

	public ComboDetalleController(IComboDetalleUseCase detalleUseCase, IComboDetalleDtoMapper mapper) {
		this.detalleUseCase = detalleUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComboDetalleResponseDto crear(@Valid @RequestBody ComboDetalleRequestDto detalleRequestDto) {
		return mapper.toResponseDto(detalleUseCase.crear(mapper.toDomain(detalleRequestDto)));
	}

	@GetMapping
	public List<ComboDetalleResponseDto> listar() {
		return detalleUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idDetalle}")
	public ComboDetalleResponseDto buscarPorId(@PathVariable int idDetalle) {
		return mapper.toResponseDto(detalleUseCase.buscarPorId(idDetalle));
	}

	@DeleteMapping("/{idDetalle}")
	public ResponseEntity<Void> eliminar(@PathVariable int idDetalle) {
		detalleUseCase.eliminar(idDetalle);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/idCombo/{idCombo}")
	public List<ComboDetalleResponseDto> obtenerComboDetalle(@PathVariable Integer idCombo) {
		return detalleUseCase.obtenerComboDetalle(idCombo).stream().map(mapper::toResponseDto).toList();
	}

}
