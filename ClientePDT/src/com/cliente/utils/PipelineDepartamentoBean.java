package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.DepartamentoBeanRemote;

public class PipelineDepartamentoBean {

	private DepartamentoBeanRemote query;
	
	public PipelineDepartamentoBean() throws NamingException{
		query = (DepartamentoBeanRemote)
				InitialContext.doLookup("PDT/DepartamentoBean!com.services.DepartamentoBeanRemote");

	}

	public DepartamentoBeanRemote getQuery() {
		return query;
	}

	public void setQuery(DepartamentoBeanRemote query) {
		this.query = query;
	}
	
}
