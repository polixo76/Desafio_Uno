package com.previred.util;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author JEmiliani
 * Clase de utilidad para manejar archivos
 * */
public class FileUtils {

	/**
	 * @author JEmiliani
	 * @param archivoSalida, es el archivo donde se dejara la @param dataJson
	 * **/
	public static void crearFile(String archivoSalida, String dataJson) {
		FileWriter file;
		try {
			file = new FileWriter(archivoSalida);
			file.write(dataJson.toString());
			file.flush();
			file.close();	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
