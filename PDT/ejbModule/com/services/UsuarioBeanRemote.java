package com.services;

import java.sql.ResultSet;
import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	void altaUsuario(Usuario usuario) throws ServiciosException;
	void bajaUsuario(Usuario usuario) throws ServiciosException;
	void modificarUsuario(Usuario usuario) throws ServiciosException;
	List<Usuario> obtenerPorUsername(String username) throws ServiciosException;
	Usuario findForMerge (Long pk) throws ServiciosException;
	List<Usuario> obtenerTodosLosUsuarios() throws ServiciosException;

	
}
