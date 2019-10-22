package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.EUsuario;

/**
 * Entity implementation class for Entity: EstadoUsuario
 *
 */
@Entity
@Table(name = "ESTADO_USUARIOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_estado", columnNames= {"estadoNombre"})
		})

public class EstadoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seqEstadoUsuario", initialValue=200, sequenceName="SEQ_ID_ESTADO_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEstadoUsuario")
	private int id_estado_usuario;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private EUsuario estadoNombre;


	public int getId_estado_usuario() {
		return id_estado_usuario;
	}

	public void setId_estado_usuario(int id_estado_usuario) {
		this.id_estado_usuario = id_estado_usuario;
	}

	public EUsuario getEstadoNombre() {
		return estadoNombre;
	}

	public void setEstadoNombre(EUsuario estadoNombre) {
		this.estadoNombre = estadoNombre;
	}



	
}
