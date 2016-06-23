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
public final class PizzaXXL extends PizzaTodopizzaAbstracta {

	/**
	 * Constructor.
	 */
	public PizzaXXL() {
		this.precio=25.00;
		this.tipo=TipoPizza.XXL;
	}

}
