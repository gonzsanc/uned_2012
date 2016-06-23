//Adaptado de: http://www.java-tips.org/java-se-tips/java.io/list-the-names-of-all-files-in-a-particular-dire.html

package Ficheros;

import java.io.File;
import java.util.ArrayList;

public class DirectoryReader {

	public DirectoryReader() {
	}

	public ArrayList<String> obtenerFicherosConRuta(String ruta,
			String extension) {
		ArrayList<String> ListadoFicheros = new ArrayList<String>();

		File folder = new File(ruta);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()
					&& listOfFiles[i].getName().endsWith("." + extension)) {
				ListadoFicheros.add(ruta + listOfFiles[i].getName());
			}
		}
		return ListadoFicheros;
	}

}