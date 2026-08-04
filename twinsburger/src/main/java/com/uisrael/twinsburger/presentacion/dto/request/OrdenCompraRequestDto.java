package com.uisrael.twinsburger.presentacion.dto.request;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class OrdenCompraRequestDto {
    private int idOrdenCompra;
    @NotNull private LocalDateTime ocFecha;
    @NotBlank private String ocProveedor;
    @Valid @NotEmpty private List<OrdenCompraProductoRequestDto> productos = new ArrayList<>();

    public int getIdOrdenCompra() { return idOrdenCompra; }
    public void setIdOrdenCompra(int idOrdenCompra) { this.idOrdenCompra = idOrdenCompra; }
    public LocalDateTime getOcFecha() { return ocFecha; }
    public void setOcFecha(LocalDateTime ocFecha) { this.ocFecha = ocFecha; }
    public String getOcProveedor() { return ocProveedor; }
    public void setOcProveedor(String ocProveedor) { this.ocProveedor = ocProveedor; }
    public List<OrdenCompraProductoRequestDto> getProductos() { return productos; }
    public void setProductos(List<OrdenCompraProductoRequestDto> productos) { this.productos = productos; }
}
