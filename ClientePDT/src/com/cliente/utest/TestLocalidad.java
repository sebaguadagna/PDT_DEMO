package com.cliente.utest;

import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineDepartamentoBean;
import com.cliente.utils.PipelineLocalidadBean;
import com.entities.Departamento;
import com.entities.Localidad;
import com.enumerados.NDepartamentos;
import com.exception.ServiciosException;

public class TestLocalidad {

	public static void main(String[] args) throws NamingException, ServiciosException {
		
		//DEPARTAMENTO FK EN LA TABLA LOCALIDAD
		PipelineDepartamentoBean departamentoQuery = new PipelineDepartamentoBean();
        List<Departamento> listd = departamentoQuery.getQuery().obtenerPorNombre(NDepartamentos.CANELONES);
        Departamento d = departamentoQuery.getQuery().findForMerge(listd.get(0).getId_departamento());

        
		PipelineLocalidadBean localidadQuery = new PipelineLocalidadBean();
        Localidad l = new Localidad();
        
        //DAR DE ALTA LOCALIDAD
        l.setNombre("Lagomar - Ciudad de la costa");
        l.setDepartamento(d);
        localidadQuery.getQuery().altaLocalidad(l);
        
        
        //LISTAR  TODOS LAS LOCALIDADES POR DEPARTAMENTO
        List<Localidad> ll = localidadQuery.getQuery().obtenerLocalidadesPorDepartamento(NDepartamentos.CANELONES);
        for(Localidad lo: ll) {
        	System.out.println("Estas son las localidades del departamento de Canelones: " + lo.getNombre());
        }
        		
        		
	}

}
