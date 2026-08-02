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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IOrdenCompraUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.OrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.OrdenCompraResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IOrdenCompraDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraController {

	private final IOrdenCompraUseCase ordenCompraUseCase;
	private final IOrdenCompraDtoMapper mapper;

	public OrdenCompraController(IOrdenCompraUseCase ordenCompraUseCase, IOrdenCompraDtoMapper mapper) {
		this.ordenCompraUseCase = ordenCompraUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrdenCompraResponseDto guardar(@Valid @RequestBody OrdenCompraRequestDto ordenCompraRequestDto) {
		return mapper.toResponseDto(ordenCompraUseCase.guardar(mapper.toDomain(ordenCompraRequestDto)));
	}

	@GetMapping
	public List<OrdenCompraResponseDto> listar() {
		return ordenCompraUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}

	@GetMapping("/{idOrdenCompra}")
	public OrdenCompraResponseDto buscarPorId(@PathVariable int idOrdenCompra) {
		return mapper.toResponseDto(ordenCompraUseCase.buscarPorId(idOrdenCompra));
	}

	@DeleteMapping("/{idOrdenCompra}")
	public ResponseEntity<Void> eliminar(@PathVariable int idOrdenCompra) {
		ordenCompraUseCase.eliminar(idOrdenCompra);
		return ResponseEntity.noContent().build();
	}

}
