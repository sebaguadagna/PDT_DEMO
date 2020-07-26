package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Fenomeno;
import com.exception.ServiciosException;

@Remote
public interface FenomenoBeanRemote {

	void altaFenomeno(Fenomeno nombre) throws ServiciosException;
	void bajaFenomeno(int pk) throws ServiciosException;
	void modificarFenomeno(Fenomeno nombre) throws ServiciosException;
	List<Fenomeno> obtenerPorNombre(String descripcion) throws ServiciosException;
	List<Fenomeno> obtenerTodos() throws ServiciosException;
	Fenomeno findForMerge(int pk) throws ServiciosException;
}
