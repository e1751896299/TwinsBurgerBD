package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OrdenCompraProducto")
public class OrdenCompraProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idOrdenCompraProducto;
    private int cantidad;
    @Column(precision = 10, scale = 2)
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_orden_compra", nullable = false)
    private OrdenCompraEntity fkOrdenCompra;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity fkProducto;
}
