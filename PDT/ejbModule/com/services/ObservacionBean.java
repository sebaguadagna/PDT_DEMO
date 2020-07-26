package com.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.entities.Fenomeno;
import com.entities.Observacion;
import com.entities.Usuario;
import com.enumerados.CZonas;
import com.exception.ServiciosException;


@Stateless
public class ObservacionBean implements ObservacionBeanRemote {

	@PersistenceContext
	private EntityManager em;
    public ObservacionBean() {
       
    }

	@Override
	public int altaObservacion(Observacion obs) throws ServiciosException {
		try {
			int pkObs; 
			em.persist(obs);
			pkObs = obs.getId_observacion();
			em.flush();
			return pkObs;
		} catch (PersistenceException e) {
		    
			throw new ServiciosException("No se pudo dar de alta , la observacion");
		}
		
	}

	@Override
	public void bajaObservacion(int pk) throws ServiciosException {
		try {
			Fenomeno f = em.find(Fenomeno.class, pk);
			em.remove(f);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la observacion");
		}
		
	}

	@Override
	public void modificarObservacion(Observacion obs) throws ServiciosException {
		try {
			em.merge(obs);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo modificar la observacio");
		}
		
		
	}

	@Override
	public List<Observacion> obtenerPorUsuario(Usuario usuario) throws ServiciosException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Observacion> obtenerTodos() throws ServiciosException {
		try {
			TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o", Observacion.class);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException(e.getMessage());
			}
	}

	@Override
	public Observacion findForMerge(int pk) throws ServiciosException {
		try {
			Observacion obs = em.find(Observacion.class, pk);
			return obs;
			} catch(PersistenceException e) {
				throw new ServiciosException("No hay ninguna observacion asociado a esa PK en la tabla" + pk);
			}
	}

	@Override
	public List<Observacion> obtenerPorZona(CZonas zona) throws ServiciosException {
		try {
			TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o JOIN o.localidad l JOIN l.departamento d JOIN d.zona z WHERE z.categoria = :nZona ORDER BY d.nombre", Observacion.class)
					.setParameter("nZona", zona);;
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException("No se pudo encontrar las localidades: " + e.getMessage());
			}
	
	}

	@Override
	public List<Observacion> obtenerSinValidar() throws ServiciosException {
		try {
			TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o WHERE o.validarExperto = FALSE", Observacion.class);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException(e.getMessage());
			}
	}

	@Override
	public List<Observacion> obtenerPorPK(int pk) throws ServiciosException {

		try {
			TypedQuery<Observacion> query = em.createQuery("SELECT o FROM Observacion o WHERE o.id_observacion = :pk", Observacion.class)
					.setParameter("pk", pk);
			return query.getResultList();
			} catch (PersistenceException e) {
				throw new ServiciosException(e.getMessage());
			}
	}

}
