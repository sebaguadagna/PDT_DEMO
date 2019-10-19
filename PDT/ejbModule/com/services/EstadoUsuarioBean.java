package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.EstadoUsuario;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class EstadoUsuarioBean
 */
@Stateless
public class EstadoUsuarioBean implements EstadoUsuarioBeanRemote {

   
	@PersistenceContext
	private EntityManager em;
	
    public EstadoUsuarioBean() {
        // TODO Auto-generated constructor stub
    }


    
	@Override
	public void altaEstado(EstadoUsuario estado) throws ServiciosException {
		try {
			em.persist(estado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el usuario");
		}
		
	}

	@Override
	public void bajaEstado(EstadoUsuario estado) throws ServiciosException {
		try {
			em.merge(estado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja a el usuario");
		}
		
	}

	@Override
	public void modificarEstado(EstadoUsuario estado) throws ServiciosException {
		try {
			em.merge(estado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja a el usuario");
		}
		
	}

	@Override
	public List<EstadoUsuario> obtenerPorEstado(String estado) throws ServiciosException {
		try {
			TypedQuery<EstadoUsuario> query = em.createQuery("SELECT e FROM EstadoUsuario e WHERE e.estado = :e", EstadoUsuario.class)
					.setParameter("e", estado);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar el estado " + estado);
			}
	}

	@Override
	public EstadoUsuario findForMerge(Long pk) throws ServiciosException {
		try {
			EstadoUsuario estado = em.find(EstadoUsuario.class, pk);
			return estado;
			} catch(PersistenceException e) {
				throw new ServiciosException("No hay ningun estado asociado a esa PK en la tabla" + pk);
			}
	}
    

}
