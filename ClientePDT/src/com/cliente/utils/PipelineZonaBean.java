package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.ZonaBeanRemote;

public class PipelineZonaBean {

	private ZonaBeanRemote query;
	
	public PipelineZonaBean() throws NamingException{
		query = (ZonaBeanRemote)
				InitialContext.doLookup("PDT/ZonaBean!com.services.ZonaBeanRemote");
	}

	public ZonaBeanRemote getQuery() {
		return query;
	}

	public void setQuery(ZonaBeanRemote query) {
		this.query = query;
	}
	
	
	
}
