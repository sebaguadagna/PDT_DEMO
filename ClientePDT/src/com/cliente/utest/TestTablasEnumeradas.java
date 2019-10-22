package com.cliente.utest;

import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineDocumentoCategoriaBean;
import com.cliente.utils.PipelineEstadoUsuarioBean;
import com.cliente.utils.PipelineTipoUsuarioBean;
import com.entities.DocumentoCategoria;
import com.entities.EstadoUsuario;
import com.entities.TipoUsuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;

public class TestTablasEnumeradas {


	public static void main(String[] args) throws NamingException, ServiciosException {
		

		PipelineEstadoUsuarioBean estadoUsuarioQuery = new PipelineEstadoUsuarioBean();
		EstadoUsuario estado = new EstadoUsuario();
		estado.setEstadoNombre(EUsuario.DESHABILITADO);
		estadoUsuarioQuery.getQuery().altaEstado(estado);
		estado.setEstadoNombre(EUsuario.HABILITADO);
		estadoUsuarioQuery.getQuery().altaEstado(estado);
		List<EstadoUsuario> eu = estadoUsuarioQuery.getQuery().obtenerPorEstado(EUsuario.HABILITADO);
		System.out.print(eu.get(0).getId_estado_usuario());
		
		PipelineTipoUsuarioBean tipoUsuarioQuery = new PipelineTipoUsuarioBean();
		TipoUsuario rol = new TipoUsuario();
		rol.setRol(TUsuarios.ADMINISTRADOR);
		tipoUsuarioQuery.getQuery().altaTipoUsuario(rol);
		rol.setRol(TUsuarios.EXPERTO);
		tipoUsuarioQuery.getQuery().altaTipoUsuario(rol);
		rol.setRol(TUsuarios.VOLUNTARIO);
		tipoUsuarioQuery.getQuery().altaTipoUsuario(rol);
		List<TipoUsuario> tu = tipoUsuarioQuery.getQuery().obtenerPorRol(TUsuarios.ADMINISTRADOR);
		System.out.print(tu.get(0).getId_tipo_usuario());
		
		
		PipelineDocumentoCategoriaBean documentoCategoriaQuery = new PipelineDocumentoCategoriaBean();
		DocumentoCategoria categoria = new DocumentoCategoria();
		for(CDocumento c : CDocumento.values()) {
			categoria.setCategoriaNombre(c);
			documentoCategoriaQuery.getQuery().altaDocumentoCategoria(categoria);
		}
		
	}
}