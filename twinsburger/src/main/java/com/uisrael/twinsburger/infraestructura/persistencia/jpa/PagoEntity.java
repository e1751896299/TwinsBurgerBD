package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Pago")
public class PagoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPago;
	private LocalDateTime pagoFecha;
	private BigDecimal pagoMonto;
	private boolean pagoEstado;
	
	@OneToOne
	@JoinColumn(name = "id_pedido")
	private PedidoEntity fkPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_metodo")
	private MetodoPagoEntity fkMetodoPago;

}
