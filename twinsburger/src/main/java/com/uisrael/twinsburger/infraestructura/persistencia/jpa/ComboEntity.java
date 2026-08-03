package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Combo")
public class ComboEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCombo;
    private String comboNombre;
    private String comboDescripcion;
    @Column(precision = 10, scale = 2)
    private BigDecimal comboPrecio;
    @Column(length = 500)
    private String comboImagen;
    private boolean comboEstado = true;

    @OneToMany(mappedBy = "fkCombo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ComboProductoEntity> productos = new ArrayList<>();
}
