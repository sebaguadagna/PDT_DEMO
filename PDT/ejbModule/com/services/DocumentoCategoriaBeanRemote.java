package com.services;

import java.util.List;

import javax.ejb.Remote;

import com.entities.DocumentoCategoria;
import com.enumerados.CDocumento;
import com.exception.ServiciosException;

@Remote
public interface DocumentoCategoriaBeanRemote {
	

	void altaDocumentoCategoria(DocumentoCategoria categoria) throws ServiciosException;
	void bajaDocumentoCategoria(DocumentoCategoria categoria) throws ServiciosException;
	void modificarDocumentoCategoria(DocumentoCategoria categoria) throws ServiciosException;
	List<DocumentoCategoria> obtenerPorCategoria(CDocumento categoriaEnum) throws ServiciosException;
	List<DocumentoCategoria> obtenerTodos() throws ServiciosException;
	DocumentoCategoria findForMerge(int pk) throws ServiciosException;


}
