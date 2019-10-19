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
		@UniqueConstraint(name="uk_estado", columnNames= {"estado"})
		})

public class EstadoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "seqEstadoUsuario", allocationSize=10,initialValue=30, sequenceName="SEQ_ID_ESTADO_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqEstadoUsuario")
	private Long id_estado_usuario;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private EUsuario estado;

	public Long getId_estado_usuario() {
		return id_estado_usuario;
	}

	public void setId_estado_usuario(Long id_estado_usuario) {
		this.id_estado_usuario = id_estado_usuario;
	}

	public EUsuario getEstado() {
		return estado;
	}

	public void setEstado(EUsuario estado) {
		this.estado = estado;
	}

	
}
