package com.uisrael.twinsburger.presentacion.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class ComboRequestDto {
    private int idCombo;
    @NotBlank private String comboNombre;
    private String comboDescripcion;
    @NotNull @DecimalMin("0.01") private BigDecimal comboPrecio;
    private String comboImagen;
    @Valid @NotEmpty private List<ComboProductoRequestDto> productos = new ArrayList<>();

    public int getIdCombo() { return idCombo; }
    public void setIdCombo(int idCombo) { this.idCombo = idCombo; }
    public String getComboNombre() { return comboNombre; }
    public void setComboNombre(String comboNombre) { this.comboNombre = comboNombre; }
    public String getComboDescripcion() { return comboDescripcion; }
    public void setComboDescripcion(String comboDescripcion) { this.comboDescripcion = comboDescripcion; }
    public BigDecimal getComboPrecio() { return comboPrecio; }
    public void setComboPrecio(BigDecimal comboPrecio) { this.comboPrecio = comboPrecio; }
    public String getComboImagen() { return comboImagen; }
    public void setComboImagen(String comboImagen) { this.comboImagen = comboImagen; }
    public List<ComboProductoRequestDto> getProductos() { return productos; }
    public void setProductos(List<ComboProductoRequestDto> productos) { this.productos = productos; }
}
