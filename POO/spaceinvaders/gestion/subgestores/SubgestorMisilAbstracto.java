/**
 * 
 */
package gestion.subgestores;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import gestion.GestorAbstracto;

import javax.swing.Timer;

import observer.IObservable;
import observer.observable.Observable;


import naves.bridge.ImpVehiculo2D;
import naves.extensiones.DecoradorNaves;
import naves.extensiones.componentes.ComponenteMisil;
import naves.vehiculos.VehiculoAbstracto;

import datos.ConfiguracionGUI;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;



/**
 * @author Gonzalo Sánchez Pla.
 *
 */
public abstract class SubgestorMisilAbstracto extends GestorAbstracto {
	

	

	protected Timer contador_misil;
	protected int dy = ConfiguracionGUI.DY;
	protected boolean piezaEnBorde = false;
	protected VehiculoAbstracto misil;
	protected VehiculoAbstracto nave;

	protected boolean misilEnElAire=false;
	protected boolean movimientoSolicitado;
	protected int sentidoSolicitado;
	protected TiposVehiculos tipo;
	protected int intervaloTimer ;
	
	
	public SubgestorMisilAbstracto(VehiculoAbstracto misil, VehiculoAbstracto nave){
		this.misil= misil;
		//observer.gestorCambios.GestorCambiosObserver.adscribirObservadorObservable(this, (IObservable) misil.getComponente_observer());
		this.nave=nave;
		generarTimers();
	}
	
	public void setVehiculo(VehiculoAbstracto nave){
		this.nave=nave;
	}
	
	@Override
	public void run() {

		contador_misil.start();
	}
	
	
	protected void asignarSentido(int sentido) {
		if (sentido != 0) {
			if (sentido < 0) {
				dy = ConfiguracionGUI.DY * -1;
			} else {
				dy = ConfiguracionGUI.DY;
			}
		}
	}
	
	/**
	 * El Timer actualiza la posición de la nave leyendo las variables de posición.
	 * No se encarga de leer el teclado.
	 */
	protected void generarTimers() {

	//	System.out.println("SubgestorLaser generarTimer");
		contador_misil = new Timer(intervaloTimer,

		new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				actualizarPosicionNave();
			}
		});
	}
	
	
	public void DispararLaserRunnable(final int tiempoTimer){
			
	 		

			new Thread(new Runnable(){
				@Override
				public void run() {
					DispararLaser(tiempoTimer);
				}
			}).start();
		}
	
	public void DispararLaser(int tiempoTimer){
		
		if (!misilEnElAire){
			this.misilEnElAire=true;
			intervaloTimer=tiempoTimer;
 			efectuarDisparo();
			this.misilEnElAire=false;
		}
	}

	protected void efectuarMovimiento(int sentido) {
	 	
		misil.SolicitarDesplazamiento();
		asignarSentido(sentido);

		int x = misil.obtenerX();
		int y = misil.obtenerY();
		if (!piezaEnBorde){
			y += dy;
			misil.AsignarPosicion(x, y);
			
			if (y>=ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO
					- ConfiguracionGUI.PADDING_VERTICAL_TABLERO || y<1){
					piezaEnBorde=true;
			}
			
		}else{
			
			this.destruirElementoGestionado();
			piezaEnBorde=false;
		}
		//System.out.println(y);
	}
	
	public boolean isMisilEnElAire(){
		return misilEnElAire;
	}
	
	protected void efectuarDisparo(){
				contador_misil.start();
				while(misil!=null && misil.getUltimoSuceso()!=TiposSucesos.destruido){
					SolicitarDesplazamiento(sentidoSolicitado);
				//	System.out.println("Misil a dormir");
					dormir(intervaloTimer);
				//System.out.println(misil.getPosicion().toString() +  " - Sentido: " + new Integer(sentidoSolicitado).toString());
		}
	}
	

	/**
	 * Comprueba que la pieza no está destruida y si se ha solicitado un movimiento, lo ejecuta.
	 */
	protected void actualizarPosicionNave() {
		if (misil!=null){
	 		if (this.movimientoSolicitado && 
		 				(misil.getUltimoSuceso()==TiposSucesos.inicializado ||
		 					misil.getUltimoSuceso()==TiposSucesos.desplazado||
		 					misil.getUltimoSuceso()==TiposSucesos.disparo
		 				)
	 			) {
	 			
				//System.out.println("moverse");
				this.efectuarMovimiento(sentidoSolicitado);
				movimientoSolicitado = false;
				
				if (misil.getUltimoSuceso()!=TiposSucesos.destruido){
					misil.setSuceso(TiposSucesos.desplazado);
					this.asignarEstadoObservable(TiposSucesos.desplazado.toString());
				}
				
				notificar();
	 		}
		}
	}

	
	public void destruirElementoGestionado() {
		
		if (misil!=null){
			
			misil.setSuceso(TiposSucesos.destruido);
			contador_misil.stop();
		
		}
		dormir(this.intervaloTimer);
	}
	


	/* (non-Javadoc)
	 * @see observer.observadorObservable.ObservadorObservable#actualizar(observer.IObservable)
	 */
	@Override
	public void actualizar(IObservable sujeto) {
		VehiculoAbstracto aux = ((Observable)sujeto).getComponente();
	
	}
	

	/**
	 * Como sólo podemos disparar un láser a la vez, tampoco vale la pena emplear recursos en multihilo.
	 * @param tiempoTimer
	 */

	
	
	private void SolicitarDesplazamiento(int sentido) {
		this.asignarSentido(sentido);
		movimientoSolicitado = true;
	}

	protected void dormir(int tiempoMilisegundos){
		try {
			Thread.sleep(tiempoMilisegundos);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
	
	


	protected void solicitarDesplazamiento(int sentido) {
		this.asignarSentido(sentido);
		movimientoSolicitado = true;
	}
	
	//Hay que devolver un punto.
	public Point obtenerPosicionNave(){
		
		if (misil!=null){
			return new Point(misil.obtenerX(),misil.obtenerY());
		}else{
			return null;
		}
	}
	
	public TiposVehiculos obtenerTipoNave(){
		if (misil!=null){
			return misil.getTipo();
		}else{
			return null;
		}
	}
	
	
	public ArrayList<ImpVehiculo2D> obtenerPiezas2DGenericas(){
		if (misil!=null){
		
			//long id_unica = misil.obtenerID_Unica();
			ImpVehiculo2D pieza = new ImpVehiculo2D(misil);
			
			ArrayList<ImpVehiculo2D> auxPieza = new ArrayList<ImpVehiculo2D>();
			
			auxPieza.add(pieza);	
			return auxPieza;
		}else{
			return null;
		}
	}
	
	

	
	
}
