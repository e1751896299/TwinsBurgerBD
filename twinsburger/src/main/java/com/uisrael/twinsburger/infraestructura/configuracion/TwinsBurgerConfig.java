package com.uisrael.twinsburger.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IAdministradorUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.ICategoriaUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IClienteUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IHorarioRetiroUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IMetodoPagoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPagoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IPedidoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.entrada.IProductoUseCase;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.AdministradorUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.CategoriaUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ClienteUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.HorarioRetiroUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.MetodoPagoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.PagoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.PedidoUseCaseImpl;
import com.uisrael.twinsburger.aplicacion.casosuso.impl.ProductoUseCaseImpl;
import com.uisrael.twinsburger.dominio.repositorios.IAdministradorRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.ICategoriaRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IClienteRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IHorarioRetiroRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IMetodoPagoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IPagoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IPedidoRepositorio;
import com.uisrael.twinsburger.dominio.repositorios.IProductoRepositorio;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.AdministradorRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.CategoriaRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ClienteRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.HorarioRetiroRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.MetodoPagoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.PagoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.PedidoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.adaptadores.ProductoRepositorioImpl;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IAdministradorJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.ICategoriaJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IClienteJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IHorarioRetiroJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IMetodoPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPagoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IPedidoJpaMapper;
import com.uisrael.twinsburger.infraestructura.persistencia.mapeadores.IProductoJpaMapper;
import com.uisrael.twinsburger.infraestructura.repositorios.IAdministradorJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.ICategoriaJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IClienteJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IHorarioRetiroJpaRepositorio;
import com.uisrael.twinsburger.infraestructura.repositorios.IMetodoPagoJpaRepositorio;
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
	IPagoRepositorio pagoRepositorio(IPagoJpaRepositorio jpaRepositorio, IPagoJpaMapper jpaMapper) {
	    return new PagoRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IPedidoRepositorio pedidoRepositorio(IPedidoJpaRepositorio jpaRepositorio, IPedidoJpaMapper jpaMapper) {
	    return new PedidoRepositorioImpl(jpaRepositorio, jpaMapper);
	}

	@Bean
	IProductoRepositorio productoRepositorio(IProductoJpaRepositorio jpaRepositorio, IProductoJpaMapper jpaMapper) {
	    return new ProductoRepositorioImpl(jpaRepositorio, jpaMapper);
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

}
