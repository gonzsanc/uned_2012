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
public final class PizzaPequena extends PizzaTodopizzaAbstracta {

	/**
	 * Constructor.
	 */
	public PizzaPequena(){
		super();
		this.precio=5.00;
		this.tipo=TipoPizza.Pequena;
	}
}
