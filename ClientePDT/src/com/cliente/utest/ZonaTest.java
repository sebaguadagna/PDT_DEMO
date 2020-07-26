package com.cliente.utest;

import javax.naming.NamingException;

import com.cliente.utils.PipelineZonaBean;
import com.entities.Zona;
import com.exception.ServiciosException;

public class ZonaTest {

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		PipelineZonaBean zona = new PipelineZonaBean();
		for(Zona z : zona.getQuery().obtenerTodos()) System.out.print("Nombre de la Zona: " + z.getCategoria());

	}

}
