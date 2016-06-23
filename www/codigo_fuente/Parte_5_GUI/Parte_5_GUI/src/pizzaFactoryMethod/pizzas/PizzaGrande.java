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
public final class PizzaGrande extends PizzaTodopizzaAbstracta{

	/**
	 * Constructor.
	 */
	public PizzaGrande() {
		this.precio=15.00;
		this.tipo=TipoPizza.Grande;
	}

}
