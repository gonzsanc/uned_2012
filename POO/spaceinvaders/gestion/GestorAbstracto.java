/**
 * 
 */
package gestion;

import java.util.ArrayList;

import naves.vehiculos.VehiculoAbstracto;

import datos.enumerados.TiposSucesos;
import observer.IObservable;
import observer.IObservador;
import observer.observadorObservable.ObservadorObservable;

/**
 * Es el control principal del juego, por encima del resto de elementos.
 * @author Gonzalo Sánchez Pla.
 *
 */
public abstract class GestorAbstracto extends ObservadorObservable implements Runnable {

	protected Object naveDefensora=null; //Elemento que gestiona esta clase.
	protected TiposSucesos estado;
	/**
	 *  Constructor genérico.
	 */
	public GestorAbstracto() {
	}

	public Object getElementoGestionado(){
		return naveDefensora;
	}
	
	
	//Configuracion
	protected static abstract class Configuracion{};
	
	// RUNNABLE
	/**
	 * Implementa una versión vacía de run para que las subclases no tengan que hacerlo necesariamente.
	 */
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	
	@Override
	public void run() {
	}
	
	public abstract ArrayList<VehiculoAbstracto>getArrayListDeElementos();



}
