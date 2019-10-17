package com.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

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

	@Override
	public void modificarUsuario(Usuario usuario) throws ServiciosException {
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el usuario");
		}
	}
    
    

}
