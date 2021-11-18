package com.previred.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.IntStream;

/*
 * @author JEmiliani
 * 
 * Clase que Obtiene el periodo de fechas del año de la fechaFin.
 * 
 * **/
public class PeriodoFinal extends Periodo{
	private int mes;
	private int ano;
    
	
	public PeriodoFinal( String fechaInicio, String fechaFin) {
		this.setFechaCreacion(fechaInicio);
		this.setFechaFin(fechaFin);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			cal.setTime(sdf.parse(fechaFin));
			this.mes = cal.get(Calendar.MONTH)+1;
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
		ArrayList<String> pF = new ArrayList<String>();
		if(this.getAnoDif() > 0) {
			IntStream.range(1, this.mes+1).forEach( i -> {
				String m = i < 10 ? "0"+i : i+"";
				pF.add(this.ano+"-"+m+"-"+"01");
			});
		}
		this.setPeriodos(pF);

		
	}


}
