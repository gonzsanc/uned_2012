/**
 * 
 */
package ingredientesDecorator.ingredientes;

import ingredientesDecorator.IngredienteAbstracto;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;

/**
 * Componente del tipo de ingrediente descrito.
 * @author Gonzalo Sánchez Pla.
 */
public final class IngredientePollo extends IngredienteAbstracto {

	/**
	 * Constructor.
	 * @param componente - componente al que se envolverá.
	 */
	public IngredientePollo(PizzaTodopizzaAbstracta componente) {
		super(componente);
		precio=1.00;
	}

}

