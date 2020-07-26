package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.CDocumento;

/**
 * Entity implementation class for Entity: DocumentoCategoria
 *
 */
@Entity

@Table(name = "DOCUMENTO_CATEGORIAS", uniqueConstraints = {
		@UniqueConstraint(name="uk_categoria", columnNames= {"categoria_nombre"})
		})
public class DocumentoCategoria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id_docu_categoria;
	
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private CDocumento categoria_nombre;


	public int getId_docu_categoria() {
		return id_docu_categoria;
	}

	public void setId_docu_categoria(int id_docu_categoria) {
		this.id_docu_categoria = id_docu_categoria;
	}

	public CDocumento getCategoria_nombre() {
		return categoria_nombre;
	}

	public void setCategoria_nombre(CDocumento categoria_nombre) {
		this.categoria_nombre = categoria_nombre;
	}



	
}