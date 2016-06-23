/**
 * 
 */
package pizzaFactoryMethod.creadores;

import pizzaFactoryMethod.CreadorPizza;
import pizzaFactoryMethod.IPizzaTodopizza;
import pizzaFactoryMethod.pizzas.PizzaXL;

/**
 * Crea (produce) la pizza indicada, según el patrón Factory Method.
 * @author Gonzalo Sánchez Pla.
 */
public final class CreadorPizzaXL extends CreadorPizza {

	/* (non-Javadoc)
	 * @see pizzaFactoryMethod.CreadorPizza#metodoFactory()
	 */
	@Override
	protected IPizzaTodopizza metodoFactory() {
		return new PizzaXL();
	}

}
