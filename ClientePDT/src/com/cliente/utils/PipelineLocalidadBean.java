package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.LocalidadBeanRemote;

public class PipelineLocalidadBean {
	
	private LocalidadBeanRemote  query;
	
	public PipelineLocalidadBean() throws NamingException {
		
		query = (LocalidadBeanRemote)
				InitialContext.doLookup("PDT/LocalidadBean!com.services.LocalidadBeanRemote");
	}

	public LocalidadBeanRemote getQuery() {
		return query;
	}

	public void setQuery(LocalidadBeanRemote query) {
		this.query = query;
	}
	
	

}
