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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jucycakes.event.listener.RecursoCriadoEvent;
import com.jucycakes.model.Usuario;
import com.jucycakes.repository.Usuarios;
import com.jucycakes.service.UsuarioService;

/**
 * @author Silvan Jesus
 *
 */

@RestController
@RequestMapping("/usuarios")
public class LoginResource {
	// Responsável por publicar os eventos da aplicacao
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<Usuario> cadastrar(@Valid @RequestBody Usuario usuario,  HttpServletResponse response){
		Usuario usuarioSalvo = usuarioService.salvar(usuario);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, usuarioSalvo.getCodigo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
	
	@GetMapping
    public List<Usuario> all() {
        return usuarios.findAll();
    }
	
	@GetMapping("/autenticar/{email}/{senha}")
	public Usuario autenticar(@PathVariable String email, @PathVariable String senha) {
		
		Usuario user = usuarios.findByEmailAndSenha(email, senha).get();
		
		
		return user ;
	}
}
