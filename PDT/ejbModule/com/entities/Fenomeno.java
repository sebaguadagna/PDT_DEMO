package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.CFenomeno;

/**
 * Entity implementation class for Entity: Fenomeno
 *
 */
@Entity
@Table(name = "FENOMENOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_codigo_fenomeno", columnNames= {"codigo"}),
		@UniqueConstraint(name="uk_nombre_fenomeno", columnNames= {"nombre"})
		})

public class Fenomeno implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqFenomeno", initialValue=500, sequenceName="SEQ_ID_FENOMENO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqFenomeno")
	private int id_fenomeno;
	
	@Column(nullable = false)
	private  int codigo;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private  CFenomeno nombre;
	
	@Column(length = 40)
	private  String telefono;
	
	@Column(length = 100)
	private  int descripcion;

	public int getId_fenomeno() {
		return id_fenomeno;
	}

	public void setId_fenomeno(int id_fenomeno) {
		this.id_fenomeno = id_fenomeno;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public CFenomeno getNombre() {
		return nombre;
	}

	public void setNombre(CFenomeno nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}

}
