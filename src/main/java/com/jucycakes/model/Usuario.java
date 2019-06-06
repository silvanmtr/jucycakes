/**
 * 
 */
package com.jucycakes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author silvandejesusfeitosa
 *
 */
@Entity
@Table(name = "usuario")

@RequiredArgsConstructor
@Getter
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	@NotBlank(message = "msg-nome-usuario")
	private String nome;

	@NotBlank(message = "msg-email-usuario")
	//@Email(message = "msg-email-invalido")
	private String email;

	@NotNull(message="msg-senha-nao-nula")
	@NotBlank(message="msg-senha-nao-vazia")
	private String senha;
	
	@JsonIgnore
    public boolean isNew() {
        return getCodigo() == null;
    }

    @JsonIgnore
    public boolean alreadyExist() {
        return getCodigo() != null;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
