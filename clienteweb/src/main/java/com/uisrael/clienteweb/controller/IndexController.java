package com.uisrael.clienteweb.controller;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.uisrael.clienteweb.model.dto.response.ClienteResponseDto;
import com.uisrael.clienteweb.model.dto.response.PagoResponseDto;
import com.uisrael.clienteweb.model.dto.response.PedidoResponseDto;
import com.uisrael.clienteweb.model.dto.response.ProductoResponseDto;
import com.uisrael.clienteweb.services.IClienteService;
import com.uisrael.clienteweb.services.IPagoService;
import com.uisrael.clienteweb.services.IPedidoService;
import com.uisrael.clienteweb.services.IProductoService;

@Controller
public class IndexController {
	
	private static final Logger LOGGER =
			LoggerFactory.getLogger(IndexController.class);

	private static final int STOCK_BAJO = 5;

	private final IClienteService clienteService;
	private final IProductoService productoService;
	private final IPedidoService pedidoService;
	private final IPagoService pagoService;

	public IndexController(
			IClienteService clienteService,
			IProductoService productoService,
			IPedidoService pedidoService,
			IPagoService pagoService) {

		this.clienteService = clienteService;
		this.productoService = productoService;
		this.pedidoService = pedidoService;
		this.pagoService = pagoService;
	}

	@GetMapping("/")
	public String inicio(Model model) {

		
		boolean apiDisponible = true;

		List<ClienteResponseDto> clientes = new ArrayList<>();
		List<ProductoResponseDto> productos = new ArrayList<>();
		List<PedidoResponseDto> pedidos = new ArrayList<>();
		List<PagoResponseDto> pagos = new ArrayList<>();

		

		try {
			List<ClienteResponseDto> resultado =
					clienteService.listarCliente();

			if (resultado != null) {
				clientes = resultado;
			}
		} catch (RuntimeException ex) {
			apiDisponible = false;
			LOGGER.warn(
					"No fue posible cargar clientes para el dashboard: {}",
					ex.getMessage());
		}

		try {
			List<ProductoResponseDto> resultado =
					productoService.listarProducto();

			if (resultado != null) {
				productos = resultado;
			}
		} catch (RuntimeException ex) {
			apiDisponible = false;
			LOGGER.warn(
					"No fue posible cargar productos para el dashboard: {}",
					ex.getMessage());
		}

		try {
			List<PedidoResponseDto> resultado =
					pedidoService.listarPedido();

			if (resultado != null) {
				pedidos = resultado;
			}
		} catch (RuntimeException ex) {
			apiDisponible = false;
			LOGGER.warn(
					"No fue posible cargar pedidos para el dashboard: {}",
					ex.getMessage());
		}

		try {
			List<PagoResponseDto> resultado =
					pagoService.listarPago();

			if (resultado != null) {
				pagos = resultado;
			}
		} catch (RuntimeException ex) {
			apiDisponible = false;
			LOGGER.warn(
					"No fue posible cargar pagos para el dashboard: {}",
					ex.getMessage());
		}

		
		int clientesActivos = 0;

		for (ClienteResponseDto cliente : clientes) {
			if (cliente.isCliActivo()) {
				clientesActivos++;
			}
		}

		
		int pedidosActivos = 0;
		int pedidosHoy = 0;

		for (PedidoResponseDto pedido : pedidos) {

			if (pedido.isPedidoEntrega()) {
				pedidosActivos++;
			}

			if (esFechaActual(pedido.getPedidoFechaPedido())) {
				pedidosHoy++;
			}
		}

		int pedidosPendientes =
				pedidos.size() - pedidosActivos;

		
		int stockTotal = 0;
		int productosStockBajo = 0;

		for (ProductoResponseDto producto : productos) {

			stockTotal += producto.getProdStock();

			if (producto.getProdStock() <= STOCK_BAJO) {
				productosStockBajo++;
			}
		}

		double ventasTotales = 0.0;
		int pagosAprobados = 0;

		for (PagoResponseDto pago : pagos) {

			if (pago.isPagoEstado()) {

				pagosAprobados++;

				if (pago.getPagoMonto() != null) {
					ventasTotales +=
							pago.getPagoMonto().doubleValue();
				}
			}
		}

		double ticketPromedio = 0.0;

		if (pagosAprobados > 0) {
			ticketPromedio =
					ventasTotales / pagosAprobados;

			
			ticketPromedio =
					Math.round(ticketPromedio * 100.0) / 100.0;
		}

		
		List<PedidoResponseDto> pedidosRecientes =
				pedidos.stream()
						.sorted(Comparator.comparing(
								PedidoResponseDto::getPedidoFechaPedido,
								Comparator.nullsFirst(
										Comparator.naturalOrder()))
								.reversed())
						.limit(5)
						.toList();

		List<ProductoResponseDto> productosCriticos =
				productos.stream()
						.filter(producto ->
								producto.getProdStock() <= STOCK_BAJO)
						.sorted(Comparator.comparingInt(
								ProductoResponseDto::getProdStock))
						.limit(5)
						.toList();

		List<String> etiquetasVentas = new ArrayList<>();
		List<Double> ventasPorDia = new ArrayList<>();

		DateTimeFormatter formatoEtiqueta =
				DateTimeFormatter.ofPattern("dd/MM");

		for (int diasAtras = 6; diasAtras >= 0; diasAtras--) {

			LocalDate fecha =
					LocalDate.now().minusDays(diasAtras);

			etiquetasVentas.add(
					fecha.format(formatoEtiqueta));

			double totalDia = 0.0;

			for (PagoResponseDto pago : pagos) {

				if (pago.isPagoEstado()
						&& pago.getPagoFecha() != null
						&& pago.getPagoFecha()
								.toLocalDate()
								.equals(fecha)
						&& pago.getPagoMonto() != null) {

					totalDia +=
							pago.getPagoMonto().doubleValue();
				}
			}

			ventasPorDia.add(totalDia);
		}

		
		model.addAttribute(
				"apiDisponible", apiDisponible);

		model.addAttribute(
				"ventasTotales", ventasTotales);

		model.addAttribute(
				"ticketPromedio", ticketPromedio);

		model.addAttribute(
				"totalPedidos", pedidos.size());

		model.addAttribute(
				"pedidosActivos", pedidosActivos);

		model.addAttribute(
				"pedidosPendientes", pedidosPendientes);

		model.addAttribute(
				"pedidosHoy", pedidosHoy);

		model.addAttribute(
				"totalClientes", clientes.size());

		model.addAttribute(
				"clientesActivos", clientesActivos);

		model.addAttribute(
				"totalProductos", productos.size());

		model.addAttribute(
				"stockTotal", stockTotal);

		model.addAttribute(
				"productosStockBajo", productosStockBajo);

		model.addAttribute(
				"pedidosRecientes", pedidosRecientes);

		model.addAttribute(
				"productosCriticos", productosCriticos);

		model.addAttribute(
				"etiquetasVentas", etiquetasVentas);

		model.addAttribute(
				"ventasPorDia", ventasPorDia);

		return "index";
	}

	private boolean esFechaActual(Date fecha) {

		if (fecha == null) {
			return false;
		}

		LocalDate fechaPedido;

		if (fecha instanceof java.sql.Date fechaSql) {
			fechaPedido = fechaSql.toLocalDate();
		} else {
			fechaPedido = fecha.toInstant()
					.atZone(ZoneId.systemDefault())
					.toLocalDate();
		}

		return LocalDate.now().equals(fechaPedido);
	}

}
