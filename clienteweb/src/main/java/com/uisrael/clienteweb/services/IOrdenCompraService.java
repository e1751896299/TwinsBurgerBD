package com.uisrael.clienteweb.services;

import java.util.List;
import com.uisrael.clienteweb.model.dto.request.OrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.OrdenCompraResponseDto;

public interface IOrdenCompraService {
    List<OrdenCompraResponseDto> listar();
    OrdenCompraResponseDto buscar(int id);
    void guardar(OrdenCompraRequestDto ordenCompra);
    void eliminar(int id);
}
