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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPedidoUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.PedidoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.PedidoResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IPedidoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	private final IPedidoUseCase pedidoUseCase;
	private final IPedidoDtoMapper mapper;
	public PedidoController(IPedidoUseCase pedidoUseCase, IPedidoDtoMapper mapper) {
		super();
		this.pedidoUseCase = pedidoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public PedidoResponseDto guardar(@Valid @RequestBody PedidoRequestDto pedidoRequestdto) {
		return mapper.toResponseDto(pedidoUseCase.guardar(mapper.toDomain(pedidoRequestdto)));
	}
	
	@GetMapping
	public List<PedidoResponseDto> listar(){
		return pedidoUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idPedido){
			pedidoUseCase.eliminar(idPedido);
			return ResponseEntity.noContent().build();
		}

}
