package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Detalle;
import com.exception.ServiciosException;

@Remote
public interface DetalleBeanRemote {
	
	void altaDetalle (Detalle dt)  throws ServiciosException;
	void bajaCaracteristica(Detalle dt) throws ServiciosException;
	void modificarCaracteristica(Detalle dt) throws ServiciosException;
	Detalle findForMerge(int pkDt) throws ServiciosException;
	List<Detalle> ObtenerObsAndCrcForEmail (String emailUsuario) throws ServiciosException;

}
