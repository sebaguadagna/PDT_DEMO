package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.ObservacionBeanRemote;

public class PipelineObservacionBean {

	private ObservacionBeanRemote query;
	
	public PipelineObservacionBean() throws NamingException {
		query = (ObservacionBeanRemote)
				InitialContext.doLookup("PDT/ObservacionBean!com.services.ObservacionBeanRemote");
	}

	public ObservacionBeanRemote getQuery() {
		return query;
	}

	public void setQuery(ObservacionBeanRemote query) {
		this.query = query;
	}
	
	
}
