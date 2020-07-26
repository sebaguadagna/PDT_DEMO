package com.entities;

import java.io.Serializable;


import javax.persistence.*;
import com.enumerados.TipoDato;

/**
 * Entity implementation class for Entity: Caracteristica
 *
 */
@Entity
@Table(name = "CARACTERISTICAS")
public class Caracteristica implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	private int id_caracteristica;
   
	@Column(length = 80, nullable = false)
	private  String nombre;
	
	@Column(length = 80, nullable = false)
	private  String etiqueta;
	
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private TipoDato tipoDato;
	
	@ManyToOne()
	@JoinColumn(foreignKey=@ForeignKey(name="fk_fenomeno_caracteristica"))
	private Fenomeno fenomeno;
	

	
	public int getId_caracteristica() {
		return id_caracteristica;
	}

	public void setId_caracteristica(int id_caracteristica) {
		this.id_caracteristica = id_caracteristica;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public TipoDato getTipoDato() {
		return tipoDato;
	}

	public void setTipoDato(TipoDato tipoDato) {
		this.tipoDato = tipoDato;
	}
	
	public Fenomeno getFenomeno() {
		return fenomeno;
	}

	public void setFenomeno(Fenomeno fenomeno) {
		this.fenomeno = fenomeno;
	}
	
	
}