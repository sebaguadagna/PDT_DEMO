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
		@UniqueConstraint(name="uk_estado", columnNames= {"estado_valor"})
		})

public class EstadoUsuario implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	private int id_estado_usuario;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private EUsuario estado_valor;


	public int getId_estado_usuario() {
		return id_estado_usuario;
	}

	public void setId_estado_usuario(int id_estado_usuario) {
		this.id_estado_usuario = id_estado_usuario;
	}

	public EUsuario getEstado_valor() {
		return estado_valor;
	}

	public void setEstado_valor(EUsuario estado_valor) {
		this.estado_valor = estado_valor;
	}

	
}