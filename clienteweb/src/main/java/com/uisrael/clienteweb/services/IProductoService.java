package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.ProductoRequestDto;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;

public interface IProductoService {

	List<ProductoResponseDto> listarProducto();

	ProductoResponseDto buscarPorId(int id);

	void crear(ProductoRequestDto producto);

}
