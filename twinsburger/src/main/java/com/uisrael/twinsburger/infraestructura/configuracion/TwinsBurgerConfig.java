package com.uisrael.twinsburger.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboDetalleUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IComboUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetalleOrdenCompraUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IDetallePedidoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IHorarioRetiroUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IMetodoPagoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IOrdenCompraUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPagoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPedidoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.AdministradorUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.CategoriaUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ClienteUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ComboDetalleUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ComboUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.DetalleOrdenCompraUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.DetallePedidoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.HorarioRetiroUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.MetodoPagoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.OrdenCompraUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.PagoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.PedidoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ProductoUseCaseImpl;
import com.uisrael.twinsburger.dominio.repositorios.IAdministradorRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IClienteRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IComboDetalleRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IComboRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IDetalleOrdenCompraRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IDetallePedidoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IHorarioRetiroRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IMetodoPagoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IOrdenCompraRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IPagoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IProductoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.AdministradorRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.CategoriaRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ComboDetalleRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ComboRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.DetalleOrdenCompraRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.DetallePedidoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.HorarioRetiroRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.MetodoPagoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.OrdenCompraRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.PagoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.PedidoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IAdministradorJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IComboDetalleJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IComboJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IDetalleOrdenCompraJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IDetallePedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IHorarioRetiroJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IMetodoPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IOrdenCompraJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IAdministradorJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboDetalleJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IComboJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetalleOrdenCompraJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IDetallePedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IHorarioRetiroJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IMetodoPagoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IOrdenCompraJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPagoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IPedidoJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IProductoJpaRepositorio;

@Configuration
public class TwinsBurgerConfig {
	
	@Bean
	IAdministradorRepositorio administradorRepositorio(IAdministradorJpaRepositorio jpaRepositorio, IAdministradorJpaMapper jpaMapper) {
		return new AdministradorRepositorioImpl(jpaRepositorio, jpaMapper);
	}
	
	@Bean
	ICategoriaRepositorio categoriaRepositorio(ICategoriaJpaRepositorio jpaRepositorio, ICategoriaJpaMapper jpaMapper) {
		return new CategoriaRepositorioImpl(jpaRepositorio, jpaMapper);
	}
	
	@Bean
	IClienteRepositorio clienteRepositorio(IClienteJpaRepositorio jpaRepositorio, IClienteJpaMapper jpaMapper) {
		return new ClienteRepositorioImpl(jpaRepositorio, jpaMapper);
	}
	
	@Bean
	IHorarioRetiroRepositorio horarioRetiroRepositorio(IHorarioRetiroJpaRepositorio jpaRepositorio, IHorarioRetiroJpaMapper jpaMapper) {
	    return new HorarioRetiroRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IMetodoPagoRepositorio metodoPagoRepositorio(IMetodoPagoJpaRepositorio jpaRepositorio, IMetodoPagoJpaMapper jpaMapper) {
	    return new MetodoPagoRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IPagoRepositorio pagoRepositorio(IPagoJpaRepositorio jpaRepositorio, IPagoJpaMapper jpaMapper,
			IPedidoJpaRepositorio pedidoJpaRepositorio, IMetodoPagoJpaRepositorio metodoPagoJpaRepositorio) {
	    return new PagoRepositorioImpl(jpaRepositorio, jpaMapper, pedidoJpaRepositorio, metodoPagoJpaRepositorio);
	}

	@Bean
	IPedidoRepositorio pedidoRepositorio(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper jpaMapper,
			IClienteJpaRepositorio clienteJpaRepositorio, IAdministradorJpaRepositorio administradorJpaRepositorio,
			IHorarioRetiroJpaRepositorio horarioRetiroJpaRepositorio) {
	    return new PedidoRepositorioImpl(jpaRepositorio, jpaMapper, clienteJpaRepositorio, administradorJpaRepositorio, horarioRetiroJpaRepositorio);
	}

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper jpaMapper, ICategoriaJpaRepositorio categoriaJpaRepositorio) {
	    return new ProductoRepositorioImpl(jpaRepositorio, jpaMapper, categoriaJpaRepositorio);
	}
	
	@Bean
	IAdministradorUseCase administradorUseCase(IAdministradorRepositorio repositorio) {
	    return new AdministradorUseCaseImpl(repositorio);
	}

	@Bean
	ICategoriaUseCase categoriaUseCase(ICategoriaRepositorio repositorio) {
	    return new CategoriaUseCaseImpl(repositorio);
	}

	@Bean
	IClienteUseCase clienteUseCase(IClienteRepositorio repositorio) {
	    return new ClienteUseCaseImpl(repositorio);
	}

	@Bean
	IHorarioRetiroUseCase horarioRetiroUseCase(IHorarioRetiroRepositorio repositorio) {
	    return new HorarioRetiroUseCaseImpl(repositorio);
	}

	@Bean
	IMetodoPagoUseCase metodoPagoUseCase(IMetodoPagoRepositorio repositorio) {
	    return new MetodoPagoUseCaseImpl(repositorio);
	}

	@Bean
	IPagoUseCase pagoUseCase(IPagoRepositorio repositorio) {
	    return new PagoUseCaseImpl(repositorio);
	}

	@Bean
	IPedidoUseCase pedidoUseCase(IPedidoRepositorio repositorio) {
	    return new PedidoUseCaseImpl(repositorio);
	}

	@Bean
	IProductoUseCase productoUseCase(IProductoRepositorio repositorio) {
	    return new ProductoUseCaseImpl(repositorio);
	}
	
	@Bean
	IDetallePedidoRepositorio detallePedidoRepositorio(IDetallePedidoJpaRepositorio jpaRepositorio, IDetallePedidoJpaMapper jpaMapper) {
	    return new DetallePedidoRepositorioImpl(jpaRepositorio, jpaMapper);
	}
	
	@Bean
	IDetallePedidoUseCase detallePedidoUseCase(IDetallePedidoRepositorio repositorio) {
	    return new DetallePedidoUseCaseImpl(repositorio);
	}

	@Bean
	IOrdenCompraRepositorio ordenCompraRepositorio(IOrdenCompraJpaRepositorio jpaRepositorio, IOrdenCompraJpaMapper jpaMapper) {
	    return new OrdenCompraRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IOrdenCompraUseCase ordenCompraUseCase(IOrdenCompraRepositorio repositorio) {
	    return new OrdenCompraUseCaseImpl(repositorio);
	}

	@Bean
	IDetalleOrdenCompraRepositorio detalleOrdenCompraRepositorio(IDetalleOrdenCompraJpaRepositorio jpaRepositorio,
			IDetalleOrdenCompraJpaMapper jpaMapper, IOrdenCompraJpaRepositorio ordenCompraJpaRepositorio,
			IProductoJpaRepositorio productoJpaRepositorio) {
	    return new DetalleOrdenCompraRepositorioImpl(jpaRepositorio, jpaMapper, ordenCompraJpaRepositorio, productoJpaRepositorio);
	}

	@Bean
	IDetalleOrdenCompraUseCase detalleOrdenCompraUseCase(IDetalleOrdenCompraRepositorio repositorio) {
	    return new DetalleOrdenCompraUseCaseImpl(repositorio);
	}

	@Bean
	IComboRepositorio comboRepositorio(IComboJpaRepositorio jpaRepositorio, IComboJpaMapper jpaMapper) {
	    return new ComboRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IComboUseCase comboUseCase(IComboRepositorio repositorio) {
	    return new ComboUseCaseImpl(repositorio);
	}

	@Bean
	IComboDetalleRepositorio comboDetalleRepositorio(IComboDetalleJpaRepositorio jpaRepositorio,
			IComboDetalleJpaMapper jpaMapper, IComboJpaRepositorio comboJpaRepositorio,
			IProductoJpaRepositorio productoJpaRepositorio) {
	    return new ComboDetalleRepositorioImpl(jpaRepositorio, jpaMapper, comboJpaRepositorio, productoJpaRepositorio);
	}

	@Bean
	IComboDetalleUseCase comboDetalleUseCase(IComboDetalleRepositorio repositorio) {
	    return new ComboDetalleUseCaseImpl(repositorio);
	}

}
