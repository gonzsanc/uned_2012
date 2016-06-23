package Ficheros;

import java.io.*;

public final class RutinasComunes {

	public static String ObtenerRutaAplicacion() {
		File currentDir = new File("");
		String directorio = currentDir.getAbsolutePath() ;
		directorio = directorio.replace("\\", "/");
		
		if (directorio.indexOf("clipse")!=-1){
			directorio+="/src";
		}
		directorio +="/";
		
		return directorio;
	}

	public static String ObtenerURLAplicacion() {
		File currentDir = new File("");
		String directorio = currentDir.getAbsolutePath();
		directorio = directorio.replace("\\", "/");
		
		if (directorio.indexOf("clipse")!=-1){
			directorio+="/src";
		}
		directorio +="/";
		
		return directorio;
	}

}
