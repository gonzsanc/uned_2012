package pizzaFactoryMethod;

/**
 * Clase creadora de pizzas, representa la implementación del patrón Factory Method.
 * @author Gonzalo Sánchez Pla.
 *
 */
public abstract class CreadorPizza {
	
	/**
	 * Devuelve la pizza que el creador concreto produce.
	 * @return pizza del tipo concreto.
	 */
	public IPizzaTodopizza crearPizza(){
		return metodoFactory();
	}

	/**
	 * Cada creador concreto tiene que implementar este método para que devuelva el tipo de pizza que 
	 * cada creador produce.
	 * @return Objeto pizza.
	 */
	protected abstract IPizzaTodopizza metodoFactory();
}
