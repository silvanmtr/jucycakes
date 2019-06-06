/**
 * 
 */
package com.jucycakes.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Silvan de Jesus
 *
 */

@Embeddable
public class ItemPedidoId  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "codigo_pedido")
	private Pedido pedido;
	
	@ManyToOne
	@JoinColumn(name = "codigo_item")
	private Bolo bolo;
	

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Bolo getBolo() {
		return bolo;
	}

	public void setBolo(Bolo bolo) {
		this.bolo = bolo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bolo == null) ? 0 : bolo.hashCode());
		result = prime * result + ((pedido == null) ? 0 : pedido.hashCode());
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
		ItemPedidoId other = (ItemPedidoId) obj;
		if (bolo == null) {
			if (other.bolo != null)
				return false;
		} else if (!bolo.equals(other.bolo))
			return false;
		if (pedido == null) {
			if (other.pedido != null)
				return false;
		} else if (!pedido.equals(other.pedido))
			return false;
		return true;
	}
}
