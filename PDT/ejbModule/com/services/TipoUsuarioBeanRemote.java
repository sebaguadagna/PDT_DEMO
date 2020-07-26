package com.services;

import java.util.List;

import javax.ejb.Remote;


import com.entities.TipoUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;

@Remote
public interface TipoUsuarioBeanRemote {
	

	void altaTipoUsuario(TipoUsuario tipo) throws ServiciosException;
	void bajaTipoUsuario(TipoUsuario tipo) throws ServiciosException;
    void modificarTipoUsuario(TipoUsuario tipo) throws ServiciosException;
    List<TipoUsuario> obtenerPorRol(TUsuarios tipoEnum) throws ServiciosException;
	List<TipoUsuario> obtenerTodos() throws ServiciosException;
	TipoUsuario findForMerge(int pk) throws ServiciosException;

}
