package patronObserver;

/**
 * Interfaz para la clase observadora.
 * @author Gonzalo Sánchez Pla.
 *
 */
public interface IObservador {
	
	/**
	 * Indica al observador que ha de pedirle una actualización de estado al sujeto.
	 * @param sujeto Objeto de tipo observable.
	 */
	public void actualizar(ISujeto sujeto);
}
