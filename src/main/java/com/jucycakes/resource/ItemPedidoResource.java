/**
 * 
 */
package com.jucycakes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jucycakes.model.ItemPedido;
import com.jucycakes.model.Pedido;
import com.jucycakes.repository.ItemPedidos;

/**
 * @author Silvan Jesus
 *
 */

@RestController
@RequestMapping("/itensPedidos")
public class ItemPedidoResource {
	// Responsável por publicar os eventos da aplicacao
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private ItemPedidos itemPedidos;
	
	
	
	
	
	
	@GetMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> buscarPorId(@PathVariable("pedido") Pedido pedido) {

		List<ItemPedido> pedidoRetornado = itemPedidos.findByPedido(pedido);		

        return ResponseEntity.status(HttpStatus.OK).body(pedidoRetornado);

    }
}
