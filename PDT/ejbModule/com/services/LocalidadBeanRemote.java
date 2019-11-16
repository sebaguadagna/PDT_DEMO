package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Localidad;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

@Remote
public interface LocalidadBeanRemote {

	
	void altaLocalidad(Localidad nombre) throws ServiciosException;
	void bajaLocalidad(int pk) throws ServiciosException;
	void modificarLocalidadDepartamento(Localidad l, int pkDepartamento) throws ServiciosException;
	List<Localidad> obtenerLocalidadesPorDepartamento(NDepartamentos departamentoEnum) throws ServiciosException;
	List<Localidad> obtenerLocalidadesPorPk(NDepartamentos departamentoEnum, String lc) throws ServiciosException;
	Localidad findForMerge(int pk) throws ServiciosException;
}
