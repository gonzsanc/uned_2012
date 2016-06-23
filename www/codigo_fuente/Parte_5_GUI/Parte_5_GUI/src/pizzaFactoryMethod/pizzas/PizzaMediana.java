/**
 * 
 */
package pizzaFactoryMethod.pizzas;

import pizzaFactoryMethod.PizzaTodopizzaAbstracta;
import pizzaFactoryMethod.TipoPizza;

/**
 * Clase de pizza concreta del tipo indicado, que representa una pizza según el patrón abstract factory.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class PizzaMediana extends PizzaTodopizzaAbstracta {

	/**
	 * Constructor
	 */
	public PizzaMediana() {
		super();
		this.tipo=TipoPizza.Mediana;
		this.precio=10.00;		
		// TODO Auto-generated constructor stub
	}

}
