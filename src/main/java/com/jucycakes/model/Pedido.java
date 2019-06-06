/**
 * 
 */
package com.jucycakes.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Silvan de Jesus
 *
 */

@Entity
@Table(name = "pedido")
public class Pedido  implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@ManyToOne
	@JoinColumn(name="codigo_usuario")
	private Usuario usuario;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "pedido")
    @JsonManagedReference
	private List<ItemPedido> itemPedido;
	
	@Transient
	private List<Bolo> bolos;
	
	@Transient 
	private Double total = 0.0;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "data_pedido")
	private LocalDateTime dataPedido;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}


	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}

	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}

	public List<Bolo> getBolos() {
		return bolos;
	}

	public void setBolos(List<Bolo> bolos) {
		this.bolos = bolos;
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
		Pedido other = (Pedido) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Double getTotal() {
		if(itemPedido!= null && itemPedido.size() > 0) {
			for(ItemPedido itemPedido : itemPedido) {
				
				this.total += itemPedido.getQuantidade() * itemPedido.getBolo().getPreco();

			}
		}
		return total;
	}

	public void setTotal(Double total) {
	
		this.total = total;
	}
	
	
	

}
