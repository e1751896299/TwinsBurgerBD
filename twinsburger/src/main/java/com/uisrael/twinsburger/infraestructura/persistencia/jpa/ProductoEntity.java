package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Producto")
public class ProductoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProducto;
	private String prodNombre;
	private String prodDescripcion;
	private int prodStock;
	private LocalDateTime proFechaCreacion;
	private boolean prodEstado = true;
	@Column(precision = 10, scale = 2)
	private BigDecimal prodPrecio;

	@Column(length = 500)
	private String prodImagen;
	

	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private CategoriaEntity fkCategoria;
	
	@OneToMany(mappedBy = "fkProducto")
	private List<DetallePedidoEntity> detallesPedidos = new ArrayList<>();
	 
}
