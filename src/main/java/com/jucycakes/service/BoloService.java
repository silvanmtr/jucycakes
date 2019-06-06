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
import com.jucycakes.repository.Bolos;
import com.jucycakes.service.exception.ImpossibleDeleteImpossible;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class BoloService {

	@Autowired
	private Bolos bolos;
	
	
	@Transactional
    public void excluir(Long id) {
        try {

            Bolo bolo = verifyIfEmpresaExistsById(id);

            bolos.delete(bolo);
            bolos.flush();
            
        } catch (PersistenceException e) {
            throw new ImpossibleDeleteImpossible();
        }
    }
	
	private Bolo verifyIfEmpresaExistsById(final Long id) {
        Optional<Bolo> boloById = bolos.findById(id);

        if (!boloById.isPresent()) {
            throw new ImpossibleDeleteImpossible();
        }

        return boloById.get();
    }
}
