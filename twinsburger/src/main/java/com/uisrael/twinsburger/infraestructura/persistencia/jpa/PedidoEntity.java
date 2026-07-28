package com.uisrael.twinsburger.infraestructura.persistencia.jpa;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Pedido")
public class PedidoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPedido;
	private Date pedidoFechaPedido;
	private LocalTime pedidoHoraRetiro;
	private boolean pedidoEstado = true;
	private BigDecimal pedidoTotal;
	private String pedidoDescripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private ClienteEntity fkCliente;
	
	@ManyToOne
	@JoinColumn(name = "id_administrador")
	private AdministradorEntity fkAdministrador;
	
	@ManyToOne
	@JoinColumn(name = "id_Horario")
	private HorarioRetiroEntity fkHorarioRetiro;
	
	@OneToOne(mappedBy = "fkPedido")
	private PagoEntity pagos;
	
	@OneToMany(mappedBy = "fkPedido")
	private List<DetallePedidoEntity> detallesPedidos = new ArrayList<>();

}
