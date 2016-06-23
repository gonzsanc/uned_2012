/**
 * 
 */
package pizzaFactoryMethod.creadores;

import pizzaFactoryMethod.CreadorPizza;
import pizzaFactoryMethod.IPizzaTodopizza;
import pizzaFactoryMethod.pizzas.PizzaXXL;

/**
 * Crea (produce) la pizza indicada, según el patrón Factory Method.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class CreadorPizzaXXL extends CreadorPizza {

	/* (non-Javadoc)
	 * @see pizzaFactoryMethod.CreadorPizza#metodoFactory()
	 */
	@Override
	protected IPizzaTodopizza metodoFactory() {
		return new PizzaXXL();
	}

}
