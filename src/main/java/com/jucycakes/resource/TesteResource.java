package com.jucycakes.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jucycakes.model.Bolo;
import com.jucycakes.repository.Bolos;

@RestController
@RequestMapping("/bolos")
public class TesteResource {
	
	@Autowired
	private Bolos bolos;
	
	@GetMapping
    public List<Bolo> all() {
        return bolos.findAll();
    }

}
