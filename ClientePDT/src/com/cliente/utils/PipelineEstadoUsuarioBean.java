package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.EstadoUsuarioBeanRemote;


public class PipelineEstadoUsuarioBean {

	private EstadoUsuarioBeanRemote query;

	public PipelineEstadoUsuarioBean() throws NamingException {
		
		query = (EstadoUsuarioBeanRemote) InitialContext.doLookup("PDT/EstadoUsuarioBean!com.services.EstadoUsuarioBeanRemote");		
	}

	public EstadoUsuarioBeanRemote getQuery() {
		return query;
	}

	public void setQuery(EstadoUsuarioBeanRemote query) {
		this.query = query;
	}
	
	
}
