package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "Pago")
public class PagoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	private LocalDateTime pagoFecha;
	private BigDecimal pagoMonto;
	private boolean pagoEstado;

}
