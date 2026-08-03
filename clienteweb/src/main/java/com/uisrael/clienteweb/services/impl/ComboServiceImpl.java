package com.uisrael.clienteweb.services.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.uisrael.clienteweb.model.dto.request.ComboRequestDto;
import com.uisrael.clienteweb.model.dto.response.ComboResponseDto;
import com.uisrael.clienteweb.services.IComboService;

@Service
public class ComboServiceImpl implements IComboService {
    private final WebClient webClient;
    public ComboServiceImpl(WebClient webClient) { this.webClient = webClient; }
    public List<ComboResponseDto> listar() { return webClient.get().uri("/combo").retrieve().bodyToFlux(ComboResponseDto.class).collectList().block(); }
    public ComboResponseDto buscar(int id) { return webClient.get().uri("/combo/{id}", id).retrieve().bodyToMono(ComboResponseDto.class).block(); }
    public void guardar(ComboRequestDto combo) { webClient.post().uri("/combo").bodyValue(combo).retrieve().toBodilessEntity().block(); }
    public void eliminar(int id) { webClient.delete().uri("/combo/{id}", id).retrieve().toBodilessEntity().block(); }
}
