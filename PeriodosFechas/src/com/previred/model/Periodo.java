package com.previred.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * @author JEmiliani
 * 
 * Clase que posee la informacion basica de un periodo de fechas y que 
 * solicita implementar la logica para obtener un periodo de fechas.
 * **/
public abstract class Periodo {
	private String fechaCreacion;
	private String fechaFin;
	private ArrayList<String> periodos;
	private int anoDif;
	
	public abstract void obtenerPeriodo();	
	
	public ArrayList<String> getPeriodos() {
		return periodos;
	}

	
	public int calcularAnos() {
		StringTokenizer stI = new StringTokenizer(this.fechaCreacion,"-"); 
		StringTokenizer stF = new StringTokenizer(this.fechaFin,"-"); 
		return (Integer.parseInt(stF.nextToken()) - Integer.parseInt(stI.nextToken()));
	}
	
	public void setPeriodos(ArrayList<String> periodos) {
		this.periodos = periodos;
	}

	
	
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public String getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public int getAnoDif() {
		return anoDif;
	}

	public void setAnoDif(int anoDif) {
		this.anoDif = anoDif;
	}


}
