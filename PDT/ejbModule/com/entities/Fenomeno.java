package com.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Fenomeno
 *
 */
@Entity
@Table(name = "FENOMENOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_codigo_fenomeno", columnNames= {"codigo"})
		})

public class Fenomeno implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int id_fenomeno;
	
	@Column(nullable = false)
	private  String codigo;
	
	@Column(length = 80, nullable = false)
	private  String nombre;
	
	@Column(length = 40)
	private  String telefono;
	
	@Column(length = 100)
	private  String descripcion;
	
	@OneToMany(mappedBy = "fenomeno",cascade = CascadeType.REMOVE)
	private List<Caracteristica> caracteristica;

	public int getId_fenomeno() {
		return id_fenomeno;
	}

	public void setId_fenomeno(int id_fenomeno) {
		this.id_fenomeno = id_fenomeno;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}