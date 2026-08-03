package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

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
@Table(name = "ComboProducto")
public class ComboProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComboProducto;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "id_combo", nullable = false)
    private ComboEntity fkCombo;

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = false)
    private ProductoEntity fkProducto;
}
