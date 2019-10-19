package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.UsuarioBeanRemote;

public class PipelineUsuarioBean {

	private UsuarioBeanRemote query;
	
	public PipelineUsuarioBean() throws NamingException {
		query = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT/UsuarioBean!com.services.UsuarioBeanRemote");
		}

	public UsuarioBeanRemote getQuery() {
		return query;
	}

	public void setQuery(UsuarioBeanRemote ub) {
		this.query = ub;
	}
}
