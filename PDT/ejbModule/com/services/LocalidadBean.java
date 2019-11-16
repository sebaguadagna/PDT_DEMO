package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Localidad;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

/**
 * Session Bean implementation class LocalidadBean
 */
@Stateless
public class LocalidadBean implements LocalidadBeanRemote {

	@PersistenceContext
	private EntityManager em;
    public LocalidadBean() {
    	
    }

	@Override
	public void altaLocalidad(Localidad nombre) throws ServiciosException {
		try {
			em.persist(nombre);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la localidad: " + e.getMessage());
		}
		
	}

	@Override
	public void bajaLocalidad(int pk) throws ServiciosException {

		try {
			Localidad l = em.find(Localidad.class, pk);
			em.remove(l);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la localidad: " + e.getMessage());
		}
	}

	@Override
	public void modificarLocalidadDepartamento(Localidad l, int pkDepartamento) throws ServiciosException {
		try {
			l.setDepartamento(em.find(Departamento.class, pkDepartamento));;
			em.merge(l);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar el departamento de la Localidad: " + e.getMessage());
		}
		
	}

	@Override
	public List<Localidad> obtenerLocalidadesPorDepartamento(NDepartamentos departamentoEnum) throws ServiciosException{
	
		try {
			TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l WHERE l.departamento.nombre = :d", Localidad.class)
					.setParameter("d", departamentoEnum);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar las localidades: " + e.getMessage());
			}
	
	}

	@Override
	public Localidad findForMerge(int pk) throws ServiciosException {
		try {
			Localidad nombre = em.find(Localidad.class, pk);
			return nombre;
			} catch(PersistenceException e) {
				throw new ServiciosException("No se puede encontrar la localidad" + e.getMessage());
			}
	}

	@Override
	public List<Localidad> obtenerLocalidadesPorPk(NDepartamentos departamentoEnum, String lc) throws ServiciosException {
		try {
			TypedQuery<Localidad> query = em.createQuery("SELECT l FROM Localidad l WHERE l.nombre = :s AND l.departamento.nombre = :d", Localidad.class)
					.setParameter("d", departamentoEnum)
					.setParameter("s", lc);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar las localidades: " + e.getMessage());
			}
	}

}
