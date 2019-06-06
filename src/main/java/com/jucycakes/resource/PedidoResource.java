/**
 * 
 */
package com.jucycakes.resource;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jucycakes.event.listener.RecursoCriadoEvent;
import com.jucycakes.model.Pedido;
import com.jucycakes.repository.ItemPedidos;
import com.jucycakes.repository.Pedidos;
import com.jucycakes.service.PedidoService;

/**
 * @author Silvan Jesus
 *
 */

@RestController
@RequestMapping("/pedidos")
public class PedidoResource {
	// Responsável por publicar os eventos da aplicacao
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private Pedidos pedidos;
	
	@Autowired
	private ItemPedidos itemPedidos;
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<Pedido> cadastrar(@Valid @RequestBody Pedido pedido,  HttpServletResponse response){
		
		Pedido pedidoSalvo = pedidoService.save(pedido);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pedidoSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
	}
	
	@GetMapping
    public List<Pedido> all() {
		
		List<Pedido> pedidosRetornados = pedidos.findAll();
		
		
		
        return pedidosRetornados;
    }
	
	@DeleteMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long id) {

		pedidoService.excluir(id);

        return ResponseEntity.ok().build();
    }
	
	
	@GetMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> buscarPorId(@PathVariable("codigo") Long id) {

		Pedido pedidoRetornado = pedidos.findByCodigo(id);		

        return ResponseEntity.status(HttpStatus.OK).body(pedidoRetornado);

    }
}
