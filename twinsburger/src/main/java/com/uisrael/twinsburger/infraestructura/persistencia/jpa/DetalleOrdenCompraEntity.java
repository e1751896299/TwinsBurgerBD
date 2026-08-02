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
@Table(name = "DetalleOrdenCompra")
public class DetalleOrdenCompraEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetalleOrdenCompra;
	private int docCantidad;
	private BigDecimal docPrecioUnitario;
	private boolean docEstado = true;

	@ManyToOne
	@JoinColumn(name = "id_orden_compra")
	private OrdenCompraEntity fkOrdenCompra;

	@ManyToOne
	@JoinColumn(name = "id_producto")
	private ProductoEntity fkProducto;

}
