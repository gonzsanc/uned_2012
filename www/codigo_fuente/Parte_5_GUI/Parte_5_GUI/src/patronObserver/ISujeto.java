/**
 * 
 */
package patronObserver;

/**
 * Interfaz para la clase sujeto observable del patrón Observer.
 * @author Gonzalo Sánchez Pla.
 *
 */
public interface ISujeto {
	
	/**
	 * Agrega un objeto tipo observador a la lista de objetos a los que se notificarán los cambios de la clase.
	 * @param observador Objeto observador a añadir a la lista de los que se les notificarán cambios.
	 */
	public void adscribir (IObservador observador);
	
	
	/**
	 * Elimina un objeto concreto de la lista de observadores. Una vez quitado ya no recibirá notificaciones de los cambios de los objetos observables.
	 * @param observador Objeto concreto a eliminar de la lista de observadores.
	 */
	public void quitar (IObservador observador);
	
	/**
	 * Informa a los objetos observadores de que ha habido un cambio en el objeto observable.
	 */
	public void notificar();
	
	
	
	/**
	 * Devuelve el número de objetos tipo observer suscritos a un objeto observable.
	 * @return long número de objetos observadores suscritos al objeto.
	 */
	public int numeroObservadores();
	
	
	
}
