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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetalleOrdenCompraUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.DetalleOrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.DetalleOrdenCompraResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IDetalleOrdenCompraDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detalleordencompra")
public class DetalleOrdenCompraController {

	private final IDetalleOrdenCompraUseCase detalleUseCase;
	private final IDetalleOrdenCompraDtoMapper mapper;

	public DetalleOrdenCompraController(IDetalleOrdenCompraUseCase detalleUseCase, IDetalleOrdenCompraDtoMapper mapper) {
		this.detalleUseCase = detalleUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetalleOrdenCompraResponseDto crear(@Valid @RequestBody DetalleOrdenCompraRequestDto detalleRequestDto) {
		return mapper.toResponseDto(detalleUseCase.crear(mapper.toDomain(detalleRequestDto)));
	}

	@GetMapping
	public List<DetalleOrdenCompraResponseDto> listar() {
		return detalleUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idDetalle}")
	public DetalleOrdenCompraResponseDto buscarPorId(@PathVariable int idDetalle) {
		return mapper.toResponseDto(detalleUseCase.buscarPorId(idDetalle));
	}

	@DeleteMapping("/{idDetalle}")
	public ResponseEntity<Void> eliminar(@PathVariable int idDetalle) {
		detalleUseCase.eliminar(idDetalle);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/idOrdenCompra/{idOrdenCompra}")
	public List<DetalleOrdenCompraResponseDto> obtenerDetalleOrdenCompra(@PathVariable Integer idOrdenCompra) {
		return detalleUseCase.obtenerDetalleOrdenCompra(idOrdenCompra).stream().map(mapper::toResponseDto).toList();
	}

}
