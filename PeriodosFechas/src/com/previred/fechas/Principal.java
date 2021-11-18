package com.previred.fechas;


import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.previred.controller.FechasFaltantes;
import com.previred.exception.PeriodosException;
import com.previred.model.PeriodoFinal;
import com.previred.model.PeriodoInicial;
import com.previred.model.PeriodoMedio;
import com.previred.util.FileUtils;
import com.previred.util.PeriodosJSON;

public class Principal {

	public static void main(String[] args) throws PeriodosException {
		// TODO Auto-generated method stub
		
		JSONObject periodosJSON = null;
		JSONObject peridosoResultJSON = null;
		try {
			
			if(args.length < 2 || args.length > 2) {
		            
		            throw new com.previred.exception.PeriodosException("Debe ingresar la ruta del archivo de entrada y de salida: EJ. c:\\entrada.json c:\\salida.json");
			}
			
		    String archivoEntrada = "";
		    String archivoSalida = "";
		    archivoEntrada = args[0];
		    archivoSalida = args[1];
		        
			periodosJSON = new JSONObject(PeriodosJSON.cargarArchivoJSON(archivoEntrada));
			peridosoResultJSON  = new JSONObject(PeriodosJSON.cargarArchivoJSON(archivoEntrada));
			
			PeriodoInicial pi = new PeriodoInicial(periodosJSON.getString("fechaCreacion"),periodosJSON.getString("fechaFin"));
			
		
			
		
			PeriodoFinal pf = new PeriodoFinal(periodosJSON.getString("fechaCreacion"),periodosJSON.getString("fechaFin"));
		
		
			PeriodoMedio pm = new PeriodoMedio(periodosJSON.getString("fechaCreacion"),periodosJSON.getString("fechaFin"));
			pi.obtenerPeriodo();
			pf.obtenerPeriodo();
			pm.obtenerPeriodo();
			
			ArrayList<String> periodos = pi.getPeriodos();
			periodos.addAll(pm.getPeriodos());
			periodos.addAll(pf.getPeriodos());

		
			JSONObject jo = periodosJSON;
			
			new FechasFaltantes(periodos,PeriodosJSON.jsonToArray(jo));
			
			peridosoResultJSON.remove("fechas");
			peridosoResultJSON.put("fechasFaltantes",periodos);
			
			
			FileUtils.crearFile(archivoSalida, peridosoResultJSON.toString());
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}

}
