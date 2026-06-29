package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Administrador")
public class AdministradorEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAdmin;
	private String adminNombre;
	private String adminApellido;
	private String adminCorreo;
	private String adminContrasena;
	

}
