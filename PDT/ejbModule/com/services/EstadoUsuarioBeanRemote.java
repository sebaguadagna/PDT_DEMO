package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.EstadoUsuario;
import com.exception.ServiciosException;

@Remote
public interface EstadoUsuarioBeanRemote {
	
	void altaEstado(EstadoUsuario estado) throws ServiciosException;
	void bajaEstado(EstadoUsuario estado) throws ServiciosException;
	void modificarEstado(EstadoUsuario estado) throws ServiciosException;
	List<EstadoUsuario> obtenerPorEstado(String estado) throws ServiciosException;
	EstadoUsuario findForMerge (Long pk) throws ServiciosException;

}
