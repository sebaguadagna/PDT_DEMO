package com.cliente.utest;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.NamingException;

import com.cliente.utils.PipelineDepartamentoBean;
import com.cliente.utils.PipelineLocalidadBean;
import com.cliente.utils.PipelineObservacionBean;
import com.entities.Caracteristica;
import com.entities.Departamento;
import com.entities.Localidad;
import com.entities.Observacion;
import com.enumerados.CZonas;
import com.enumerados.TipoDato;
import com.exception.ServiciosException;

public class TetObservacion {
	
	public static void main(String[] args) throws NamingException, ServiciosException{
		
//		PipelineDepartamentoBean tablaDpto = new PipelineDepartamentoBean();
//		Departamento dpto = new Departamento();
//		dpto = tablaDpto.getQuery().findForMerge(1);
//		
//		PipelineLocalidadBean tablaLocalidad = new PipelineLocalidadBean();
//		Localidad lc = new Localidad();
//		lc = tablaLocalidad.getQuery().findForMerge(3);
//	
//		Caracteristica c1 = new Caracteristica();
//		c1.setNombre("Cantidad de hogares afectados");
//		c1.setTipoDato(TipoDato.NUMERO);
//		c1.setEtiqueta("8");
//		
//	
//		PipelineObservacionBean tablaObs = new PipelineObservacionBean();
//		Observacion obs = new Observacion();
//		obs.setDepartamento(dpto);
//		obs.setLocalidad(lc);
//		obs.agregarCaracteristica(c1);
//		obs.setValidarExperto(true);
//		Calendar c = Calendar.getInstance();
//		obs.setFechaHora(c.getTime());
//		tablaObs.getQuery().altaObservacion(obs);
//		
//		
//		List<Observacion> obsrvacionesNorte = tablaObs.getQuery().obtenerSinValidar();
//		for(Observacion o : obsrvacionesNorte) {	
//			System.out.print(o.getDescripcion()+ " " + o.getLocalidad().getNombre() );
//		}		
		
		PipelineObservacionBean tablaObs = new PipelineObservacionBean();
		List<Observacion> obs = tablaObs.getQuery().obtenerPorZona(CZonas.NORTE);
		System.out.print(obs.get(0).getDescripcion());
		
	}
	
}
