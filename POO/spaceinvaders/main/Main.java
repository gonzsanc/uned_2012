package main;

import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;
import observer.gestorCambios.GestorCambiosObserver;
import observer.observable.Observable;
import observer.observador.Observador;
import gestion.GestorJuego;
import gestion.gestores.GestorNaveDefensa;
import gestion.gestores.GestorNavesUFO;

public final class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Main o = new Main();
	}
	
	public Main(){
				
		sigue();
	}
	
	private  void sigue() {
		
		new GestorJuego();
	
	}
}
