/**
 * 
 */
package com.jucycakes.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucycakes.model.ItemPedido;
import com.jucycakes.repository.ItemPedidos;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class ItemPedidoService {

	@Autowired
	private ItemPedidos pedidos;
	
	@Transactional
	public void save(ItemPedido pedido) {
		
		 pedidos.save(pedido);
		
	}
	
}
