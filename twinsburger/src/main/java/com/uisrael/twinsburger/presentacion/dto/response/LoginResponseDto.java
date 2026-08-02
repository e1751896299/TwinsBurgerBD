package com.uisrael.twinsburger.presentacion.dto.response;

public record LoginResponseDto(
		int id,
		String nombre,
		String correo,
		String rol) {
}
