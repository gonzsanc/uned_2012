package ingredientesDecorator;

import peticiones.TiposEstadosPreparacion;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;

/**
 * Representa un decorador, cuyos componentes son las pizzas y los ingredientes de las mismas.
 * Se encargará de envolver al componente que decore mediante el patrón "Decorator".
 * @author Gonzalo Sánchez Pla.
 *
 */
public  class IngredienteAbstracto extends PizzaTodopizzaAbstracta {
	
	private boolean primero=false;
	
	/**
	 * Componente que será decorado.
	 */
	protected PizzaTodopizzaAbstracta componente;
	
	/**
	 * Constructor en el que hay que enviar el componente a decorar como parámetro.
	 * @param componente objeto para decorar.
	 */
	public IngredienteAbstracto(PizzaTodopizzaAbstracta componente){
		this.componente=componente;
	}
	
	/**
	 * Devuelve el precio del objeto más el del objeto al que envuelve.
	 */
	@Override
	public double obtenerPrecio() {
		return componente.obtenerPrecio() + this.precio;
	}

	/**
	 * Devuelve una referencia al componente al que envuelve.
	 * @return objeto tipo PizzaTodopizzaAbstracta
	 */
	public PizzaTodopizzaAbstracta obtenerComponente(){
		return componente;
	}	

	
//	
//	@Override
//	public void preparar() {
//		// TODO Auto-generated method stub
//		componente.preparar();
//	}
	
	
	/**
	 * Consulta al objeto si es el primer componente decorador de la secuencia, después de la base de pizza.
	 * @return boolean true/false
	 */
	public boolean esElPrimero(){
		return primero;
	}
	
	/**
	 * Marca el componente primero como el primero de la secuencia de componentes decoradores.
	 * Sólo puede haber un componente que sea el primero y los componentes se agregan secuencialmente, por lo que esta operación no puede deshacerse.
	 */
	public void establecerPrimero(){
		this.primero=true;
	}
	
	/**
	 * Cambia el estado de todos los componentes a partir de éste (incluyendo la base de la pizza).
	 * @param estado - El tipo TiposEstadosPreparacion al que hay que cambiar los componentes.
	 */
	public void asginarEstado(TiposEstadosPreparacion estado){
		componente.asginarEstado(estado);
		this.estado=estado;
	}
	
}
