package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.DetalleOrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.DetalleOrdenCompraResponseDto;

public interface IDetalleOrdenCompraService {

	List<DetalleOrdenCompraResponseDto> listarDetalleOrdenCompra();

	DetalleOrdenCompraResponseDto buscarPorId(int id);

	void crear(DetalleOrdenCompraRequestDto detalle);

	void eliminar(int id);

}
