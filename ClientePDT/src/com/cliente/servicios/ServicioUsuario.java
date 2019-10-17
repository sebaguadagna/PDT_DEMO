package com.cliente.servicios;
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
	
		
		//Creamos un usuario (Primer caso de prueba:Alta)
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
		
		try {
			usuarioBean.altaUsuario(user);
			System.out.println("Se creo exitosamente el usuario: " + user.getUsername());
			System.out.println("********************************************************");
			
		} catch (ServiciosException e) {
			System.out.println(e.getMessage());
			}
	}
	
}
