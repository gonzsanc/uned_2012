/**
 * 
 */
package gestion.gestores;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;


import javax.swing.Timer;

import observer.IObservable;
import observer.IObservador;
import observer.observable.Observable;

import gestion.GestorAbstracto;

import gestion.subgestores.SubgestorMisilDefensa;

import datos.ConfiguracionGUI;
import datos.ConfiguracionTimers;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;
import naves.hangar.HangarVehiculos;

import naves.vehiculos.Misil;
import naves.vehiculos.NaveBuena;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;

/**
 * Realiza las operaciones para la nave de defensa.
 * @author Gonzalo Sánchez Pla
 */

public class GestorNaveDefensa extends GestorAbstracto  {

	
	private Timer contador_defensa;
	private int dx = ConfiguracionGUI.DX;
	boolean naveEnBorde = false;
	private VehiculoAbstracto _naveDefensora;
	private boolean naveEnBordeEste;
	private boolean naveEnBordeOeste;
	private boolean movimientoSolicitado;
	private int sentidoSolicitado;
	
	private SubgestorMisilDefensa gmisil;
	
	
	
	/**
	 * Constructor.
	 */
	public  GestorNaveDefensa() {
		
		equiparNave();
		equiparMisil();
		gmisil = new SubgestorMisilDefensa(_naveDefensora.getComponente_misil(),(NaveBuena) naveDefensora);
	}
	
//	public Object getElementoGestionado(){
//		return _naveDefensora;
//	}
//	
	public VehiculoAbstracto getNave(){
		return _naveDefensora;
	}
	
	/**
	 * Crea la nave
	 */
	private void equiparNave() {
		//Creamos la nave defensora
		_naveDefensora = (VehiculoAbstracto) new naves.hangar.HangarVehiculos().getVehiculo(TiposVehiculos.naveDefensa,this);
		_naveDefensora.asignarPosicion(new Point(ConfiguracionGUI.DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO/2+ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO/2, 1));
		_naveDefensora.setGestor(this);
	}
	
	
	/**
	 * Crea el misil.
	 */
	private void equiparMisil() {
		
		//Añadimos misiles a la nave.
		_naveDefensora.setComponente_misil(new HangarVehiculos().getVehiculo(TiposVehiculos.misilDefensor,this.gmisil));
		VehiculoAbstracto  misil = this._naveDefensora.getComponente_misil();
		misil.setGestor(this);
		
		//Añadimos un componente observador al misil para poder seguirlo.
		
		//observadorMisil = misil.getComponente_observer();	
	}

	

	/* (non-Javadoc)
	 * @see gestores.subGestores.IGestorNave#getMisil()
	 */

	public VehiculoAbstracto getMisil(){
		return _naveDefensora.getComponente_misil();	
	}

	
//	public DecoradorNaves getNaveEquipada(){
//		return (DecoradorNaves) naveEquipada;
//	}
//	
	
	private void asignarSentido(int sentido) {
		if (sentido != 0) {
			if (sentido < 0) {
				dx = ConfiguracionGUI.DX * -1;
			} else {
				dx = ConfiguracionGUI.DX;
			}
		}
	}
	

	private void efectuarMovimiento(int sentido) {
		
		asignarSentido(sentido);
		_naveDefensora.SolicitarDesplazamiento();
		

		int x =  _naveDefensora.obtenerX();
		int y = _naveDefensora.obtenerY();

		if (!naveEnBordeEste && dx > 0) {
			x += dx;
			//((Pieza)_naveDefensora).notificarMovimiento();
		} else if (!naveEnBordeOeste && dx < 0) {
			x += dx;
			//((Pieza)_naveDefensora).notificarMovimiento();
		}

		_naveDefensora.AsignarPosicion(x, y);

		if (x >= ConfiguracionGUI.DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO
				- ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO) {
			naveEnBordeEste = true;
		} else if (x <= ConfiguracionGUI.PADDING_HORIZONTAL_TABLERO) {
			//System.out.println("SubgestorDefensa comprueba posición horizontal x:" + x );
			naveEnBordeOeste = true;
		} else {
			naveEnBordeOeste = false;
			naveEnBordeEste = false;
		}
		
		this.naveEnBorde = naveEnBordeOeste || naveEnBordeEste;
		//System.out.println("SubGestorDefensa Informa: Defensa en borde: " + this.naveEnBorde);
	}

	private  void actualizarPosicionNave() {
		if (this.movimientoSolicitado) {

			this.efectuarMovimiento(sentidoSolicitado);
			movimientoSolicitado = false;
			this.asignarEstadoObservable("movimientoefectuado");
			notificar();
			//System.out.println(this.toString() + " " + this._naveDefensora.obtenerPosicion().toString());
		}
	}
	
	@Override
	public void run() {

		iniciarTimers();
		
	}


	public void solicitarDesplazamiento(int sentido) {
		this.asignarSentido(sentido);
		movimientoSolicitado = true;
	}
	
	
	
	private void iniciarTimers() {

		//System.out.println("SubgestorDefensa generarTimer");
		contador_defensa = new Timer(ConfiguracionTimers.TIMER_NAVE_DEFENSA,

		new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent evento) {
				// mostrarPosicionNave();
				actualizarPosicionNave();
			}
		});

		contador_defensa.start();
	}
	

//	public VehiculoAbstracto getObservadorNave(){
//		return this._naveDefensora.getComponente_observer();
//	}
//	
//
//	
//	public VehiculoAbstracto getObservadorMisil(){
//		return  this._naveDefensora.getComponente_misil().getComponente_observer();
//	}
	

	public  void ordenarFuego() {
	
		
		if (!gmisil.isMisilEnElAire()){
			
			Misil misil;
			misil=(Misil) _naveDefensora.getComponente_misil();
			misil.asignarPosicion(_naveDefensora.getPosicion());
			misil.setSuceso(TiposSucesos.disparo);
			gmisil.DispararLaser(ConfiguracionTimers.TIMER_MISIL_DEFENSA);
		}
	}

	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		ArrayList<VehiculoAbstracto> aux = new ArrayList<VehiculoAbstracto> ();
		aux.add(_naveDefensora);
		aux.trimToSize();
		return aux;
	}
	
	

	@Override
	public void actualizar(IObservable sujeto) {
		VehiculoAbstracto aux = ((Observable)sujeto).getComponente();
		
		if (aux.getClass().toString() .equals(NaveUFO.class.getClass().toString()) ){
			
			switch (aux.getUltimoSuceso()){
				case bloqueado: case destruido: case vencedor:
					this.setAccion("FINALIZAR");
					this.contador_defensa.stop();
					this.notificar();
					HashSet<IObservador> observadores = this.getObservadores();
					observadores.clear();
					this.gmisil=null;
					this.naveDefensora=null;
					this.movimientoSolicitado=false;
				
			}
		}
	
	}
	
}
