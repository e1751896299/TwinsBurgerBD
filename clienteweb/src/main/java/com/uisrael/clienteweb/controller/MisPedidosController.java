package com.uisrael.clienteweb.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.clienteweb.configuration.UsuarioAutenticado;
import com.uisrael.clienteweb.model.dto.response.PedidoResponseDto;
import com.uisrael.clienteweb.services.IDetallePedidoService;
import com.uisrael.clienteweb.services.IPedidoService;

@Controller
@RequestMapping("/mis-pedidos")
public class MisPedidosController {

    private final IPedidoService pedidoService;
    private final IDetallePedidoService detallePedidoService;

    public MisPedidosController(IPedidoService pedidoService, IDetallePedidoService detallePedidoService) {
		super();
		this.pedidoService = pedidoService;
		this.detallePedidoService = detallePedidoService;
	}



	@GetMapping
    public String listar(
            @AuthenticationPrincipal
            UsuarioAutenticado usuario,
            Model model) {

        try {

            List<PedidoResponseDto> pedidos =
                    pedidoService.listarPorCliente(
                            usuario.getId()
                    );

            model.addAttribute("pedidos", pedidos);
            model.addAttribute("apiDisponible", true);

        } catch (RuntimeException ex) {

            model.addAttribute(
                    "pedidos",
                    List.of()
            );

            model.addAttribute(
                    "apiDisponible",
                    false
            );
        }

        return "cliente/mis-pedidos";
    }
	
	@GetMapping("/{idPedido}")
	public String verDetalle(
	        @PathVariable int idPedido,
	        @AuthenticationPrincipal
	        UsuarioAutenticado usuario,
	        Model model) {

	    try {

	        // Buscamos solamente entre los pedidos
	        // pertenecientes al cliente autenticado.
	        PedidoResponseDto pedido =
	                pedidoService
	                    .listarPorCliente(usuario.getId())
	                    .stream()
	                    .filter(p ->
	                        p.getIdPedido() == idPedido
	                    )
	                    .findFirst()
	                    .orElseThrow(() ->
	                        new RuntimeException(
	                            "Pedido no encontrado"
	                        )
	                    );

	        model.addAttribute("pedido", pedido);

	        model.addAttribute(
	            "detalles",
	            detallePedidoService.listarPorPedido(
	                idPedido
	            )
	        );

	        model.addAttribute(
	            "apiDisponible",
	            true
	        );

	        return "cliente/detalle-pedido";

	    } catch (RuntimeException ex) {

	        return "redirect:/mis-pedidos"
	                + "?pedidoNoEncontrado";
	    }
	}
}