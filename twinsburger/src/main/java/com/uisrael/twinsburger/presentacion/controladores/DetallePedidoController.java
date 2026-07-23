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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetallePedidoUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.DetallePedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.DetallePedidoResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IDetallePedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/detallepedido")
public class DetallePedidoController {
	
	private final IDetallePedidoUseCase detalleUseCase;
	private final IDetallePedidoDtoMapper mapper;
	
	public DetallePedidoController(IDetallePedidoUseCase detalleUseCase, IDetallePedidoDtoMapper mapper) {
		super();
		this.detalleUseCase = detalleUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DetallePedidoResponseDto crea(@Valid @RequestBody DetallePedidoRequestDto detalleRequestDto) {
		return mapper.toResponseDto(detalleUseCase.crear(mapper.toDomain(detalleRequestDto)));
	}
	
	@GetMapping
	public List<DetallePedidoResponseDto> lsitar(){
		return detalleUseCase.listarTodos().stream().map(mapper::toResponseDto).toList();
	}
	
	@DeleteMapping("/{idDetalle}")
	public ResponseEntity<Void> eliminar(@PathVariable int idDetalle){
		detalleUseCase.eliminar(idDetalle);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/idPedido/{idPedido}")
	public List<DetallePedidoResponseDto> obtenerDetallePedido(@PathVariable Integer idPedido){
		return detalleUseCase.obtenerDetallePedido(idPedido).stream().map(mapper::toResponseDto).toList();
	}

}
