package GUI;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



/**
 * 
 * Permite obtener un objeto tipo BefferedImage java.awt.image.BufferedImage En
 * el constructor se le puede pasar la ruta completa hasta el fichero.
 * 
 */
public class ImagenExtendida {

	private Image imagen=null;

	public ImagenExtendida(int ancho, int largo, int tipo) {
		imagen = new BufferedImage (ancho, largo, tipo);
	}
	
	public Image obtenerImagen(){
		return imagen;
	}

	public ImagenExtendida(String rutaImagen) {
		imagen = cargarImagenDesdeArchivo(rutaImagen);
	}

	/*
	     * 
	     */
	public Image cargarImagenDesdeArchivo(String rutaImagen) {
	//	if (rutaImagen!=null){
			try {
				imagen = ImageIO.read(new File(rutaImagen));
			} catch (IOException ex) {
				System.out.println("Imagen.java: " + ex.getMessage());
				imagen = null;
			}
		//}
		return imagen;
	}

	public Image ObtenerImagen() {
		return imagen;
	}


}
