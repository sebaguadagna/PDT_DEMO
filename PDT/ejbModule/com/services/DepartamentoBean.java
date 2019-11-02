package com.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Zona;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;


@Stateless
public class DepartamentoBean implements DepartamentoBeanRemote {

   
	@PersistenceContext
	private EntityManager em;
	
    public DepartamentoBean() {
       
    }

	@Override
	public void altaDepartamento(Departamento nombre) throws ServiciosException {
		try {
			em.persist(nombre);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el Departamento");
		}
		
	}

	@Override
	public void altaDepartamento(Departamento nombre, Long zonaPK) throws ServiciosException {
		
		try {
			nombre.setZona(em.find(Zona.class, zonaPK));
			em.persist(nombre);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el Departamento");
		}
		
	}

	@Override
	public void bajaDepartamento(int pk) throws ServiciosException {

		try {
			Departamento d = em.find(Departamento.class, pk);
			em.remove(d);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el Departamento");
		}
	}

	@Override
	public void modificarDepartamentoZona(Departamento d, Long pkZona) throws ServiciosException {
		
		try {
			d.setZona(em.find(Zona.class, pkZona));
			em.merge(d);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar la zona del Departamento");
		}
	}

	@Override
	public List<Departamento> obtenerPorNombre(NDepartamentos departamentoEnum) throws ServiciosException {
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d WHERE d.nombre = :n", Departamento.class)
					.setParameter("n", departamentoEnum);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar el departamento: " + departamentoEnum);
			}
	}

	@Override
	public List<Departamento> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar registros");
			}
	}

	@Override
	public Departamento findForMerge(int pk) throws ServiciosException {
		try {
			Departamento nombre = em.find(Departamento.class, pk);
			return nombre;
			} catch(PersistenceException e) {
				throw new ServiciosException("No hay ningun departamento asociado a esa PK en la tabla" + pk);
			}
	}

}
