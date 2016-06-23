package main;

import patronObserver.ISujeto;
import patronObserver.ObservadorAbstracto;
import peticiones.TiposEstadosPreparacion;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;
import GUI_Business.VentanaTodopizza;

/**
 * Clase de prueba para la quinta parte de la práctica (Interfaz Gráfica de Usuario).
 * Lanza la misma y abre la ventana principal con una sola sentencia.
 * @author Gonzalo Sánchez Pla.
 */

public class Main {

	public static void main(String [] args){
		new Main();
	}
	
	/**
	 * Crea una instancia del formulario principal y lanza la aplicación.
	 */
	public Main(){
		new VentanaTodopizza().setVisible(true);
	}	
}
