package datos;

import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.imageio.ImageIO;

import datos.enumerados.TiposVehiculos;

public class DefinicionPiezaImagenes implements IDefinicionPieza {
	
	/* Imagenes de las piezas del juego */
	private static ArrayList<BufferedImage> imagenes_marciano10 = null;
	private static ArrayList<BufferedImage> imagenes_marciano20;
	private static ArrayList<BufferedImage> imagenes_marciano40;
	private static ArrayList<BufferedImage> imagenes_Bomba_Marciano;

	private static ArrayList<BufferedImage> imagenes_rayoLaserBueno;
	private static ArrayList<BufferedImage> imagenes_naveBuena;
	private static ArrayList<BufferedImage> imagenes_explosion;
	
	private static ArrayList<String> rutas_imagenes_marciano10;
	private static ArrayList<String> rutas_imagenes_marciano20;
	private static ArrayList<String> rutas_imagenes_marciano40;
	private static ArrayList<String> rutas_imagenes_Bomba_Marciano;

	private static ArrayList<String> rutas_imagenes_rayoLaserBueno;
	private static ArrayList<String> rutas_imagenes_naveBuena;
	private static ArrayList<String> rutas_imagenes_explosion;
	

	/* Rutas a las imagenes de las piezas del juego */
	private static String rutaImagenMarciano10_1;
	private static String rutaImagenMarciano10_2;
	private static String rutaImagenMarciano20_1;
	private static String rutaImagenMarciano20_2;
	private static String rutaImagenMarciano40_1;
	private static String rutaImagenMarciano40_2;

	private static String rutaImagenBomba;
	private static String rutaImagenRayoLaserBueno;
	private static String rutaImagenExplosion;

	private static String rutaImagenNaveBuena;

	private static final Dimension tamanoImagenMoviles = new Dimension(28, 24);

	/* Inicializador est�tico de clase */
	private static void inicializar() {
		//Incluir un new para cada array de imágenes.

		String DirRaiz = Ficheros.RutinasComunes.ObtenerRutaAplicacion();
		String rutaImagenes = DirRaiz + DirImagenes;
		inicializarArrayLists();
		
		rutaImagenMarciano10_1 = rutaImagenes + "nave_1_01.png";
		rutaImagenMarciano10_2 = rutaImagenes + "nave_1_02.png";
		rutaImagenMarciano20_1 = rutaImagenes + "nave_3_01.png";
		rutaImagenMarciano20_2 = rutaImagenes + "nave_3_02.png";
		rutaImagenMarciano40_1 = rutaImagenes + "nave_2_01.png";
		rutaImagenMarciano40_2 = rutaImagenes + "nave_2_02.png";

		rutaImagenBomba = rutaImagenes + "bomba.png";
		rutaImagenRayoLaserBueno = rutaImagenes + "misil.png";
		rutaImagenExplosion = rutaImagenes + "explosion.png";

		rutaImagenNaveBuena = rutaImagenes + "defensora.png";

		/* Asignar las imagenes a las naves invasoras */
		agregarImagenAPieza(imagenes_marciano10, rutaImagenMarciano10_1);
		agregarImagenAPieza(imagenes_marciano10, rutaImagenMarciano10_2);
		agregarImagenAPieza(imagenes_marciano20, rutaImagenMarciano20_1);
		agregarImagenAPieza(imagenes_marciano20, rutaImagenMarciano20_2);
		agregarImagenAPieza(imagenes_marciano40, rutaImagenMarciano40_1);
		agregarImagenAPieza(imagenes_marciano40, rutaImagenMarciano40_2);

		/* Asignar las imagenes a las armas y sus devastadores efectos */
		agregarImagenAPieza(imagenes_rayoLaserBueno, rutaImagenRayoLaserBueno);
		agregarImagenAPieza(imagenes_Bomba_Marciano, rutaImagenBomba);
		agregarImagenAPieza(imagenes_explosion, rutaImagenExplosion);

		/* Asignar las imagenes a la ultima esperanza del universo conocido */
		agregarImagenAPieza(imagenes_naveBuena, rutaImagenNaveBuena);
		
		
		/* Asignar las imagenes a las naves invasoras */
		agregarRutaImagenPieza(rutas_imagenes_marciano10, rutaImagenMarciano10_1);
		agregarRutaImagenPieza(rutas_imagenes_marciano10, rutaImagenMarciano10_2);
		agregarRutaImagenPieza(rutas_imagenes_marciano20, rutaImagenMarciano20_1);
		agregarRutaImagenPieza(rutas_imagenes_marciano20, rutaImagenMarciano20_2);
		agregarRutaImagenPieza(rutas_imagenes_marciano40, rutaImagenMarciano40_1);
		agregarRutaImagenPieza(rutas_imagenes_marciano40, rutaImagenMarciano40_2);

		/* Asignar las imagenes a las armas y sus devastadores efectos */
		agregarRutaImagenPieza(rutas_imagenes_rayoLaserBueno, rutaImagenRayoLaserBueno);
		agregarRutaImagenPieza(rutas_imagenes_rayoLaserBueno, rutaImagenRayoLaserBueno);
		
		agregarRutaImagenPieza(rutas_imagenes_Bomba_Marciano, rutaImagenBomba);
		agregarRutaImagenPieza(rutas_imagenes_Bomba_Marciano, rutaImagenBomba);
		
		agregarRutaImagenPieza(rutas_imagenes_explosion, rutaImagenExplosion);
		agregarRutaImagenPieza(rutas_imagenes_explosion, rutaImagenExplosion);

		/* Asignar las imagenes a la ultima esperanza del universo conocido */
		agregarRutaImagenPieza(rutas_imagenes_naveBuena, rutaImagenNaveBuena);
		agregarRutaImagenPieza(rutas_imagenes_naveBuena, rutaImagenNaveBuena);
	
	}
	
	
	private static void inicializarArrayLists(){
		 imagenes_marciano10 = new ArrayList<BufferedImage>();
		 imagenes_marciano20 = new ArrayList<BufferedImage>();
		 imagenes_marciano40 = new ArrayList<BufferedImage>();
		 imagenes_Bomba_Marciano = new ArrayList<BufferedImage>();
		 imagenes_rayoLaserBueno = new ArrayList<BufferedImage>();
		 imagenes_naveBuena = new ArrayList<BufferedImage>();
		 imagenes_explosion = new ArrayList<BufferedImage>();
		
		rutas_imagenes_marciano10 = new ArrayList<String> ();
		rutas_imagenes_marciano20 = new ArrayList<String> ();
		rutas_imagenes_marciano40 = new ArrayList<String> ();
		rutas_imagenes_Bomba_Marciano = new ArrayList<String> ();
		rutas_imagenes_rayoLaserBueno = new ArrayList<String> ();
		rutas_imagenes_naveBuena = new ArrayList<String> ();
		rutas_imagenes_explosion = new ArrayList<String> ();
		
	}

	private static void agregarImagenAPieza(
			ArrayList<BufferedImage> imagenesMarciano,
			String rutaImagen) {
		
		BufferedImage img = null;
	
		try {
			img = ImageIO.read(new File(rutaImagen));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		imagenesMarciano.add(img);
	}
			

	private static void agregarRutaImagenPieza(ArrayList<String> rutas_imagenes, String rutaImagen){
		rutas_imagenes.add(rutaImagen);
	}
	
	public static ArrayList<String>ObtenerDefinicionesPiezas(TiposVehiculos tipopieza){
		if (imagenes_marciano10 == null) {
			inicializar();
		}
		
		ArrayList<String> retorno = null;
		retorno = new ArrayList<String>();

		switch (tipopieza) {
		case naveUFO10:
			retorno = rutas_imagenes_marciano10;
			break;
		case naveUFO20:
			retorno = rutas_imagenes_marciano20;
			break;
		case naveUFO40:
			retorno = rutas_imagenes_marciano40;
			break;
		case misilDefensor:
			retorno = rutas_imagenes_rayoLaserBueno;
			break;
		case naveDefensa:
			retorno = rutas_imagenes_naveBuena;
			break;
		case misilUFO:
			retorno=rutas_imagenes_Bomba_Marciano;
		break;
		}

		return retorno;
	}
	

	/*
	 * Obtenci�n de definici�n de una pieza.
	 */
	public static ArrayList<BufferedImage> obtenerDefinicionDePieza(TiposVehiculos tipoPieza) {

		if (imagenes_marciano10 == null) {
			inicializar();
		}
		
		ArrayList<BufferedImage> retorno = null;
		retorno = new ArrayList<BufferedImage>();

		switch (tipoPieza) {
		case naveUFO10:
			retorno = imagenes_marciano10;
			break;
		case naveUFO20:
			retorno = imagenes_marciano20;
			break;
		case naveUFO40:
			retorno = imagenes_marciano40;
			break;
		case misilDefensor:
			retorno = imagenes_rayoLaserBueno;
			break;
		case misilUFO:
			retorno = imagenes_naveBuena;
			break;
		}

		return retorno;
	}

	private static void agregarImagenAPieza(
			HashSet<BufferedImage> conjuntoImagenes, String rutaImagen) {
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(rutaImagen));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		conjuntoImagenes.add(img);
	}

}
