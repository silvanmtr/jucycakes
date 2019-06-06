/**
 * 
 */
package com.jucycakes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jucycakes.model.Usuario;

/**
 * @author Silvan de Jesus
 *
 */
public interface Usuarios extends JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
	public Optional<Usuario> findByEmail(String email);
}
