package observer.gestorCambios;

import java.util.HashSet;

import observer.IObservable;
import observer.IObservador;
import observer.observador.Observador;


public class GestorCambiosObserver extends Observador {

	
	private static  HashSet <ParObservadorObservable> pares;
	private static GestorCambiosObserver gestor=null;
	
	public GestorCambiosObserver(){
		pares = new HashSet<ParObservadorObservable>();
	}
	
	private static void crearSingleton(){
		if (gestor==null){
			gestor = new GestorCambiosObserver();
		}
	}
	
	public static void adscribirObservadorObservable(IObservador observador,IObservable sujeto){
		crearSingleton();
		if (!existeRelacionEntre(observador,sujeto)){
			pares.add(new ParObservadorObservable(observador,sujeto));
		}
		sujeto.adscribir(gestor);
		
	}

	
	public static void quitarObservadorObservable(IObservador observador,IObservable sujeto){
		crearSingleton();
		for (ParObservadorObservable par : pares){
			if (par.getObservable()==sujeto && par.getObservador()==observador){
				par.incomunicarElementos();
				pares.remove(par);
				break;
			}
		}
	
	if (!existeSujetoObservador(sujeto)){
		sujeto.quitar(gestor);
	}
	
}

	private static boolean existeRelacionEntre(IObservador observador,IObservable sujeto){
		boolean retorno = false;
		
		for (ParObservadorObservable par : pares){
			if (par.getObservable()==sujeto && par.getObservador()==observador){
				retorno=true;
				break;
			}
		}
		
		return retorno;
	}
	
	
	
	private static boolean existeSujetoObservador(IObservable sujeto) {
		boolean retorno = false;
		for (ParObservadorObservable par:pares){
			if (par.getObservable()==sujeto){
				retorno=true;
				break;
			}
		}
		return retorno;
	}

	public static int count(){
		return pares.size();
	}

}
