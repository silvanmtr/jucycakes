/**
 * 
 */
package com.jucycakes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jucycakes.model.ItemPedido;
import com.jucycakes.model.Pedido;

/**
 * @author Silvan de Jesus
 *
 */
public interface ItemPedidos extends JpaRepository<ItemPedido, Long>{

	List<ItemPedido> findByPedido(Pedido pedido);
}
