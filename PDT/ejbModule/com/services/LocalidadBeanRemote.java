package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

@Remote
public interface LocalidadBeanRemote {

	
	void altaLocalidad(Localidad nombre) throws ServiciosException;
	void bajaLocalidad(Long pk) throws ServiciosException;
	void modificarLocalidadDepartamento(Localidad l, int pkDepartamento) throws ServiciosException;
	List<Localidad> obtenerLocalidadesPorDepartamento(NDepartamentos departamentoEnum) throws ServiciosException;
	Localidad findForMerge(Long pk) throws ServiciosException;
}
