package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.services.DetalleBeanRemote;

public class PipelineDetalleBean {

	private DetalleBeanRemote query;
	
	public PipelineDetalleBean() throws  NamingException{
		setQuery((DetalleBeanRemote)
				InitialContext.doLookup("PDT/DetalleBean!com.services.DetalleBeanRemote"));

	}

	public DetalleBeanRemote getQuery() {
		return query;
	}

	public void setQuery(DetalleBeanRemote query) {
		this.query = query;
	}
}
