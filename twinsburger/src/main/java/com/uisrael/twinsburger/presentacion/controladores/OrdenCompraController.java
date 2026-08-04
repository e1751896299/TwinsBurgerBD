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

import com.uisrael.twinsburger.infraestructura.servicios.OrdenCompraService;
import com.uisrael.twinsburger.presentacion.dto.request.OrdenCompraRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.OrdenCompraResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraController {
    private final OrdenCompraService service;
    public OrdenCompraController(OrdenCompraService service) { this.service = service; }

    @GetMapping public List<OrdenCompraResponseDto> listar() { return service.listar(); }
    @GetMapping("/{id}") public OrdenCompraResponseDto buscar(@PathVariable int id) { return service.buscar(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public OrdenCompraResponseDto guardar(@Valid @RequestBody OrdenCompraRequestDto dto) { return service.guardar(dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminar(id); return ResponseEntity.noContent().build();
    }
}
