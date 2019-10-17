package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.CZonas;

/**
 * Entity implementation class for Entity: Zona
 *
 */
@Entity
@Table(name = "ZONAS", uniqueConstraints = {
		@UniqueConstraint(name="uk_categoria_zonas", columnNames= {"categoria"})
		})
public class Zona implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_zona;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private CZonas categoria;


	public Long getId_zona() {
		return id_zona;
	}

	public void setId_zona(Long id_zona) {
		this.id_zona = id_zona;
	}

	public CZonas getCategoria() {
		return categoria;
	}

	public void setCategoria(CZonas categoria) {
		this.categoria = categoria;
	}
	
}
