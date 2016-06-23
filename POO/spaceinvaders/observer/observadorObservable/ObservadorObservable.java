/**
 * 
 */
package observer.observadorObservable;

import java.util.HashSet;
import java.util.Iterator;

import observer.IObservable;
import observer.IObservador;
import observer.observable.Observable;
import observer.observador.Observador;


/**
 * Implementa las funciones de observador y observable a la vez.
 * Como workaround a no poder realizar herencia múltiple en una sola clase lo que se hace es
 * implementar las dos interfaces de IObservador e IObservable, pero en vez de reescribir el código,
 * se sobreescriben los métodos delegando en dos objetos instanciados a partir de las clases
 * Observador y Observable, y haciendo referencia a los métodos de estas clases en vez de volver a escribirlos o copiarlos.
 * Este enfoque permite que ante un cambio de implementación, sólo haya que modificar signaturas, nombres de métodos y poco más.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class ObservadorObservable implements IObservador, IObservable {

	private Observador o;
	private Observable s;
	
	
	public ObservadorObservable(){
		o = new Observador();
		s = new Observable();
	}
	
	public HashSet<IObservador> getObservadores(){
		return s.getObservadores();
	}
	
	// *** OBSERVADOR ***
	
	/* (non-Javadoc)
	 * @see patronObserver.IObservador#actualizar(patronObserver.ISujeto)
	 */
	@Override
	public void actualizar(IObservable sujeto) {
		o.actualizar(sujeto);
	}
	
	// *** OBSERVABLE ***

	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#adscribir(patronObserver.IObservador)
	 */
	@Override
	public void adscribir(IObservador observador) {
		s.adscribir(observador);

	}

	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#quitar(patronObserver.IObservador)
	 */
	@Override
	public void quitar(IObservador observador) {
		s.quitar(observador);
	}

	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#notificar()
	 */
	@Override
	public void notificar() {
		s.notificar();
	}

	/* (non-Javadoc)
	 * @see patronObserver.ISujeto#obtenerEstado()
	 */
	@Override
	public Object obtenerEstadoObservable() {
		return s.obtenerEstadoObservable();
	}
	
	public int numeroObservadores(){
		return s.numeroObservadores();
	}

	public void asignarEstadoObservable(String estado){
		s.asignarEstadoObservable(estado);
	}

	@Override
	public String getOrigen() {
		return s.getOrigen();
		
	}

	@Override
	public void setOrigen(String origen) {
		s.setOrigen(origen);
		
	}

	@Override
	public String getAccion() {
		return s.getAccion();
	}

	@Override
	public void setAccion(String accion) {
		s.setAccion(accion);
		
	}

}
