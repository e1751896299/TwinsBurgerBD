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

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.twinsburger.presentacion.dto.request.ProductoRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ProductoResponseDto;
import com.uisrael.twinsburger.presentacion.mapeadores.IProductoDtoMapper;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	private final IProductoUseCase productoUseCase;
	private final IProductoDtoMapper mapper;
	public ProductoController(IProductoUseCase productoUseCase, IProductoDtoMapper mapper) {
		super();
		this.productoUseCase = productoUseCase;
		this.mapper = mapper;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProductoResponseDto guardar(@Valid @RequestBody ProductoRequestDto productoRequestdto) {
		return mapper.toResponseDto(productoUseCase.guardar(mapper.toDomain(productoRequestdto)));
	}
	
	@GetMapping
	public List<ProductoResponseDto> listar(){
		return productoUseCase.listarTodo()
				.stream().map(mapper::toResponseDto).toList();
	}
	
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> eliminar(@PathVariable int idProducto){
			productoUseCase.eliminar(idProducto);
			return ResponseEntity.noContent().build();
		}

}
