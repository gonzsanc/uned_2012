package gestion.gestores;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.Timer;

import juego.TableroSpaceInvaders;

import naves.bridge.ImpVehiculo2D;

import datos.ConfiguracionGUI;

import GUI.CanvasConImagen;

/**
 * Extiende la clase canvas con imagen para adaptarla al juego Space Invaders.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class GestorCanvasSpaceInvaders extends CanvasConImagen{

	private static final long serialVersionUID = 5913716444477442872L;
	private static String imgFondo = ConfiguracionGUI.RUTA_IMAGEN_FONDO;
	protected GestorTablero gestorTablero;
	protected LectorTablero lectorTablero;
	protected int indiceImagenUFO;
	
	/**
	 * Constructor de CanvasSpaceInvaders.
	 */
	public GestorCanvasSpaceInvaders() {
		super(imgFondo);
		indiceImagenUFO=0;
		lectorTablero=new LectorTablero();
		lectorTablero.start();
	}
	
	
	/**
	 * Determina qué gestor de tablero será observado por esta clase.
	 * La clase Canvas es la representación visual de un tablero.
	 * @param subgestor
	 */
	public void asignarGestorTalbero(GestorTablero subgestor) {
		this.gestorTablero = subgestor;
	}

	
	/**
	 * Muestra en pantalla todas las piezas del juego en su posición actual y con una representación gráfica.
	 * @param piezas Colección completa de piezas que se representarán en el canvas.
	 */
	protected  void representarPiezas(HashSet<ImpVehiculo2D> piezas){
		if (!ocupado){
			ocupado=true;
			limpiarSinRepaint();
			
			Iterator<ImpVehiculo2D> it = piezas.iterator();
			while(it.hasNext()){
				ImpVehiculo2D pieza=it.next();
				String rutaImagen;
				rutaImagen = pieza.obtenerRepresentacion();
				
				
				int x, y;
				x = pieza.obtenerX() * ConfiguracionGUI.TAMANO_BLOQUE_HORIZONTAL;
				y =  ConfiguracionGUI.CANVAS_TAMANO_JUGABLE.height - 
							pieza.obtenerY()* ConfiguracionGUI.TAMANO_BLOQUE_VERTICAL- 
							ConfiguracionGUI.PADDING_VERTICAL_TABLERO * ConfiguracionGUI.TAMANO_BLOQUE_VERTICAL;
				
				pintar (x,y,rutaImagen);
			}
			repaint();
			// Operación lógica XOR para cambiar el valor de indicImagenUFO
			ocupado=false;
		}
	}


	/**
	 * Detiene la observación del tablero.
	 */
	public void detenerTimer(){
		lectorTablero.detenerHilo();
	}
	
	/**
	 * Reanuda la observación del tablero.
	 */
	public void reanudarTimer(){
		lectorTablero.timer.start();
	}

	
	
	
	private class LectorTablero extends Thread{
		Timer timer ;
		@Override
		public void run(){
		
			/* Aproximar a 25fps la velocidad de refresco*/
			timer = new Timer(1000/25, 
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent temporizador) {
						if (!ocupado && inicializado){
							if (!gestorTablero.ocupado()){
								while(!gestorTablero.ocupar()){
									try {
										Thread.sleep(10);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
									
								TableroSpaceInvaders tablero=gestorTablero.obtenerTablero();
								gestorTablero.desocupar();
								representarPiezas(tablero.obtenerPiezasTablero());
							}
						}
					}
			}
			);
			timer.start();
		}
		
		public void detenerHilo(){
			timer.stop();
			try {
				this.finalize();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}
		
		
	}


}

