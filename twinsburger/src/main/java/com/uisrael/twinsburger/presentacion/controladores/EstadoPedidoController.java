package com.uisrael.twinsburger.presentacion.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uisrael.twinsburger.infraestructura.servicios.PedidoEstadoService;
import com.uisrael.twinsburger.presentacion.dto.request.CambioEstadoPedidoRequestDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pedido")
public class EstadoPedidoController {
    private final PedidoEstadoService service;
    public EstadoPedidoController(PedidoEstadoService service) { this.service = service; }

    @PatchMapping("/{idPedido}/estado")
    public ResponseEntity<Void> cambiar(@PathVariable int idPedido,
            @Valid @RequestBody CambioEstadoPedidoRequestDto request) {
        service.cambiarEstado(idPedido, request.getEstado());
        return ResponseEntity.noContent().build();
    }
}
