package com.uisrael.clienteweb.services;

import java.util.List;

import com.uisrael.clienteweb.model.dto.response.DetallePedidoResponseDto;

public interface IDetallePedidoService {
	
	List<DetallePedidoResponseDto> listarDetallePedido();
	
	List<DetallePedidoResponseDto> listarPorPedido(int idPedido);

}
