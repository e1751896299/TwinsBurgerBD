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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.CategoriaRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.CategoriaResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.ICategoriaDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	private final ICategoriaUseCase categoriaUseCase;
	private final ICategoriaDtoMapper mapper;
	

	public CategoriaController(ICategoriaUseCase categoriaUseCase, ICategoriaDtoMapper mapper) {
		super();
		this.categoriaUseCase = categoriaUseCase;
		this.mapper = mapper;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CategoriaResponseDto guardar(@Valid @RequestBody CategoriaRequestDto categoriaRequestdto) {
		return mapper.toResponseDto(categoriaUseCase.guardar(mapper.toDomain(categoriaRequestdto)));
	}
	
	@GetMapping
	public List<CategoriaResponseDto> listar(){
		return categoriaUseCase.listarTodos()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idCategoria){
			categoriaUseCase.eliminar(idCategoria);
			return ResponseEntity.noContent().build();
		}

}
