/**
 * 
 */
package datos;

import java.awt.Dimension;

/**
 * @author Gonzalo Sánchez Pla
 *
 */
public class ConfiguracionGUI {

	public static final String RUTA_IMAGEN_FONDO= Ficheros.RutinasComunes.ObtenerRutaAplicacion() + "DT/Media/img/fondo_invaders.jpg";
	public static final String RUTA_IMAGEN_FONDO_02= Ficheros.RutinasComunes.ObtenerRutaAplicacion() + "DT/Media/img/fonto_alternativo.jpg";
	
	
	// Define los pasos (desplazamientos o movimientos) con los que se recorre
	// todo el tablero, pero sin tener en cuenta la representación del mismo
	public static final int DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO = 30;
	public static final int DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO = 20;
	public static final int PADDING_HORIZONTAL_TABLERO = 2;
	public static final int PADDING_VERTICAL_TABLERO=1;
	public static final int DX = 1;
	public static final int DY = 1;

	// El canvas se podr�a definir con X_CANVAS e Y_CANVAS y redimensionando la
	// imagen de fondo al tama�o del mismo.
	// Para simplificar defino manualmente su tama�o.
	/* == Canvas == */
	private static final int CANVAS_TAMANO_HORIZONTAL=500;
	private static final int CANVAS_TAMANO_VERTICAL=500;
	public static final double PROPORCION_PADDING_INTERNO_CANVAS = 0.025;
	
	private static final int X_CANVAS = (int) (CANVAS_TAMANO_HORIZONTAL * (1-PROPORCION_PADDING_INTERNO_CANVAS));
	private static final int Y_CANVAS = (int) (CANVAS_TAMANO_VERTICAL * (1- PROPORCION_PADDING_INTERNO_CANVAS));
	
	public static final Dimension TAMANO_CANVAS = new Dimension(CANVAS_TAMANO_HORIZONTAL, CANVAS_TAMANO_VERTICAL);
	public static final Dimension CANVAS_TAMANO_JUGABLE= new Dimension (X_CANVAS,Y_CANVAS);
	
	public static final int TAMANO_BLOQUE_HORIZONTAL = X_CANVAS/DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO;
	public static final int TAMANO_BLOQUE_VERTICAL= Y_CANVAS/DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO;
	
	private static final String imagenFondo="DT/Media/img/fondo_invaders.jpg";
	public static final String imagenFondoJuego = Ficheros.RutinasComunes.ObtenerRutaAplicacion()+imagenFondo;
}
	

