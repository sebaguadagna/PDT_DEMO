package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.DocumentoCategoria;
import com.entities.EstadoUsuario;
import com.entities.TipoUsuario;
import com.entities.Usuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class UsuarioBean
 */
@Stateless
public class UsuarioBean implements UsuarioBeanRemote {


	@PersistenceContext
	private EntityManager em;
	
    public UsuarioBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void altaUsuario(String nombre, String apellido, String direccion, int dcPK, String documento, String email, int estadoPK,
			int rolPK, String username, String password) throws ServiciosException {
		try {
			
			
			Usuario user = new Usuario();
			user.setNombre(nombre);
			user.setApellido(apellido);
			user.setDireccion(direccion);
			user.setDoc(em.find(DocumentoCategoria.class, dcPK));           
			user.setDocumento(documento);
			user.setEmail(email);
			user.setEstado(em.find(EstadoUsuario.class, estadoPK));  
			user.setRol(em.find(TipoUsuario.class, rolPK));   
			user.setUsername(username);
			user.setPassword(password);
			em.persist(user);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException(e.getMessage());
		}
	}

	@Override
	public void bajaUsuario(Usuario usuario,  int estadoPK) throws ServiciosException {
		try {
			usuario.setEstado(em.find(EstadoUsuario.class, estadoPK));
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja a el usuario");
		}
	}

	
	//Priviamente a una modificacion hay que usar el metodo find
	@Override
	public void modificarUsuario(Usuario usuario,  int estadoPK) throws ServiciosException {
		try {
			usuario.setEstado(em.find(EstadoUsuario.class, estadoPK));
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el usuario");
		}
	}

	@Override
	public List<Usuario> obtenerPorUsername(String email) throws ServiciosException {
		try {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.email = :e", Usuario.class)
				.setParameter("e", email);
		return query.getResultList();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo encontrar al usuario por el correo " + email);
		}
	}

	@Override
	public Usuario findForMerge(Long pk) throws ServiciosException {
		try {
		Usuario user = em.find(Usuario.class, pk);
		return user;
		} catch(PersistenceException e) {
			throw new ServiciosException("No hay ningun usuario asociado a esa PK en la tabla" + pk);
		}
	}

	@Override
	public List<Usuario> obtenerTodosLosUsuarios() throws ServiciosException {
		
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo realizar la consula");
			}
	}    
	
}
