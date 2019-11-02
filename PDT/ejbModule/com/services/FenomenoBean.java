package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Fenomeno;
import com.enumerados.CFenomeno;
import com.exception.ServiciosException;


@Stateless
public class FenomenoBean implements FenomenoBeanRemote {

	@PersistenceContext
	private EntityManager em;
    public FenomenoBean() {
      
    }

	@Override
	public void altaFenomeno(Fenomeno nombre) throws ServiciosException {
		try {
			em.persist(nombre);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el fenomeno");
		}
		
	}

	@Override
	public void bajaFenomeno(int pk) throws ServiciosException {
		try {
			Fenomeno f = em.find(Fenomeno.class, pk);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la categoria");
		}
		
	}

	@Override
	public void modificarFenomeno(Fenomeno nombre) throws ServiciosException {
		try {
			em.merge(nombre);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el fenomeno");
		}
		
	}

	@Override
	public List<Fenomeno> obtenerPorNombre(CFenomeno fenomenoEnum) throws ServiciosException {
		try {
			TypedQuery<Fenomeno> query = em.createQuery("SELECT f FROM Fenomeno f WHERE f.nombre = :n", Fenomeno.class)
					.setParameter("n", fenomenoEnum);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar la categoria: " + fenomenoEnum);
			}
	}

	@Override
	public List<Fenomeno> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Fenomeno> query = em.createQuery("SELECT f FROM Fenomeno f", Fenomeno.class);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException(e.getMessage());
			}
	}

	@Override
	public Fenomeno findForMerge(int pk) throws ServiciosException {
		try {
			Fenomeno nombre = em.find(Fenomeno.class, pk);
			return nombre;
			} catch(PersistenceException e) {
				throw new ServiciosException("No hay ningun fenomeno asociado a esa PK en la tabla" + pk);
			}
	}

}
