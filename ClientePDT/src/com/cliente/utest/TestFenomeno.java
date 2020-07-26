package com.cliente.utest;


import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineFenomenoBean;
import com.entities.Fenomeno;
import com.enumerados.CFenomeno;
import com.exception.ServiciosException;

public class TestFenomeno {

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		
		PipelineFenomenoBean fenomenoQuery = new PipelineFenomenoBean();
		Fenomeno nombre = new Fenomeno();
		
		//DAR DE ALTA  TODOS LOS FENOMENOS
		int i = 1;
		for(CFenomeno n : CFenomeno.values()) {
			nombre.setNombre(n);
			nombre.setCodigo(i);
			fenomenoQuery.getQuery().altaFenomeno(nombre);
			i++;
		}
		
		//BAJAR FENOMENO INCENDIO
		List<Fenomeno> f = fenomenoQuery.getQuery().obtenerPorNombre(CFenomeno.INCENDIO);
		fenomenoQuery.getQuery().bajaFenomeno(f.get(0).getId_fenomeno());
		
		
		//MODIFICAR FENOMENO
		List<Fenomeno> f2 = fenomenoQuery.getQuery().obtenerPorNombre(CFenomeno.HELADA);
		nombre = fenomenoQuery.getQuery().findForMerge(f2.get(0).getId_fenomeno());
		nombre.setTelefono("092677366");
        fenomenoQuery.getQuery().modificarFenomeno(nombre); 
		
	}

}
