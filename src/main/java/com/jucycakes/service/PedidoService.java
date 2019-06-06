/**
 * 
 */
package com.jucycakes.service;

import java.util.Optional;

import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucycakes.model.Bolo;
import com.jucycakes.model.ItemPedido;
import com.jucycakes.model.Pedido;
import com.jucycakes.repository.Pedidos;
import com.jucycakes.service.exception.ImpossibleDeleteImpossible;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class PedidoService {

	@Autowired
	private Pedidos pedidos;
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@Transactional
	public Pedido save(Pedido pedido) {
		
		Pedido p = pedidos.saveAndFlush(pedido);
		
		
		
		for(Bolo b: p.getBolos()) {
			ItemPedido itemPedido = new ItemPedido();
			
			itemPedido.setBolo(b);
			itemPedido.setPedido(p);
			itemPedido.setQuantidade(b.getQuantidade()+1.0);
			
			itemPedidoService.save(itemPedido);
		}
		return pedidos.save(pedido);
		
	}
	
	@Transactional
    public void excluir(Long id) {
        try {

            Pedido pedido = verifyIfPedidoExistsById(id);

            pedidos.delete(pedido);
            pedidos.flush();
            
        } catch (PersistenceException e) {
            throw new ImpossibleDeleteImpossible();
        }
    }
	
	private Pedido verifyIfPedidoExistsById(final Long id) {
        Optional<Pedido> pedifoById = pedidos.findById(id);

        if (!pedifoById.isPresent()) {
            throw new ImpossibleDeleteImpossible();
        }

        return pedifoById.get();
    }
}
