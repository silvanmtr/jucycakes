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
import com.jucycakes.model.Bolo;
import com.jucycakes.repository.Bolos;
import com.jucycakes.service.BoloService;

/**
 * @author Silvan Jesus
 *
 */

@RestController
@RequestMapping("/bolos")
public class BoloResource {
	// Responsável por publicar os eventos da aplicacao
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private Bolos bolos;
	
	@Autowired
	private BoloService boloService;
	
	@PostMapping
	public ResponseEntity<Bolo> cadastrar(@Valid @RequestBody Bolo bolo,  HttpServletResponse response){
		Bolo boloSalvo = bolos.save(bolo);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, boloSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(boloSalvo);
	}
	
	@GetMapping
    public List<Bolo> all() {
        return bolos.findAll();
    }
	
	@DeleteMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> excluir(@PathVariable("codigo") Long id) {

		boloService.excluir(id);

        return ResponseEntity.ok().build();
    }
	
	
	@GetMapping("/{codigo}")
    public @ResponseBody ResponseEntity<?> buscarPorId(@PathVariable("codigo") Long id) {

		Bolo boloRetornado = bolos.findByCodigo(id);		

        return ResponseEntity.status(HttpStatus.OK).body(boloRetornado);

    }
}
