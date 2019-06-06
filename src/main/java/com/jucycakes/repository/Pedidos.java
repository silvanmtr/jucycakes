/**
 * 
 */
package com.jucycakes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jucycakes.model.Pedido;

/**
 * @author Silvan de Jesus
 *
 */
public interface Pedidos extends JpaRepository<Pedido, Long>{

	Pedido findByCodigo(Long codigo);
}
