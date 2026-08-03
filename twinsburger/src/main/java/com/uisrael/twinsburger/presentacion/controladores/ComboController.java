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

import com.uisrael.twinsburger.infraestructura.servicios.ComboService;
import com.uisrael.twinsburger.presentacion.dto.request.ComboRequestDto;
import com.uisrael.twinsburger.presentacion.dto.response.ComboResponseDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/combo")
public class ComboController {
    private final ComboService service;
    public ComboController(ComboService service) { this.service = service; }

    @GetMapping public List<ComboResponseDto> listar() { return service.listar(); }
    @GetMapping("/{id}") public ComboResponseDto buscar(@PathVariable int id) { return service.buscar(id); }
    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    public ComboResponseDto guardar(@Valid @RequestBody ComboRequestDto dto) { return service.guardar(dto); }
    @DeleteMapping("/{id}") public ResponseEntity<Void> eliminar(@PathVariable int id) {
        service.eliminar(id); return ResponseEntity.noContent().build();
    }
}
