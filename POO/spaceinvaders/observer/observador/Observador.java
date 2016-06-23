/**
 * 
 */
package observer.observador;

import observer.IObservable;
import observer.IObservador;

/**
 * Implementa una versión básica y completamente funcional del patrón observador.
 * No es abstracta porque debe de poder instanciarse en una clase la cual delegará en la presente la funcionalidad de Observador.
 * @author Gonzalo Sánchez Pla.
 *
 */
public  class Observador implements IObservador {

	/* (non-Javadoc)
	 * @see patronObserver.IObservador#actualizar(patronObserver.ISujeto)
	 */
	@Override
	public synchronized void actualizar(IObservable sujeto) {
		
	//	System.out.println("No se ha implementado actualizar en esta clase: " + this.getClass().getDeclaringClass());
	}

}
