package com.test;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.entities.Departamento;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;
import com.services.DepartamentoBeanRemote;

public class Prueba {

	public static void main(String[] args) throws NamingException, ServiciosException {

		DepartamentoBeanRemote query = (DepartamentoBeanRemote)
				InitialContext.doLookup("PDT/DepartamentoBean!com.services.DepartamentoBeanRemote");
		
		
		Departamento nombre = new Departamento();
		
		nombre.setCodigo("RIO");
		nombre.setNombre(NDepartamentos.RIO_NEGRO);
		
		query.altaDepartamento(nombre);
	}

}

