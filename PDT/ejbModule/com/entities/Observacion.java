package com.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "OBSERVACIONES")
public class Observacion implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqObservacion", initialValue=5000, sequenceName="SEQ_ID_OBSERVACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqObservacion")
	private Long pk_observacion;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_usuario_observacion"))
	private Usuario usr;
	
	@Temporal(TemporalType.DATE)
    private Date fechaHora;
	
	@Column(length = 200)
	private  String descripcion;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_fenomeno_observacion"))
	private Fenomeno categoria;

	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_departamento_observacion"))
	private Departamento departamento;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_localidad_observacion"))
	private Localidad localidad;
	
	private boolean validarExperto;
	
	
	@JoinTable(
			name = "VALOR",
			joinColumns = @JoinColumn(name = "FK_OBSERVACION", nullable = false),
			inverseJoinColumns = @JoinColumn(name="FK_CARACTERISTICA", nullable = false)
			)
	
	@ManyToMany(cascade = CascadeType.ALL)
    private List<Caracteristica> caracteristicas;
	

	public void agregarCaracteristica(Caracteristica caracteristica){
        if(this.caracteristicas == null){
            this.caracteristicas = new ArrayList<>();
        }
        
        this.caracteristicas.add(caracteristica);
    }


	public Long getPk_observacion() {
		return pk_observacion;
	}


	public void setPk_observacion(Long pk_observacion) {
		this.pk_observacion = pk_observacion;
	}


	public Usuario getUsr() {
		return usr;
	}


	public void setUsr(Usuario usr) {
		this.usr = usr;
	}


	public Date getFechaHora() {
		return fechaHora;
	}


	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Fenomeno getCategoria() {
		return categoria;
	}


	public void setCategoria(Fenomeno categoria) {
		this.categoria = categoria;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Localidad getLocalidad() {
		return localidad;
	}


	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}


	public List<Caracteristica> getCaracteristicas() {
		return caracteristicas;
	}


	public void setCaracteristicas(List<Caracteristica> caracteristicas) {
		this.caracteristicas = caracteristicas;
	}


	public boolean isValidarExperto() {
		return validarExperto;
	}


	public void setValidarExperto(boolean validarExperto) {
		this.validarExperto = validarExperto;
	}
	
	
}
