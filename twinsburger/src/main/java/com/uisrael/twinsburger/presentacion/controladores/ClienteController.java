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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.ClienteRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ClienteResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IClienteDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	private final IClienteUseCase clienteUseCase;
	private final IClienteDtoMapper mapper;
	public ClienteController(IClienteUseCase clienteUseCase, IClienteDtoMapper mapper) {
		super();
		this.clienteUseCase = clienteUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteResponseDto guardar(@Valid @RequestBody ClienteRequestDto clienteRequestdto) {
		return mapper.toResponseDto(clienteUseCase.guardar(mapper.toDomain(clienteRequestdto)));
	}
	
	@GetMapping
	public List<ClienteResponseDto> listar(){
		return clienteUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idCliente){
			clienteUseCase.eliminar(idCliente);
			return ResponseEntity.noContent().build();
		}

}
