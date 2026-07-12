package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Cliente")
public class ClienteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCliente;
	private String cliNombre;
	private String cliApellido;
	private String cliCorreo;
	private String cliTelefono;
	private boolean cliEstado;
	
	@OneToMany(mappedBy = "fkCliente")
	private List<PedidoEntity> pedidos = new ArrayList<>();
	

}
