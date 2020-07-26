package com.cliente.utest;

import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineZonaBean;
import com.entities.Zona;
import com.enumerados.CZonas;
import com.exception.ServiciosException;

public class TestZona {

	public static void main(String[] args) throws NamingException, ServiciosException{


		PipelineZonaBean zonaQuery = new PipelineZonaBean();
		Zona categoria = new Zona();
		
		//DAR ALTA TODAS LAS ZONA
		for(CZonas z : CZonas.values()) {
			categoria.setCategoria(z);
			zonaQuery.getQuery().altaZona(categoria);
		}
		
		//BAJAR ZONA METROPOLITANA
		List<Zona> f = zonaQuery.getQuery().obtenerPorCategoria(CZonas.METROPOLITANA);
		zonaQuery.getQuery().bajaZona(f.get(0).getId_zona());
		
		
		//MODIFICAR ZONA
		//NO tiene sentido modificar este campo ya que cuenta con un solo atributo enumerado que es el nombre de la ZONA
		//Si fueramos a agregar otra categoria mas a Zonas es necesario unicamente agregarlo en los enumerados del Bean.
	
	}

}
