/**
 * 
 */
package patronObserver;
import java.util.HashSet;
import java.util.Iterator;
/**
 * Implementa una versión básica y funcional de la clase Sujeto Observable del patrón Observer.
 * @author Gonzalo Sánchez Pla.
 *
 */
public abstract class SujetoAbstracto implements ISujeto {

	/**
	 * Conjunto de elementos observadores adscritos a este objeto.
	 * Se utiliza la clase HashSet para conseguir mayor renidimiento en un conjunto donde los elementos no se repiten.
	 */
	protected HashSet<IObservador> observadores = new HashSet<IObservador>();
	

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
	 * @see patronObserver.ISujeto#numeroObservadores()
	 */
	@Override
	public int numeroObservadores(){
		return observadores.size();
	}


}
