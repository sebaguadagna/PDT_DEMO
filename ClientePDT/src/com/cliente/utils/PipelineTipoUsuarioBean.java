package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.TipoUsuarioBeanRemote;

public class PipelineTipoUsuarioBean {

	private TipoUsuarioBeanRemote query;
	
	public PipelineTipoUsuarioBean() throws NamingException {
		this.query  =  (TipoUsuarioBeanRemote) 
				InitialContext.doLookup("PDT/TipoUsuarioBean!com.services.TipoUsuarioBeanRemote");
	}

	public TipoUsuarioBeanRemote getQuery() {
		return query;
	}

	public void setQuery(TipoUsuarioBeanRemote query) {
		this.query = query;
	}
	
	
}
