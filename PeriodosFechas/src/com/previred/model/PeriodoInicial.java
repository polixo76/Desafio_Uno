package com.previred.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.IntStream;

/*
 * @author JEmiliani
 * 
 * Clase que Obtiene el periodo de fechas del año de la fechaInicio
 * 
 * **/

public class PeriodoInicial extends Periodo{

	private int mes;
	private int ano;
	private int mesFinal;
	
	public PeriodoInicial(String fechaInicio, String fechaFin) {
		
		this.setFechaCreacion(fechaInicio);
		this.setFechaFin(fechaFin);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Calendar calF = Calendar.getInstance();
		SimpleDateFormat sdfF = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			cal.setTime(sdf.parse(fechaInicio));
			
			this.mes = cal.get(Calendar.MONTH)+1;
			this.ano = cal.get(Calendar.YEAR);
			calF.setTime(sdfF.parse(fechaFin));
			if(cal.get(Calendar.YEAR) == calF.get(Calendar.YEAR)  ) {
				this.mesFinal = calF.get(Calendar.MONTH)+2;
			}else {
				this.mesFinal = 13; 
			}
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public void obtenerPeriodo() {
		// TODO Auto-generated method stub
		ArrayList<String> pI = new ArrayList<String>();
		
		IntStream.range(this.mes, this.mesFinal).forEach( i -> {
		    String m = i < 10 ? "0"+i : i+"";
		    pI.add(this.ano+"-"+m+"-"+"01");
		});
		this.setPeriodos(pI);
	}

}
