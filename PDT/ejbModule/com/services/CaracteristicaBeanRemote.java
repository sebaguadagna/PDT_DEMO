package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Caracteristica;
import com.exception.ServiciosException;

@Remote
public interface CaracteristicaBeanRemote {

	void altaCaracteristica(Caracteristica cra) throws ServiciosException;
	void bajaCaracteristica(Caracteristica cra) throws ServiciosException;
	void modificarCaracteristica(Caracteristica cra) throws ServiciosException;
	Caracteristica findForMerge(int pk_cra) throws ServiciosException;
	List<Caracteristica> obtenerTodasLasCrs() throws ServiciosException;
	List<Caracteristica> obtenerCrsPorFenomeno(String fenomeno) throws ServiciosException;
	List<Caracteristica> obtenerCrsPKPorFenomeno(String fenomeno, String caracteristica) throws ServiciosException;
}
