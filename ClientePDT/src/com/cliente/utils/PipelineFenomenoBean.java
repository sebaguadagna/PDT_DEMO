package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.FenomenoBeanRemote;

public class PipelineFenomenoBean {

private FenomenoBeanRemote query;
	
	public PipelineFenomenoBean() throws NamingException {
		query = (FenomenoBeanRemote)
				InitialContext.doLookup("PDT/FenomenoBean!com.services.FenomenoBeanRemote");
		}

	public FenomenoBeanRemote getQuery() {
		return query;
	}

	public void setQuery(FenomenoBeanRemote query) {
		this.query = query;
	}
	
	
	
}
