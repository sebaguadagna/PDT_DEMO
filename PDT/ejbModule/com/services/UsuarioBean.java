package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
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
	public void altaUsuario(Usuario usuario) throws ServiciosException {
		try {
			em.persist(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el usuario");
		}
	}

	@Override
	public void bajaUsuario(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja a el usuario");
		}
	}

	
	//Priviamente a una modificacion hay que usar el metodo find
	@Override
	public void modificarUsuario(Usuario usuario) throws ServiciosException {
		try {
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
