/**
 * 
 */
package observer.observable;
import java.util.HashSet;
import java.util.Iterator;

import naves.vehiculos.VehiculoAbstracto;

import observer.IObservable;
import observer.IObservador;

/**
 * Implementa una versión básica y funcional de la clase Sujeto Observable del patrón Observer.
 * No es abstracta porque debe de poder instanciarse en una clase la cual delegará en la presente la funcionalidad de Observable/Suejto.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class Observable implements IObservable {
	
	
	/**
	 * Conjunto de elementos observadores adscritos a este objeto.
	 * Se utiliza la clase HashSet para conseguir mayor renidimiento en un conjunto donde los elementos no se repiten.
	 */
	protected HashSet<IObservador> observadores = new HashSet<IObservador>();
	 
	public HashSet<IObservador> getObservadores(){
		return this.observadores;
	}
	/**
	 * Cadena que representa el estado de una instancia de la clase en un momento determinado.
	 */
	protected String estado;
	protected String origen;
	protected VehiculoAbstracto componente;
	/**
	 * @return the componente
	 */
	public VehiculoAbstracto getComponente() {
		return componente;
	}

	/**
	 * @param componente the componente to set
	 */
	public void setComponente(VehiculoAbstracto componente) {
		this.componente = componente;
	}

	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	protected String accion;
	
	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#adscribir(patronObserver.IObservador)
	 */
	@Override
	public void adscribir(IObservador observador) {
		if (!observadores.contains(observador)){
			observadores.add(observador);		}
	
	}
	
	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#quitar(patronObserver.IObservador)
	 */
	@Override
	public void quitar(IObservador observador) {
		if (observadores.contains(observador)){
			observadores.remove(observador);
		}
	}
	
	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#notificar()
	 */
	@Override
	public void notificar() {
		Iterator<IObservador> it;
		it = observadores.iterator();
		
		while(it.hasNext()){
			IObservador o = it.next();
			o.actualizar(this);
		}
	}
	
	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#obtenerEstado()
	 */
	@Override
	public Object obtenerEstadoObservable() {
		return estado;
	}
	
	@Override
	public int numeroObservadores(){
		return observadores.size();
	}
	
	@Override
	public void asignarEstadoObservable(String estado){
		this.estado=estado;
		notificar();
	}
}
