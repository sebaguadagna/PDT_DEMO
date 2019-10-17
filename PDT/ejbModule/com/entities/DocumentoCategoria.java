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
		@UniqueConstraint(name="uk_categoria", columnNames= {"categoria"})
		})
public class DocumentoCategoria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_docu_categoria;
	
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private CDocumento categoria;

	public Long getId_docu_categoria() {
		return id_docu_categoria;
	}

	public void setId_docu_categoria(Long id_docu_categoria) {
		this.id_docu_categoria = id_docu_categoria;
	}

	public CDocumento getCategoria() {
		return categoria;
	}

	public void setCategoria(CDocumento categoria) {
		this.categoria = categoria;
	}	
}
