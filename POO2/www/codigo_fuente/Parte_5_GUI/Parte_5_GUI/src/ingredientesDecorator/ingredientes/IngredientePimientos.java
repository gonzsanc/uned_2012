/**
 * 
 */
package ingredientesDecorator.ingredientes;

import ingredientesDecorator.IngredienteAbstracto;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;

/**
 * Componente del tipo de ingrediente descrito.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class IngredientePimientos extends IngredienteAbstracto {

	/**
	 * Constructor.
	 * @param componente - componente al que se envolverá.
	 */
	public IngredientePimientos(PizzaTodopizzaAbstracta componente) {
		super(componente);
		precio=0.25;
	}

}


