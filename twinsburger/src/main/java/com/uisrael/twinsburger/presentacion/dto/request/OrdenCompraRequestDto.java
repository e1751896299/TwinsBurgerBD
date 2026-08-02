package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class OrdenCompraRequestDto {

	private int idOrdenCompra;
	@NotNull
	private LocalDateTime ocFecha;
	@NotBlank
	private String ocProveedor;

}
