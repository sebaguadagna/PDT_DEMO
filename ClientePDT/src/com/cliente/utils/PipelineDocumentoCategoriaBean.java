package com.cliente.utils;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.services.DocumentoCategoriaBeanRemote;

public class PipelineDocumentoCategoriaBean {

	private DocumentoCategoriaBeanRemote query;
	
	public PipelineDocumentoCategoriaBean() throws NamingException {
		
		query = (DocumentoCategoriaBeanRemote) InitialContext.doLookup("PDT/DocumentoCategoriaBean!com.services.DocumentoCategoriaBeanRemote");
		
	}

	public DocumentoCategoriaBeanRemote getQuery() {
		return query;
	}

	public void setQuery(DocumentoCategoriaBeanRemote query) {
		this.query = query;
	}
	
	
}
