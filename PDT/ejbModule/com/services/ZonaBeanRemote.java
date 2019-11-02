package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Zona;
import com.enumerados.CZonas;
import com.exception.ServiciosException;

@Remote
public interface ZonaBeanRemote {

	void altaZona(Zona categoria) throws ServiciosException;
	void bajaZona(Long pk) throws ServiciosException;
	void modificarZona(Zona categoria) throws ServiciosException;
	List<Zona> obtenerPorCategoria(CZonas zonaEnum) throws ServiciosException;
	List<Zona> obtenerTodos() throws ServiciosException;
	Zona findForMerge(Long pk) throws ServiciosException;
	
	
}
