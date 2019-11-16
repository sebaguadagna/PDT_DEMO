package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Observacion;
import com.entities.Usuario;
import com.enumerados.CZonas;
import com.exception.ServiciosException;

@Remote
public interface ObservacionBeanRemote {
	
	void altaObservacion(Observacion obs) throws ServiciosException;
	void bajaObservacion(Long pk) throws ServiciosException;
	void modificarObservacion(Observacion obs) throws ServiciosException;
	List<Observacion> obtenerPorUsuario(Usuario usuario) throws ServiciosException;
	List<Observacion> obtenerPorZona(CZonas zona) throws ServiciosException;
	List<Observacion> obtenerTodos() throws ServiciosException;
	List<Observacion> obtenerSinValidar() throws ServiciosException;
	List<Observacion> obtenerPorPK(int pk) throws ServiciosException;
	Observacion findForMerge(Long pk) throws ServiciosException;

}
