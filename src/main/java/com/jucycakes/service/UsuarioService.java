/**
 * 
 */
package com.jucycakes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jucycakes.model.Usuario;
import com.jucycakes.repository.Usuarios;
import com.jucycakes.service.exception.EmailUserAlreadyExistException;

/**
 * @author Silvan de Jesus
 *
 */

@Service
public class UsuarioService {

	@Autowired
	private Usuarios usuarios;
	
	public Usuario salvar(final Usuario usuario) {
		verifyIfUsuarioExists(usuario);
		
		return usuarios.save(usuario);
		
	}
	
	private void verifyIfUsuarioExists(final Usuario usuario) {
        Optional<Usuario> usuarioByEmail = usuarios.findByEmail(usuario.getEmail());

        if (usuarioByEmail.isPresent() && (usuario.isNew() ||
        		isUpdatingToADifferentUser(usuario, usuarioByEmail))) {
            throw new EmailUserAlreadyExistException();
        }
    }
	
   private boolean isUpdatingToADifferentUser(Usuario usuario, Optional<Usuario> usuarioByEmail) {
	   	return usuario.alreadyExist() && !usuarioByEmail.get().equals(usuario);
}
}
