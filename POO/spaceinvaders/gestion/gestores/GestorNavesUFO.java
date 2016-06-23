package gestion.gestores;


import gestion.GestorAbstracto;
import gestion.subgestores.SubgestorMisilDefensa;
import gestion.subgestores.SubgestorMisilUFO;


import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.Timer;

import observer.IObservable;
import observer.IObservador;
import observer.gestorCambios.GestorCambiosObserver;
import observer.observable.Observable;


import datos.ConfiguracionGUI;
import datos.ConfiguracionTimers;
import datos.ConfiguracionVehiculos.*;
import datos.ConfiguracionVehiculos;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;



import naves.bridge.ImpVehiculo2D;
import naves.extensiones.DecoradorNaves;
import naves.extensiones.componentes.ComponenteMisil;
import naves.extensiones.componentes.ComponenteObserver;
import naves.hangar.HangarVehiculos;
import naves.vehiculos.Misil;
import naves.vehiculos.NaveBuena;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;

public final class GestorNavesUFO extends GestorAbstracto{

	
	protected LanzaderaMisiles lanzadera = new LanzaderaMisiles();
	protected Timer contador_UFO;
	protected Timer contador_disparo_ufo;
	private int dx = ConfiguracionGUI.DX;
	private int dy = ConfiguracionGUI.DY;
	private boolean navesEnBorde=false;
	
	protected CopyOnWriteArrayList<VehiculoAbstracto> navesUFO = new CopyOnWriteArrayList<VehiculoAbstracto>(); 
	//private HashMap<VehiculoAbstracto,ComponenteMisil> mapaMisiles;
	//private HashSet<_ConjuntoVehiculos> conjuntoVehiculos= new HashSet<_ConjuntoVehiculos>();
	
	private boolean naveEnBordeEste; //NUEVO
	private boolean naveEnBordeOeste; //NUEVO
	private boolean movimientoSolicitado; //NUEVO
	private int sentidoSolicitado; //NUEVO
	private boolean cambiarSentido; //ADICIONAL.
	
	
	//private VehiculoAbstracto naveEquipada;  //NUEVO
	protected VehiculoAbstracto misil;
	//private VehiculoAbstracto observadorNave;  //NUEVO
	//private VehiculoAbstracto observadorMisil;  //NUEVO
	protected SubgestorMisilUFO gmisil;  //NUEVO
	
	
	@Override
	public void actualizar(IObservable sujeto) {
		VehiculoAbstracto aux = ((Observable)sujeto).getComponente();
		String auxNombre = aux.getClass().getSimpleName();
	
		if (auxNombre .equals(NaveUFO.class.getSimpleName())){
			
			switch (aux.getUltimoSuceso()){
				case bloqueado: case destruido:
					this.navesUFO.remove(aux);
				break;
				case vencedor:
					this.setAccion("FINALIZAR");
					this.notificar();
					HashSet<IObservador> observadores = this.getObservadores();
					observadores.clear();
					this.contador_UFO.stop();
					this.gmisil=null;
					this.misil=null;
					this.movimientoSolicitado=false;
					this.navesUFO=null;
				
			}
		}
	
	}
	


	public void run(){
		this.iniciarTimer();
	}

	public GestorNavesUFO() {
		equiparNave();
		equiparMisil();
		navesUFO.get(0).setSuceso(TiposSucesos.lanzado);
		generarTimers();
		
		//FALTA PONER LO DL MISIL.
	}
	


	
	public VehiculoAbstracto getNaveNodriza(){
		if (navesUFO.size()>0){
			return navesUFO.get(0);
		}
		else{
			return null;
		}
	}
	
	private boolean bloqueado=false;
	
	public boolean isBloqueado(){
		return bloqueado;
		
	}
	public synchronized void bloquear(){
	
		bloqueado=true;
	
	}
	
	public synchronized void desbloquear(){
		
			this.bloqueado=true;
			
	}
	
	public synchronized List<VehiculoAbstracto>  getTodasNaves(){
		
		return navesUFO;
		
	}
	
	public VehiculoAbstracto getNaveIndex(int indice){
		return navesUFO.get(indice);
	}

	private void equiparNave() {
		crearFlota();
	}
	
	

	private void equiparMisil() {
		
		Iterator <VehiculoAbstracto> it = navesUFO.iterator();
		ArrayList<VehiculoAbstracto> auxIt = new ArrayList<VehiculoAbstracto>();
		
		while (it.hasNext()){
			VehiculoAbstracto aux = it.next();
			aux.setComponente_misil(new naves.hangar.HangarVehiculos().getVehiculo(TiposVehiculos.misilUFO,this));
			aux.getComponente_misil().setGestor(gmisil);
			auxIt.add(aux);
		}
		navesUFO.clear();
		navesUFO.addAll(auxIt);
	}



	private void crearFlota() {
		//navesUFO = new ArrayList<VehiculoAbstracto>();
		
		int columnas = ConfiguracionVehiculos.ConfiguracionUFO.COLUMNAS_ENEMIGAS;
		

		
		int inicio = 0;
		int fin = inicio + columnas;

//		for (int i = inicio; i < fin; i++) {
//			//Crear nave
//			VehiculoAbstracto auxNave = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(ConfiguracionUFO.UFO_F1,this);
//			auxNave.setGestor(this);
//			auxNave.asignarX(ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO + i*2);
//			auxNave.asignarY(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO - 1);
//			auxNave.setTipo(ConfiguracionUFO.UFO_F1);
//
//			agregarNave(auxNave);
//		
//		}
//
//		for (int i = inicio; i < fin; i++) {
//			
//			VehiculoAbstracto auxNave = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(ConfiguracionVehiculos.ConfiguracionUFO.UFO_F2,this);
//			auxNave.setGestor(this);
//			auxNave.asignarX(ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO + i*2);
//			auxNave.asignarY(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO - 2);
//			auxNave.setTipo(ConfiguracionUFO.UFO_F1);
//			
//		
//			agregarNave(auxNave);
//		
//		}
//
//		for (int i = inicio; i < fin; i++) {
//			VehiculoAbstracto auxNave = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(ConfiguracionVehiculos.ConfiguracionUFO.UFO_F3,this);
//			auxNave.setGestor(this);
//			auxNave.asignarX(ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO + i*2);
//			auxNave.asignarY(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO - 3);
//			auxNave.setTipo(ConfiguracionUFO.UFO_F1);
//			
//			agregarNave(auxNave);
//			
//		
//		}
//
//		for (int i = inicio; i < fin; i++) {
//			VehiculoAbstracto auxNave = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(ConfiguracionVehiculos.ConfiguracionUFO.UFO_F4,this);
//			auxNave.setGestor(this);
//			auxNave.asignarX(ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO + i*2);
//			auxNave.asignarY(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO - 4);
//			auxNave.setTipo(ConfiguracionUFO.UFO_F1);
//			
//			agregarNave(auxNave);
//			
//		
//		}
		
		//for (int i = inicio; i < fin; i++) {
			for (int i = inicio; i < 2; i++) {
			VehiculoAbstracto auxNave = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(ConfiguracionVehiculos.ConfiguracionUFO.UFO_F5,this);
			auxNave.setGestor(this);
			auxNave.asignarX(ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO + i*2);
			auxNave.asignarY(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO - 5);
			auxNave.setTipo(ConfiguracionUFO.UFO_F1);
			agregarNave(auxNave);
		
		}
	
		
	}


	public VehiculoAbstracto getMisil(){
		return misil;
	}
	
	

	private void asignarSentido(int sentido) {
		if (sentido != 0) {
			if (sentido < 0) {
				dx = ConfiguracionGUI.DX * -1;
			} else {
				dx = ConfiguracionGUI.DX;
			}
		}
	}
	
	
	
	private void efectuarMovimiento(VehiculoAbstracto nave, boolean cambioSentido) {
		
		nave.SolicitarDesplazamiento(); // si la primera nave se desplaza, se
										// desplazan todas.

		if (cambioSentido) {
			bajarNave(nave);
		} else {
			balancearNave(nave);
		}
	}
	
	
	public ArrayList<Point> obtenerPosicionesNaves(){
		Iterator<VehiculoAbstracto> it = navesUFO.iterator();
		ArrayList<Point> puntos = new ArrayList<Point>();
		while(it.hasNext()){
			VehiculoAbstracto nave = it.next();	
			puntos.add(new Point(nave.obtenerX(),nave.obtenerY()));
		}
		return puntos;
	}
	

	public void destruirNave(int x, int y) {

		Iterator<VehiculoAbstracto> it = navesUFO.iterator();
		boolean destruido = false;

		while (it.hasNext() && !destruido) {
			VehiculoAbstracto nave = it.next();

			if (nave.obtenerX() == x && nave.obtenerY() == y) {
				destruirNave(nave);
				destruido = true;
			}
		}
	}
	

	public void destruirNave(final VehiculoAbstracto auxNave) {
		
		if (auxNave!=null){
			if (auxNave.getUltimoSuceso()!=TiposSucesos.destruido){
				
				auxNave.setSuceso(TiposSucesos.destruido);
					new Thread(
						new Runnable(){
					public synchronized void run(){
							try{
								Thread.sleep(2500);
							}catch(Exception e){}
						
							navesUFO.remove(auxNave);
							
							
							if (navesUFO.size()>0){
								navesUFO.get(0).setSuceso(TiposSucesos.lanzado);
							}
					}
				}).start();
			}
		}
	}
	
	
	
		
	
	/**
	 * Mueve las naves en forma oscilatoria y comprueba cuando llegan a los
	 * topes de movimiento.
	 * 
	 * @param nave
	 */
	private void balancearNave(VehiculoAbstracto nave) {
		if (nave.obtenerEstadoSolicitudDesplazamiento()) {
			int x = nave.obtenerX();
			int y = nave.obtenerY();
			x += dx;
			nave.AsignarPosicion(x, y);
			if (x >=  ConfiguracionGUI.DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO
					- ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO
					|| x <= ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO) {
				navesEnBorde = true;
			}
		}
	}

	private void bajarNave(VehiculoAbstracto nave) {

		if (nave.obtenerEstadoSolicitudDesplazamiento()) {
			int x =  nave.obtenerX();
			int y = nave.obtenerY();
			if (y > 0) {
				y -= dy;
				nave.AsignarPosicion(x, y);
			} else {
				// if (y==0) gananInvasores=true;
				detenerTimer();
				this.estado = TiposSucesos.vencedor;
				notificar();
			}
		}
	}
	
	
	

	public void detenerTimer(){
		Timer t = contador_UFO;
		
		if (t!=null){
			t.stop();
			contador_disparo_ufo.stop();
		}
	}
	

	public void iniciarTimer(){
		
		Timer t = contador_UFO;
		
		if (t!=null){
			t.start();
			this.contador_disparo_ufo.start();
		}
	}
	








	private VehiculoAbstracto getVehiculoConMisil(VehiculoAbstracto naveEquipada) {
				//Añadimos misiles a la nave.
				naveEquipada = new ComponenteMisil(naveEquipada);
				((ComponenteMisil)naveEquipada).setTipoMisil(TiposVehiculos.misilDefensor);
				
				VehiculoAbstracto misil = (VehiculoAbstracto) new naves.hangar.HangarVehiculos().getVehiculo(TiposVehiculos.misilUFO,this);
				//Añadimos un componente observador al misil para poder seguirlo.
				misil = ((ComponenteMisil)naveEquipada).getMisil() ;
				misil = new ComponenteObserver(misil);
				GestorCambiosObserver.adscribirObservadorObservable(this, (ComponenteObserver) misil);
				
				return naveEquipada;
				
		
	}


	private void agregarNave(VehiculoAbstracto auxNave) {
		navesUFO.add(auxNave);
		
	}


	private void generarTimers() {

		
		contador_UFO = new Timer(ConfiguracionTimers.TIMER_NAVES_ENEMIGAS,

		new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// mostrarMatrizPosiciones();
				moverNaves();
			}
		});
		
		contador_disparo_ufo=
		new Timer(ConfiguracionTimers.TIMER_MIN_DISPARO_ENEMIGO,
				new ActionListener(){
					public void actionPerformed(ActionEvent evento){
						new Thread(new LanzaderaMisiles()).start();
					}
				}
				);
		
		

	}
	
	
	
	

	private  void moverNaves() {

	
		Iterator<VehiculoAbstracto> i = this.getTodasNaves().iterator();
		boolean cambioSentido = cambiarSentido;
		// System.out.println(cambiarSentido);
		VehiculoAbstracto nave = null;

		/*
		 * Si la primera nave de la lista tiene solicitud de movimiento, se
		 * mueven todas. Si no, entonces se espera a la siguiente ronda.
		 */
		if (i.hasNext()) {
			nave =  i.next();
			efectuarMovimiento(nave, cambioSentido);
		}

		if (nave != null) {
			do {
				if (navesUFO.size()==1){
					nave =  navesUFO.get(0);
					efectuarMovimiento(nave, cambioSentido);
				}else{
					if (i.hasNext()){
						nave =  i.next();
						efectuarMovimiento(nave, cambioSentido);
					}
				
				}
				
			} while (i.hasNext() && nave != null);
		}// fin del if principal.

		// si cuando entramos en el bucle, hab�a de cambiarse el sentido, ya se
		// cambi�.
		// Si se detect� que hay alguna nave en el borde, da la orden de cambio
		// de sentido.
		if (cambioSentido) {
			dx = dx * -1;
			cambiarSentido = false;
			cambioSentido = false;
			navesEnBorde = false;
		}

		if (navesEnBorde) {
			cambiarSentido = true;
		}
		
		if (this.navesUFO.size()>0){
			navesUFO.get(0).setSuceso(TiposSucesos.desplazado);
		}
	}
	
	public ArrayList<ImpVehiculo2D> obtenerPiezas2DGenericas(){
			
			ArrayList<ImpVehiculo2D> lista = new ArrayList<ImpVehiculo2D>();
			Iterator<VehiculoAbstracto> it = navesUFO.iterator();
			
			while (it.hasNext()){
				VehiculoAbstracto vab = it.next();
				lista.add(new ImpVehiculo2D(vab));
			}
			return lista;
	}

	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		ArrayList<VehiculoAbstracto> aux = new ArrayList<VehiculoAbstracto> ();
		aux.addAll(navesUFO);
		aux.trimToSize();
		return aux;
	}


	private class LanzaderaMisiles  implements Runnable{
		GestorNavesUFO g;
		SubgestorMisilUFO gm;
		
		
		@Override
		public void run() {
			lanzar();
			
		}
		private void lanzar(){
			Random rnd = new Random();
			
			int indice;
			
			CopyOnWriteArrayList<VehiculoAbstracto> vaaux = navesUFO;
			if (!vaaux.isEmpty()){
				
				int rango=vaaux.size()-1;
				
				if ( rango<1){
					indice=0;
				}else{
					indice = rnd.nextInt(rango);
				}
				
				gmisil = new SubgestorMisilUFO(vaaux.get(indice).getComponente_misil(),(NaveUFO) vaaux.get(indice));
			
				
				try {
					Thread.sleep(ConfiguracionTimers.TIMER_DISPARO_ENEMIGO());
					
					gmisil.DispararLaser(ConfiguracionTimers.TIMER_MISIL_UFO);
					
				} catch (InterruptedException e) {}
			}
		}
		
	}
	
}
