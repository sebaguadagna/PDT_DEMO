package com.cliente.utest;

import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineDepartamentoBean;
import com.cliente.utils.PipelineZonaBean;
import com.entities.Departamento;
import com.entities.Zona;
import com.enumerados.CZonas;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

public class TestDepartamento {

	public static void main(String[] args) throws NamingException, ServiciosException{
		


		//ZONA ES FK EN LA TABLA DEPARTAMENTO
		PipelineZonaBean zonaQuery = new PipelineZonaBean();
		
		PipelineDepartamentoBean departamentoQuery = new PipelineDepartamentoBean();
		Departamento nombre = new Departamento();
		
		//DAR DE ALTA DEPARTAMENTOS
		String  codigo = "DPTO";
		int valor = 1;
		for(NDepartamentos denum:NDepartamentos.values()) {
			nombre.setNombre(denum);
			nombre.setCodigo(codigo + valor);
			valor ++;
			departamentoQuery.getQuery().altaDepartamento(nombre);
		}
		
//		
//		//MODIFICAR UN DEPARTAMENTO
//		List<Departamento> d = departamentoQuery.getQuery().obtenerPorNombre(NDepartamentos.DURAZNO);
//		nombre = departamentoQuery.getQuery().findForMerge(d.get(0).getId_departamento());
//		List<Zona> z = zonaQuery.getQuery().obtenerPorCategoria(CZonas.CENTRO_SUR);
//		departamentoQuery.getQuery().modificarDepartamentoZona(nombre, z.get(0).getId_zona());
//		
//		
//		//BAJAR DEPARTAMENTO
//		List<Departamento> d2 = departamentoQuery.getQuery().obtenerPorNombre(NDepartamentos.MONTEVIDEO);
//		departamentoQuery.getQuery().bajaDepartamento(d2.get(0).getId_departamento());
//		
//	

		
//		//ZONA ES FK EN LA TABLA DEPARTAMENTO
//		PipelineDepartamentoBean departamentoQuery = new PipelineDepartamentoBean();
//		List<Departamento> d = departamentoQuery.getQuery().obtenerPoZona(CZonas.CENTRO_SUR);
//		System.out.print(d.get(0).getNombre());
		
	}
}
