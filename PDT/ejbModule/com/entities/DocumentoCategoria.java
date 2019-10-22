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
		@UniqueConstraint(name="uk_categoria", columnNames= {"categoriaNombre"})
		})
public class DocumentoCategoria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqDocumentoCategoria", initialValue=100, sequenceName="SEQ_ID_DOCUMENTO_CATEGORIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDocumentoCategoria")
	private int id_docu_categoria;
	
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private CDocumento categoriaNombre;


	public int getId_docu_categoria() {
		return id_docu_categoria;
	}

	public void setId_docu_categoria(int id_docu_categoria) {
		this.id_docu_categoria = id_docu_categoria;
	}

	public CDocumento getCategoriaNombre() {
		return categoriaNombre;
	}

	public void setCategoriaNombre(CDocumento categoriaNombre) {
		this.categoriaNombre = categoriaNombre;
	}

	
}
