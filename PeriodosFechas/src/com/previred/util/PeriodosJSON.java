package com.previred.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.previred.exception.PeriodosException;

public class PeriodosJSON {

	/**
	 * @author Jemiliani
	 * @param periodos un array list de periodos de fecha
	 * @return un JSON con con el tag fechasFaltantes y el periodo de fechas que faltan
	 * */
	public static JSONObject convertirJSON(ArrayList<String> periodos) throws JSONException {
		JSONObject jPeriodos = new JSONObject();
		
		jPeriodos.put("fechasFaltantes", periodos);
		
		return jPeriodos;
	}
	
	/**
	 * @author JEmiliani
	 * @param ruta, la ruta con el nombre del archivo a cargar
	 * @return un String con el JSON ingresado por el usuario
	 * */
	public static String cargarArchivoJSON(String ruta) {
		String json = "";
		String linea = "";
		boolean bandera = false;
		File archivoJson = new File(ruta);
		FileReader fr= null;
		try {
			fr = new FileReader(archivoJson);
			BufferedReader br = new BufferedReader(fr);
			while ((linea = br.readLine())!=null) {
				bandera = true;
				json = json + linea; 
			}
			br.close();
			if(!bandera) {
				throw new PeriodosException("Archivo de Entrada Vacio!!!");
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally {
			try {
				if(null != fr) {
					fr.close();
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return json;
	}
	
	/*
	 * Utilizado para pruebas internas
	 * **/
	public static JSONObject RespuestaAPI() throws JSONException{
		JSONObject jPeriodos = new JSONObject();
		
		ArrayList<String> pe = new ArrayList<String>();
		pe.add("1960-03-01");
		pe.add("1969-03-01");
		pe.add("1969-05-01");
		pe.add("1969-09-01");
		pe.add("1970-01-01");
		
		jPeriodos.put("id", 6);
		jPeriodos.put("fechaCreacion", "1960-03-01");
		jPeriodos.put("fechaFin", "1970-01-01");
		jPeriodos.put("fechas", pe);
		
		return jPeriodos;
	}
	
	/**
	 * @author JEmiliani
	 * @param jsonFechas, un objeto JSONObject con las fechas
	 * @return un ArrayList con las fechas del JSON
	 * */	
	public static ArrayList<String> jsonToArray(JSONObject jsonFechas) throws JSONException{
		
		JSONArray jsonArray = jsonFechas.getJSONArray("fechas");
		
		ArrayList<String> list = new ArrayList<String>();
		if(jsonArray != null) {
			for( int i = 0; i < jsonArray.length(); i++) {
				list.add(jsonArray.get(i).toString());
			}
			
		}
		return list;
	}
	
}
