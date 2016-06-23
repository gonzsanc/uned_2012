/**
 * 
 */
package patronObserver;

import peticiones.TiposEstadosPreparacion;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;

/**
 * Implementa una versión básica y completamente funcional del patrón observador.
 * @author Gonzalo Sánchez Pla.
 *
 */
public abstract class ObservadorAbstracto implements IObservador {

	/* (non-Javadoc)
	 * @see patronObserver.IObservador#actualizar(patronObserver.ISujeto)
	 */
	@Override
	public void actualizar(ISujeto sujeto) {
		TiposEstadosPreparacion estadoSujeto = ((PizzaTodopizzaAbstracta) sujeto).obtenerEstado();
		System.out.println("Observador es notificado del cambio en el sujeto " + sujeto.getClass().toString() + ": " + estadoSujeto);
	}

}
