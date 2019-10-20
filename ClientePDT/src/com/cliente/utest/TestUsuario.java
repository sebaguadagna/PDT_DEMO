package com.cliente.utest;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.entities.Usuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;
import com.services.UsuarioBeanRemote;

public class TestUsuario {

	public static void main(String[] args) throws NamingException, ServiciosException {


		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT/UsuarioBean!com.services.UsuarioBeanRemote");


//		//Creamos un usuario
//		Usuario user = new Usuario();
//		user.setNombre("Alejandro");
//		user.setApellido("Dolina");
//		user.setDireccion("Buenos Aires");
//		user.setDoc(CDocumento.PASAPORTE);            //Campo Enumerado
//		user.setDocumento("8903033DD");
//		user.setEmail("lavenganzaseraterrible@gmail.com");
//		user.setEstado(EUsuario.HABILITADO);  //Campo Enumerado
//		user.setRol(TUsuarios.ADMINISTRADOR);    //Campo Enumerado
//		user.setUsername("adolina");
//		user.setPassword("dolina");
//
//		//Alta de un Usuario
//		try {
//			usuarioBean.altaUsuario(user);
//			System.out.println("Se creo exitosamente el usuario: " + user.getUsername());
//			System.out.println("********************************************************");
//
//
//		} catch (ServiciosException e) {
//			System.out.println(e.getMessage());
//		}



		//Modificacion de un usuario
		try {

			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("lavenganzaseraterrible@gmail.com");
			Long valor = usuario_filtro.get(0).getId_usuario();
			Usuario user_m = usuarioBean.findForMerge(valor);
			user_m.setRol(TUsuarios.EXPERTO);
			usuarioBean.modificarUsuario(user_m);
			System.out.println("Se modifico exitosamente el usuario: " + user_m.getUsername());
			System.out.println("********************************************************");

		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		}


		//Baja logica un Usuario
		try {

			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("lavenganzaseraterrible@gmail.com");
			Long valor = usuario_filtro.get(0).getId_usuario();
			Usuario user_m = usuarioBean.findForMerge(valor);
			user_m.setEstado(EUsuario.DESHABILITADO);
			usuarioBean.modificarUsuario(user_m);
			System.out.println("Se bajo exitosamente el usuario: " + user_m.getUsername());
			System.out.println("********************************************************");

		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		}


	}

}
