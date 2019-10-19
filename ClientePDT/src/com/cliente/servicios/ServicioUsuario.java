package com.cliente.servicios;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.entities.Usuario;
import com.enumerados.CDocumento;
import com.enumerados.EUsuario;
import com.enumerados.TUsuarios;
import com.exception.ServiciosException;
import com.services.UsuarioBeanRemote;

public class ServicioUsuario {

	public static void main(String[] args) throws NamingException, ServiciosException {


		UsuarioBeanRemote usuarioBean = (UsuarioBeanRemote)
				InitialContext.doLookup("PDT/UsuarioBean!com.services.UsuarioBeanRemote");


	/*	//Creamos un usuario
		Usuario user = new Usuario();
		user.setNombre("Sebastian");
		user.setApellido("Guadagna");
		user.setDireccion("26 de Marzo 3273");
		user.setDoc(CDocumento.CI);            //Campo Enumerado
		user.setDocumento("111111111");
		user.setEmail("sebastianguadagna@gmail.com");
		user.setEstado(EUsuario.HABILITADO);  //Campo Enumerado
		user.setRol(TUsuarios.VOLUNTARIO);    //Campo Enumerado
		user.setUsername("sguadagna");
		user.setPassword("pdt");

		//Alta de un Usuario
		try {
			usuarioBean.altaUsuario(user);
			System.out.println("Se creo exitosamente el usuario: " + user.getUsername());
			System.out.println("********************************************************");


		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		}

*/

		//Modificacion de un usuario
		try {

			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("sebastianguadagna@gmail.com");
			Long valor = usuario_filtro.get(0).getId_usuario();
			Usuario user_m = usuarioBean.findForMerge(valor);
			user_m.setRol(TUsuarios.VOLUNTARIO);
			usuarioBean.modificarUsuario(user_m);
			System.out.println("Se modifico exitosamente el usuario: " + user_m.getUsername());
			System.out.println("********************************************************");

		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
		}


		//Baja logica un Usuario
		try {

			List<Usuario> usuario_filtro = usuarioBean.obtenerPorUsername("sebastianguadagna@gmail.com");
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
