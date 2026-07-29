package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.request.PedidoRequestDto;
import com.uisrael.clienteweb.model.dto.response.PedidoResponseDto;

public interface IPedidoService {

	List<PedidoResponseDto> listarPedido();

	void crear(PedidoRequestDto pedido);

	void eliminar(int id);

}
