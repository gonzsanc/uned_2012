/**
 * 
 */
package observer;


/**
 * Interfaz para la clase sujeto observable del patrón Observer.
 * @author Gonzalo Sánchez Pla.
 *
 */
public interface IObservable {
	
/**
	 * @return the origen
	 */
	public String getOrigen();

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen);

	/**
	 * @return the accion
	 */
	public String getAccion() ;

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) ;


	
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
	 * Devuelve el estado actual del objeto observable (el sujeto).
	 * @return cadena con el estado. Este método se podría sobreescribir con un enumerado, por ejemplo, para hacerlo más consistente.
	 */
	public Object obtenerEstadoObservable();
	
	/**
	 * Devuelve el número de objetos tipo observer suscritos a un objeto observable.
	 * @return long número de objetos observadores suscritos al objeto.
	 */
	public int numeroObservadores();
	
	/**
	 * Cambia el estado del objeto observable y envía la señal de notificación a los objetos observadores, en caso de haberlos.
	 * @param estado Estado en que se quiere poner al objeto observador. 
	 */
	public void asignarEstadoObservable(String estado);
	
}
