package observer.gestorCambios;

import observer.IObservable;
import observer.IObservador;

public final class ParObservadorObservable {
	
	private IObservable observable;
	private IObservador observador;
	
	public ParObservadorObservable(){}
	
	public ParObservadorObservable (IObservador observador,IObservable sujeto){
		this.observable=sujeto;
		this.observador=observador;
		comunicarElementos();
	}
	
	public void comunicarElementos(){
		this.observable.adscribir(observador);
	}
	
	public void incomunicarElementos(){
		this.observable.quitar(observador);
	}
	
	/**
	 * @return the observable
	 */
	public IObservable getObservable() {
		return observable;
	}
	/**
	 * @param observable the observable to set
	 */
	public void setObservable(IObservable observable) {
		this.observable = observable;
	}
	/**
	 * @return the observador
	 */
	public IObservador getObservador() {
		return observador;
	}
	/**
	 * @param observador the observador to set
	 */
	public void setObservador(IObservador observador) {
		this.observador = observador;
	}
	
	
	
	

}
