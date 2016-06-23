/**
 * 
 */
package pizzaFactoryMethod.creadores;

import pizzaFactoryMethod.CreadorPizza;
import pizzaFactoryMethod.IPizzaTodopizza;
import pizzaFactoryMethod.pizzas.PizzaPequena;

/**
 * Crea (produce) la pizza indicada, según el patrón Factory Method.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class CreadorPizzaPequena extends CreadorPizza {

	/**
	 * 
	 */
	public CreadorPizzaPequena() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see pizzaFactoryMethod.CreadorPizza#metodoFactory()
	 */
	@Override
	protected IPizzaTodopizza metodoFactory() {
		return new PizzaPequena();
	}

}
