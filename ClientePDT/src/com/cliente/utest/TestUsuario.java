package com.cliente.utest;
import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineDocumentoCategoriaBean;
import com.cliente.utils.PipelineEstadoUsuarioBean;
import com.cliente.utils.PipelineTipoUsuarioBean;
import com.cliente.utils.PipelineUsuarioBean;
import com.entities.DocumentoCategoria;
import com.entities.EstadoUsuario;
import com.entities.TipoUsuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;



/*
 * No utlizar los unit test de usuario hasta pronto aviso
 */
public class TestUsuario {

	public static void main(String[] args) throws NamingException, ServiciosException {		
		
		PipelineUsuarioBean usuarioTableQuery = new PipelineUsuarioBean();
		PipelineTipoUsuarioBean tipoTableQuery = new PipelineTipoUsuarioBean();
		PipelineEstadoUsuarioBean estadoTableQuery = new PipelineEstadoUsuarioBean();
		PipelineDocumentoCategoriaBean categoriaTableQuery = new PipelineDocumentoCategoriaBean();
		
		List<EstadoUsuario> eu = estadoTableQuery.getQuery().obtenerPorEstado(EUsuario.HABILITADO);
		int estadoPK = 0;
		for(EstadoUsuario e: eu) {
			estadoPK = e.getId_estado_usuario();
		}
		
		List<DocumentoCategoria> dc = categoriaTableQuery.getQuery().obtenerPorCategoria(CDocumento.CI);
		int categoriaDocumentoPK = 0;
		for(DocumentoCategoria d : dc) {
			categoriaDocumentoPK = d.getId_docu_categoria();
		}
		
		List<TipoUsuario> tu = tipoTableQuery.getQuery().obtenerPorRol(TUsuarios.EXPERTO);
		int rolPK = 0;
		for(TipoUsuario t: tu) {
			rolPK = t.getId_tipo_usuario();
		}
		
		
		//Creamos un usuario
		usuarioTableQuery.getQuery().altaUsuario("Sebastian", "Guadagna", "Av italia 4081", categoriaDocumentoPK, "34568", 
				"sebastianguadagna@gmail.com", estadoPK, rolPK, "sguadagna", "sguadagna");


//		//Modificacion de un usuario
//		try {
//
//			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("lavenganzaseraterrible@gmail.com");
//			Long valor = usuario_filtro.get(0).getId_usuario();
//			Usuario user_m = usuarioBean.findForMerge(valor);
//			user_m.setRol(TUsuarios.EXPERTO);
//			usuarioBean.modificarUsuario(user_m);
//			System.out.println("Se modifico exitosamente el usuario: " + user_m.getUsername());
//			System.out.println("********************************************************");
//
//		} catch (ServiciosException e) {
//			System.out.println(e.getMessage());
//		}
//
//
//		//Baja logica un Usuario
//		try {
//
//			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("lavenganzaseraterrible@gmail.com");
//			Long valor = usuario_filtro.get(0).getId_usuario();
//			Usuario user_m = usuarioBean.findForMerge(valor);
//			user_m.setEstado(EUsuario.DESHABILITADO);
//			usuarioBean.modificarUsuario(user_m);
//			System.out.println("Se bajo exitosamente el usuario: " + user_m.getUsername());
//			System.out.println("********************************************************");
//
//		} catch (ServiciosException e) {
//			System.out.println(e.getMessage());
//		}


	}

}
