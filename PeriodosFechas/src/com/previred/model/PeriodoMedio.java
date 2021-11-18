package com.previred.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

/*
 * @author JEmiliani
 * 
 * Clase que Obtiene el periodo de fechas entre los años > fechaCreacion 
 * y años < de la fechaFin.
 * 
 * **/

public class PeriodoMedio extends Periodo{

	
	private int ano;
    
	
	public PeriodoMedio(String fechaInicio, String fechaFin) {
		this.setFechaCreacion(fechaInicio);
		this.setFechaFin(fechaFin);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			cal.setTime(sdf.parse(fechaInicio));
			this.ano = cal.get(Calendar.YEAR);
			this.setAnoDif(this.calcularAnos());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

	@Override
	public void obtenerPeriodo() {
		// TODO Auto-generated method stub
		ArrayList<String> pM = new ArrayList<String>();
		if (this.getAnoDif() > 0) {
			IntStream.range(1, this.getAnoDif()).forEach( i -> {
				IntStream.range(1, 13).forEach(j -> {
					String m = j < 10 ? "0"+j : j+"";
					pM.add((this.ano+i)+"-"+m+"-"+"01");
				});
		    
		    
			});
			
		}
		this.setPeriodos(pM);

		
	}

}
