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
public final class PizzaXL extends PizzaTodopizzaAbstracta{

	/**
	 * Constructor
	 */
	public PizzaXL() {
		this.precio=20.00;
		this.tipo=TipoPizza.XL;
	}

}
