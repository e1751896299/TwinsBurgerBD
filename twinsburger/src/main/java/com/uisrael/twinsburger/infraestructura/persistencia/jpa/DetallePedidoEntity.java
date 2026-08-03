package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "DetallePedido")
public class DetallePedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetallePedido;
	private int detalleCantidad;
	private BigDecimal detalleSubtotal;
	private BigDecimal detallePrecio;
	private boolean detalleEstado = true;

	
	@ManyToOne
	@JoinColumn(name = "id_pedido")
	private PedidoEntity fkPedido;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoEntity fkProducto;

	@ManyToOne
	@JoinColumn(name = "id_combo")
	private ComboEntity fkCombo;

}
