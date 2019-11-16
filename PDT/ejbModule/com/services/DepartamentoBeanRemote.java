package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.enumerados.CZonas;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

@Remote
public interface DepartamentoBeanRemote {

	void altaDepartamento(Departamento nombre) throws ServiciosException;
	void altaDepartamento(Departamento nombre, int zonaPK) throws ServiciosException;
	void bajaDepartamento(int pk) throws ServiciosException;
	void modificarDepartamentoZona(Departamento d, int pkZona) throws ServiciosException;
	List<Departamento> obtenerPorNombre(NDepartamentos departamentoEnum) throws ServiciosException;
	List<Departamento> obtenerPoZona(CZonas zona) throws ServiciosException;
	List<Departamento> obtenerTodos() throws ServiciosException;
	Departamento findForMerge(int pk) throws ServiciosException;
}
