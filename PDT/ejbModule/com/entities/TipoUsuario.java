package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.TUsuarios;

/**
 * Entity implementation class for Entity: TipoUsuario
 *
 */
@Entity

@Table(name = "TIPO_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_rol", columnNames= {"rol"})
		})
public class TipoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqTipoUsuario", initialValue=1000, sequenceName="SEQ_ID_TIPO_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqTipoUsuario")
	private int id_tipo_usuario;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TUsuarios rol;


	public int getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(int id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public TUsuarios getRol() {
		return rol;
	}

	public void setRol(TUsuarios rol) {
		this.rol = rol;
	}
	
}
