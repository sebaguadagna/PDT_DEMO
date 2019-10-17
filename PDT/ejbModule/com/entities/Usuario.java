package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;

/**
 * Entity implementation class for Entity: UsuarioPDT
 *
 */
@Entity
@Table(name = "USUARIOS", uniqueConstraints = {
		@UniqueConstraint(name="uk_username", columnNames= {"username"}),
		@UniqueConstraint(name="uk_documento", columnNames= {"documento","doc"}),
		@UniqueConstraint(name="uk_email", columnNames= {"email"})
		})
public class Usuario implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "seqUsuario", allocationSize=20,initialValue=100, sequenceName="SEQ_ID_USUARIO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqUsuario")
	private Long id_usuario;
	
	//@ManyToOne
	//@JoinColumn(foreignKey=@ForeignKey(name="fk_tipo_usuario"))
	//private TipoUsuario rol;
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private TUsuarios rol;
	
	//@ManyToOne
	//@JoinColumn(foreignKey=@ForeignKey(name="fk_estado_usuario"))
	//private EstadoUsuario estado;
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private EUsuario estado;
	
	@Column(length = 40, nullable = false)
	private String username;
	
	@Column(length = 40, nullable = false)
	private String nombre;
   
	@Column(length = 40, nullable = false)
	private String apellido;
	
	@Column(length = 40, nullable = false)
	private String direccion;
	
	//@ManyToOne
	//@JoinColumn(foreignKey=@ForeignKey(name="fk_d_c_usuarios"))
	//private DocumentoCategoria doc;
	@Column(length = 40)
	@Enumerated(value = EnumType.STRING)
	private CDocumento doc;
	
	@Column(length = 40, nullable = false)
	private String documento;
	
	@Column(length = 40, nullable = false)
	private String email;
	
	@Column(length = 40, nullable = false)
	private String password;

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TUsuarios getRol() {
		return rol;
	}

	public void setRol(TUsuarios rol) {
		this.rol = rol;
	}

	public EUsuario getEstado() {
		return estado;
	}

	public void setEstado(EUsuario estado) {
		this.estado = estado;
	}

	public CDocumento getDoc() {
		return doc;
	}

	public void setDoc(CDocumento doc) {
		this.doc = doc;
	}


	
   
}
