package com.uisrael.clienteweb.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.clienteweb.model.dto.request.OrdenCompraRequestDto;
import com.uisrael.clienteweb.model.dto.response.OrdenCompraResponseDto;
import com.uisrael.clienteweb.services.IOrdenCompraService;

@Service
public class OrdenCompraServiceImpl implements IOrdenCompraService {
    private final WebClient webClient;
    public OrdenCompraServiceImpl(WebClient webClient) { this.webClient = webClient; }
    public List<OrdenCompraResponseDto> listar() { return webClient.get().uri("/ordencompra").retrieve().bodyToFlux(OrdenCompraResponseDto.class).collectList().block(); }
    public OrdenCompraResponseDto buscar(int id) { return webClient.get().uri("/ordencompra/{id}", id).retrieve().bodyToMono(OrdenCompraResponseDto.class).block(); }
    public void guardar(OrdenCompraRequestDto ordenCompra) { webClient.post().uri("/ordencompra").bodyValue(ordenCompra).retrieve().toBodilessEntity().block(); }
    public void eliminar(int id) { webClient.delete().uri("/ordencompra/{id}", id).retrieve().toBodilessEntity().block(); }
}
