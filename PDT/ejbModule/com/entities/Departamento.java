package com.entities;

import java.io.Serializable;
import javax.persistence.*;
import com.enumerados.NDepartamentos;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
@Table(name = "DEPARTAMENTOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_codigo_departamento", columnNames= {"codigo"}),
		@UniqueConstraint(name="uk_nombre_departamento", columnNames= {"nombre"})
		})
public class Departamento implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqDepartamento", initialValue=500, sequenceName="SEQ_ID_DEPARTAMENTO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqDepartamento")
	private int id_departamento;
	
	@Column(nullable = false)
	private int codigo;
	
	@Column(length = 40, nullable = false)
	@Enumerated(value = EnumType.STRING)
	private NDepartamentos nombre;
   
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_zona_departamento"))
	private Zona zona;

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public NDepartamentos getNombre() {
		return nombre;
	}

	public void setNombre(NDepartamentos nombre) {
		this.nombre = nombre;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}
	
}
