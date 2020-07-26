package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exception.ServiciosException;

@Remote
public interface UsuarioBeanRemote {

	void altaUsuario(String nombre, String Apellido, String direccion, int dcPK, String documento, String email,
			int estado, int rolPK, String username, String password) throws ServiciosException;
	void bajaUsuario(Usuario usuario) throws ServiciosException;
	void modificarUsuario(Usuario usuario,  int estadoPK, int rolPK) throws ServiciosException;
	List<Usuario> obtenerPorEmail(String username) throws ServiciosException;
	Usuario findForMerge (int pk) throws ServiciosException;
	List<Usuario> obtenerTodosLosUsuarios() throws ServiciosException;


	
}
