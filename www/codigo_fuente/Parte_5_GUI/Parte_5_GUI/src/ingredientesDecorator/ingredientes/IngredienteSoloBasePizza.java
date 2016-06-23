/**
 * 
 */
package ingredientesDecorator.ingredientes;

import peticiones.TiposEstadosPreparacion;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;
import ingredientesDecorator.IngredienteAbstracto;

/**
 * Clase que facilita un workaround para preparar pedidos cuando no tenemos ingredientes, sino solo base de pizza.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class IngredienteSoloBasePizza extends IngredienteAbstracto {

	public IngredienteSoloBasePizza(PizzaTodopizzaAbstracta componente) {
		super(componente);
	}

	/* (non-Javadoc)
	 * @see ingredientesDecorator.IngredienteAbstracto#obtenerPrecio()
	 */
	@Override
	public double obtenerPrecio() {
		return this.precio;
	}

	/* (non-Javadoc)
	 * @see ingredientesDecorator.IngredienteAbstracto#obtenerComponente()
	 */
	@Override
	public PizzaTodopizzaAbstracta obtenerComponente() {
		return this;
	}

	/* (non-Javadoc)
	 * @see ingredientesDecorator.IngredienteAbstracto#esElPrimero()
	 */
	@Override
	public boolean esElPrimero() {
		return true;
	}

	/* (non-Javadoc)
	 * @see ingredientesDecorator.IngredienteAbstracto#establecerPrimero()
	 */
	@Override
	public void establecerPrimero() {

	}

	/* (non-Javadoc)
	 * @see ingredientesDecorator.IngredienteAbstracto#asginarEstado(peticiones.TiposEstadosPreparacion)
	 */
	@Override
	public void asginarEstado(TiposEstadosPreparacion estado) {
		this.estado=estado;
	}

}
