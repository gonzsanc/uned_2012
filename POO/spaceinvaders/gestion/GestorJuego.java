/**
 * 
 */
package gestion;
import java.awt.Color;
import java.awt.event.ComponentListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.JFrame;

import datos.enumerados.TiposSucesos;

import naves.vehiculos.NaveBuena;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;

import juego.Partida;
import juego.PartidaSpaceInvaders;
import juego.TableroSpaceInvaders;
import GUI.ListenerTeclado;
import GUI.MainGUI;
import observer.IObservable;
import observer.IObservador;
import observer.gestorCambios.GestorCambiosObserver;
import observer.observable.Observable;
import observer.observador.Observador;
import gestion.gestores.GestorCanvasSpaceInvaders;
import gestion.gestores.GestorNaveDefensa;
import gestion.gestores.GestorNavesUFO;
import gestion.gestores.GestorTablero;
import gestion.subgestores.subGestorColisiones;

/**
 * Gestor principal del juego. Controla al resto de gestores.
 * @author Gonzalo Sánchez Pla.
 * 
 */
public final class GestorJuego extends GestorAbstracto {

	private GestorNaveDefensa defensa;
	private static GestorNavesUFO gUFO=null;
	private GestorTablero gestorTablero;
	private MainGUI  mainGUI;
	private TableroSpaceInvaders tablero;
	private GestorCanvasSpaceInvaders lienzo;
	private Partida partida;
	ListenerTeclado lectorTecladoMainGUI;
	public boolean misilEnElAire=false;
	private subGestorColisiones gColisiones = new subGestorColisiones();
	private boolean terminado;
	
	public GestorJuego(){
		crearElementosGestionados();
		
		
		//gUFO = new GestorNavesUFO();
		//gUFO.iniciarTimer();
		
		
	}

	private void crearElementosGestionados() {
		
		InicializarGUI();
		
		InicializarElementosJuego();
		InicializarJugadores();
		InicializarComunicaciones();
		LanzarJuego();
	}
	
	
	/**
	 * Define las relaciones de comunicación entre las distintas clases.
	 */
	private void InicializarComunicaciones() {
		
		//Obtener instancia de lector de teclado.
		lectorTecladoMainGUI = ListenerTeclado.Singleton();
		//Asignarle al MainGUI el lector lectorTecladoMainGUI.
		mainGUI.asignarLectorDeTeclado(lectorTecladoMainGUI);
		//Adscribir como observador a esta clase para que detecte cuándo el lector detecta pulsaciones en MainGUI.
		GestorCambiosObserver.adscribirObservadorObservable(this,lectorTecladoMainGUI);
		
		defensa.getNave().adscribir(gestorTablero);
		defensa.getMisil().adscribir(gestorTablero);
		
		defensa.getNave().adscribir(gColisiones);
		defensa.getMisil().adscribir(gColisiones);
		
		Iterator<VehiculoAbstracto> it = gUFO.getTodasNaves().iterator();
	
		while (it.hasNext()){
			VehiculoAbstracto n = it.next();
			VehiculoAbstracto m = n.getComponente_misil();
			n.adscribir(gestorTablero);
			m.adscribir(gestorTablero);
			n.adscribir(gColisiones);
			m.adscribir(gColisiones);
			n.adscribir(gUFO);
			
		}	
		
		defensa.getNave().setSuceso(TiposSucesos.lanzado);
		defensa.getNave().notificar();
		
		defensa.adscribir(this);
		gUFO.adscribir(this);
		gColisiones.adscribir(this);
		gColisiones.setGestorJuego(this);
		
	}

	public GestorAbstracto getGestorTeclado(){
		return this.getGestorTeclado();
	}
	
	public void pararTodo(){
		this.terminado=true;
		((JFrame)mainGUI).removeKeyListener(this.lectorTecladoMainGUI);
		
		this.lienzo=null;
		this.tablero=null;
		this.defensa=null;
		this.gUFO=null;
		this.misilEnElAire=false;
	}
	

	private void InicializarGUI() {
		mainGUI = new GUI.MainGUI();
		gestorTablero = new GestorTablero();
		tablero = gestorTablero.obtenerTablero();
		
		
		lienzo = (GestorCanvasSpaceInvaders) mainGUI.obtenerCanvasPanel();
		lienzo.asignarGestorTalbero(gestorTablero);
	}
	
	private void InicializarElementosJuego() {
		partida = new PartidaSpaceInvaders();
		
	}
	
	private void InicializarJugadores() {
		defensa = new GestorNaveDefensa();
		
		// gestorLaserDefensa = new subGestorLaserDefensa(defensa.obtenerPieza(), defensa);
		// gestorLaserDefensa.agregarObservador(gestorTablero);
		
		//vvvv Hay que conseguir que obtenernave devuelva un puente entre la nave activa y el sugestorLaser.
		gUFO = new GestorNavesUFO();
		
		//gestorLaserUFO = new subGestorLaserUFO(UFO.obtenerPiezaDispara(),UFO);
		//gestorLaserUFO.agregarObservador(gestorTablero);
		
	//	gestorColisiones = new subGestorColisiones();
		
		// El gestor de colisiones debe saber si dos piezas colisionan, incluyendo los misiles.
		//defensa.agregarObservador(gestorColisiones);
		//UFO.agregarObservador(gestorColisiones);
		
		
		
		//Segundo nivel de detección de eventos de piezas para el gestor de colisiones.
	//	gestorLaserDefensa.agregarObservador(gestorColisiones);
	//	gestorLaserUFO.agregarObservador(gestorColisiones);
		
		//Los gestores de piezas deben de ser capaces de reaccionar ante las pieza que ellos gestionan y colisionan.
	//	gestorColisiones.agregarObservador(defensa);
	//	gestorColisiones.agregarObservador(UFO);
	//	gestorColisiones.agregarObservador(gestorLaserDefensa);
	//	gestorColisiones.agregarObservador(gestorLaserUFO);
	}

	
	private void LanzarJuego()  {
		
		mainGUI.validate();
		mainGUI.setVisible(true);
		new Thread(defensa).start();
		new Thread(gUFO).start();
		//lienzo.cambiarImagenDeFondoCanvas(new subgestorImagenes(Datos.DefinicionGUI.RUTA_IMAGEN_FONDO_02).obtenerImagen());
	}
	
	
	/* (non-Javadoc)
	 * @see observer.observadorObservable.ObservadorObservable#actualizar(observer.IObservable)
	 */
	@SuppressWarnings("static-access")
	@Override
	public void actualizar(IObservable sujeto) {
		//System.out.println(this.toString() + " leyendo: " + sujeto.obtenerEstadoObservable());
	//	System.out.println(GUI.ListenerTeclado.extraerCódigoCadena(sujeto.obtenerEstadoObservable().toString()));
	//	System.out.println(sujeto.getClass().getSimpleName());
		
		String nombreSujeto=sujeto.getClass().getSimpleName();
		String nombreListenerTeclado=null;
		
		try {
			nombreListenerTeclado = Class.forName(GUI.ListenerTeclado.class.getName()).getSimpleName();
		} catch (ClassNotFoundException e) {
			System.out.println("Error en GestorJuego actualizar(IObsevable)");
		}
		
		
		if (nombreSujeto.equals(nombreListenerTeclado)){
			
			new Thread (
			new ProcesadoraTeclado(ListenerTeclado.extraerCodigoCadena(
					 sujeto.obtenerEstadoObservable().toString().toLowerCase()
			)))
			.start();
		} 
		else if ( ((Observable)sujeto).getComponente()  !=null){
			
			String accion = sujeto.getAccion();
			if (accion.equals("FINALIZAR")){
				try{
					this.lienzo.repaint();
					this.lienzo.detenerTimer();
					this.tablero=null;
					this.defensa=null;
					this.gUFO=null;
					this.misilEnElAire=false;
					this.lienzo.repaint();
				}
				catch (Exception e){}
			}
			
		}
		
	  if ( ((Observable) sujeto).getComponente()!=null){
		  if ( ((Observable)sujeto).getComponente().getClass().getSimpleName().equals( subGestorColisiones.class.getSimpleName()) ){
				this.lienzo.detenerTimer();
				this.lienzo.repaint();
				this.tablero=null;
				this.defensa=null;
				this.gUFO=null;
				this.misilEnElAire=false;
				
		  }
		}
	}


		
	private class ProcesadoraTeclado implements Runnable{
	
		private Integer codigo;
		
		
		public ProcesadoraTeclado(Integer codigo){
			this.codigo=codigo;
		}
		
		@Override
		public void run() {
			if (!terminado){
			procesarPulsacionteclado(codigo);
			}
		}
		
		/**
		 * Procesa las pulsaciones de teclas que son notificadas desde el ListenerTeclado.
		 * Estas pulsaciones están destinadas a mover la nave de defensa y a disparar sus misles.
		 * @param extraerCodigoCadena
		 */
		private void procesarPulsacionteclado(Integer extraerCodigoCadena) {
			
			
			int codigo = (int)extraerCodigoCadena;
			
			
			switch (codigo){
				case 79: case 37: //o  felchaizq
					defensa.solicitarDesplazamiento(-1);
				 
					break;
				case 39: case 80: // p o flecha derecha
					defensa.solicitarDesplazamiento(1);
					break;
				case 32: // espacio
						defensa.ordenarFuego();
				break;
			}
		}
	}
	
	
	public static GestorNavesUFO getGestorNavesUFO(){
		return gUFO ;
	}

	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	@Override
//	public void actualizar(IObservable sujeto) {
//		
//	
//	}
}
	
	
	

