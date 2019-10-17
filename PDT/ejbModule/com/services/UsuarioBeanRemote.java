package com.services;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	void altaUsuario(Usuario usuario) throws ServiciosException;
	void bajaUsuario(Usuario usuario) throws ServiciosException;
	void modificarUsuario(Usuario usuario) throws ServiciosException;
	
}
