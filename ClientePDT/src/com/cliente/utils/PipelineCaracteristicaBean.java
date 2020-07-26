package com.cliente.utils;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.CaracteristicaBeanRemote;

public class PipelineCaracteristicaBean {

	private CaracteristicaBeanRemote query;
	
	public PipelineCaracteristicaBean() throws  NamingException{
		setQuery((CaracteristicaBeanRemote)
				InitialContext.doLookup("PDT/CaracteristicaBean!com.services.CaracteristicaBeanRemote"));

	}

	public CaracteristicaBeanRemote getQuery() {
		return query;
	}

	public void setQuery(CaracteristicaBeanRemote query) {
		this.query = query;
	}
	
	
}
