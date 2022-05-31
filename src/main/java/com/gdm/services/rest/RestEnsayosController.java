package com.gdm.services.rest;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gdm.commons.beans.EnsayoMapa;
import com.gdm.commons.beans.FichaEnsayo;
import com.gdm.entities.Ensayo;
import com.gdm.repository.dao.intefaces.IEnsayoRepository;

@RestController
@RequestMapping("/ensayos")
public class RestEnsayosController {

	@Autowired
	IEnsayoRepository servicio;

	@GetMapping
	public List<EnsayoMapa> listar() throws ParseException {
		List<Ensayo> tmp = (List<Ensayo>) servicio.findbyAllParams("DMMAS");

		Iterator ite = tmp.iterator();
		FichaEnsayo f = null;
		List<EnsayoMapa> ensayos = new ArrayList<EnsayoMapa>();
		Ensayo ensayo = null;
		String ensayoActual = "";
		boolean ensayoCompleto = false;
		EnsayoMapa enM = null;
		procesarRedDMMAS(ite, f, ensayos, ensayoActual, ensayoCompleto, enM);
	    this.procesarRedTerceros(ensayos);
		return ensayos;
	}

	private void procesarRedDMMAS(Iterator ite, FichaEnsayo f, List<EnsayoMapa> ensayos, String ensayoActual, boolean ensayoCompleto, EnsayoMapa ensayoMapa)  {
		Ensayo ensayo;
		
		int i = 0;
		while (ite.hasNext()) {
			ensayo = (Ensayo) ite.next();
			if ( !ensayoActual.equals(ensayo.getEnsayo())) {
				if(i>0) {
					ensayos.add(ensayoMapa);
					i = 0;
				}
				ensayoActual = ensayo.getEnsayo();
				ensayoMapa = new EnsayoMapa();
				f = null;
				if(f==null ) {
					f = new FichaEnsayo();
					ensayoMapa.getEnsayo().setId(ensayo.getId());
					ensayoMapa.getEnsayo().setPais(ensayo.getPais());
					ensayoMapa.getEnsayo().setCultivo(ensayo.getCultivo());
					ensayoMapa.getEnsayo().setCampania(ensayo.getCampania());
					ensayoMapa.getEnsayo().setEpoca(ensayo.getEpoca());
					ensayoMapa.getEnsayo().setCoordenadaEnsayo_1(ensayo.getCoordenadaEnsayo_1());
					ensayoMapa.getEnsayo().setCoordenadaEnsayo_2(ensayo.getCoordenadaEnsayo_2());
					ensayoMapa.getEnsayo().setTipoDeREd(ensayo.getTipode_red());
					ensayoMapa.getEnsayo().setKey(ensayo.getEnsayo());
					
					//INICIALIZO EL ENSAYO CON LA LOCALIDAD, CAMPANIA, FECHA_SIEMBRA
					
					ensayoMapa.getFichaEnsayo().getAtributos().put("RED", "DMMAS");
					ensayoMapa.getFichaEnsayo().getAtributos().put("Localidad", ensayo.getLocalidad());
					ensayoMapa.getFichaEnsayo().getAtributos().put("Micro Region", ensayo.getMicroRegion());
					ensayoMapa.getFichaEnsayo().getAtributos().put("Campañia", ensayo.getCampania());
					ensayoMapa.getFichaEnsayo().getAtributos().put("Firma", ensayo.getFirma());
					ensayoMapa.getFichaEnsayo().getAtributos().put("Fecha de Siembra", ensayo.getFechaSiembra());
					ensayoMapa.getFichaEnsayo().getAtributos().put("Antecesor", ensayo.getAntecesor());
					
					f.getAtributos().put("Rendimiento Promedio del Ensayo (kg/ha)", ensayo.getPromedio_ensayo());	
					f.getAtributos().put("Producto", "Rendimiento (kg/ha)");
					f.getAtributos().put(ensayo.getGenotipo(), ensayo.getRendimiento().toString());
						
					ensayoMapa.getFichaEnsayo().getAtributos().put("Ranking 5 Mejores Productos evaluados", f.getAtributos());
					i++;
				}
			
			}else {
					if(f.getAtributos().size() < 7) {	
						i++;
						f.getAtributos().put(ensayo.getGenotipo(), ensayo.getRendimiento().toString());
					}
				}
		
		}
		if(! ite.hasNext()) {
			ensayos.add(ensayoMapa);
		}
		
	}

	/**
	 * @param ensayos
	 */
	public void procesarRedTerceros(List<EnsayoMapa> ensayos) {
		List<Ensayo> tmp = (List<Ensayo>) servicio.findbyAllParams("TERCEROS");
		Iterator ite = tmp.iterator();
		FichaEnsayo f = null;
		Ensayo ensayo = null;
		String ensayoActual = "";
		EnsayoMapa ensayoMapa = null;
		int i = 0;
	    LinkedHashMap<Integer,Integer> tercerUnaOcu = new LinkedHashMap<Integer,Integer>();
	   // tercerUnaOcu.put(4888,4888);tercerUnaOcu.put(9167,9167);tercerUnaOcu.put(9168,9168);tercerUnaOcu.put(9541,9541);tercerUnaOcu.put(41207,41207);
		while (ite.hasNext()) {
			ensayo = (Ensayo) ite.next();
		//	if( tercerUnaOcu.containsKey(ensayo.getId().intValue())) {
			 
				if ( !ensayoActual.equals(ensayo.getEnsayo())) {
					if(i>0) {
						ensayos.add(ensayoMapa);
						i = 0;
					}
					
					ensayoActual = ensayo.getEnsayo();
					ensayoMapa = new EnsayoMapa();
					f = null;
					if(f==null ) {
						f = new FichaEnsayo();
						ensayoMapa.getEnsayo().setId(ensayo.getId());
						ensayoMapa.getEnsayo().setPais(ensayo.getPais());
						ensayoMapa.getEnsayo().setCultivo(ensayo.getCultivo());
						ensayoMapa.getEnsayo().setCampania(ensayo.getCampania());
						ensayoMapa.getEnsayo().setEpoca(ensayo.getEpoca());
						ensayoMapa.getEnsayo().setCoordenadaEnsayo_1(ensayo.getCoordenadaEnsayo_1());
						ensayoMapa.getEnsayo().setCoordenadaEnsayo_2(ensayo.getCoordenadaEnsayo_2());
						ensayoMapa.getEnsayo().setTipoDeREd(ensayo.getTipode_red());
						ensayoMapa.getEnsayo().setKey(ensayo.getEnsayo());
						
					
						//INICIALIZO EL ENSAYO CON LA LOCALIDAD, CAMPANIA, FECHA_SIEMBRA
						ensayoMapa.getFichaEnsayo().getAtributos().put("RED", ensayo.getRed_zonal());
						ensayoMapa.getFichaEnsayo().getAtributos().put("Localidad", ensayo.getLocalidad());
						ensayoMapa.getFichaEnsayo().getAtributos().put("Micro Region", ensayo.getMicroRegion());
						ensayoMapa.getFichaEnsayo().getAtributos().put("Campañia", ensayo.getCampania());
						ensayoMapa.getFichaEnsayo().getAtributos().put("Fecha de Siembra", ensayo.getFechaSiembra());
						f.getAtributos().put("Rendimiento Promedio del Ensayo (kg/ha)", ensayo.getPromedio_ensayo());	
							
						f.getAtributos().put("Producto", "Rendimiento (kg/ha)");
						f.getAtributos().put(ensayo.getGenotipo(), ensayo.getRendimiento().toString());
							
						ensayoMapa.getFichaEnsayo().getAtributos().put("Ranking Mejores Productos evaluados", f.getAtributos());
						i++;
					}
				
				}else {
						i++;
						f.getAtributos().put(ensayo.getGenotipo(), ensayo.getRendimiento().toString());
					}
			//}
					
		}
		if(! ite.hasNext()) {
			ensayos.add(ensayoMapa);
		}
		
	}	
}