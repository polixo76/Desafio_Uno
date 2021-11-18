package com.previred.controller;

import java.util.ArrayList;

public class FechasFaltantes {
		
	private ArrayList<String> fechasFaltantes;
	
	public FechasFaltantes(ArrayList<String> fechasTotales, ArrayList<String> fechasRecibidas){
		
		fechasFaltantes = new ArrayList<String>();
		fechasTotales.removeAll(fechasRecibidas);
		this.fechasFaltantes =  fechasTotales;
	}

}
