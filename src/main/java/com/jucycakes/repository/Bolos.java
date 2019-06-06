/**
 * 
 */
package com.jucycakes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jucycakes.model.Bolo;

/**
 * @author Silvan de Jesus
 *
 */
public interface Bolos extends JpaRepository<Bolo, Long>{

	Bolo findByCodigo(Long codigo);
}
