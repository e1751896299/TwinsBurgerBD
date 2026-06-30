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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.AdministradorRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.AdministradorResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IAdministradorDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/administrador")
public class AdministradorController {
	
	private final IAdministradorUseCase administradorUseCase;
	private final IAdministradorDtoMapper mapper;

	public AdministradorController(IAdministradorUseCase administradorUseCase, IAdministradorDtoMapper mapper) {
		super();
		this.administradorUseCase = administradorUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public AdministradorResponseDto guardar(@Valid @RequestBody AdministradorRequestDto administradorRequestdto) {
		return mapper.toResponseDto(administradorUseCase.guardar(mapper.toDomain(administradorRequestdto)));
	}
	
	@GetMapping
	public List<AdministradorResponseDto> listar(){
		return administradorUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idAdministrador){
			administradorUseCase.eliminar(idAdministrador);
			return ResponseEntity.noContent().build();
		}
		

}
