/**
 * 
 */
package pizzaFactoryMethod;

import patronObserver.SujetoAbstracto;
import peticiones.TiposEstadosPreparacion;

/**
 * Superclase para las pizzas. Facilita la implementación básica de la interfaz IPizzaTodopizza en los casos
 * que sea mejor la herencia.
 * @author Gonzalo Sánchez Pla.
 */
public abstract  class PizzaTodopizzaAbstracta extends SujetoAbstracto implements IPizzaTodopizza{

	/**
	 * El tipo de pizza.
	 */
	protected TipoPizza tipo;
	
	/**
	 * Precio de este tipo de pizza.
	 */
	protected double precio;
	
	/**
	 * Estado de la pizza en el proceso de preparación.
	 */
	protected TiposEstadosPreparacion estado;
	
	/**
	 * Constructor
	 */
	public PizzaTodopizzaAbstracta(){
		tipo=TipoPizza.pendienteAsignacion;
		estado=TiposEstadosPreparacion.sinPreparar;
		precio=0;
	}
	
	
	/* (non-Javadoc)
	 * @see Pizzas.IPizzaTodopizza#asginarEstado()
	 */
	@Override
	public void asginarEstado(TiposEstadosPreparacion estado){
		this.estado=estado;
	}
	
	/* (non-Javadoc)
	 * @see Pizzas.IPizzaTodopizza#obtenerPrecio()
	 */
	@Override
	public double obtenerPrecio() {
		return precio;
	}

	/* (non-Javadoc)
	 * @see Pizzas.IPizzaTodopizza#asignarPrecio(double)
	 */
	@Override
	public void asignarPrecio(double precio) {
		this.precio=precio;

	}

	/* (non-Javadoc)
	 * @see Pizzas.IPizzaTodopizza#preparar()
	 */
	@Override
	public void preparar() {

		this.estado=TiposEstadosPreparacion.sinPreparar;
		notificar();
		
		this.prepararIngredientes();
		this.cocinarEnHorno();
		this.cortarEnPorciones();
		this.empaquetarPizza();
		
		this.estado=TiposEstadosPreparacion.pizzaPreparada;
		notificar();
	}
	
	
	/**
	 * Primera fase de preparación de las pizzas.
	 */
	protected void prepararIngredientes(){
		this.asginarEstado(TiposEstadosPreparacion.preparandoIngredientes);
		//System.out.println("Preparando ingredientes...");
		notificar();
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Segunda fase de preparación de las pizzas.
	 */
	protected void cocinarEnHorno(){
		this.asginarEstado(TiposEstadosPreparacion.cocinandoEnHorno);
		//System.out.println("Cocinando en horno...");
		notificar();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	/**
	 * Tercera fase de preparación de las pizzas.
	 */
	protected void cortarEnPorciones(){
		this.asginarEstado(TiposEstadosPreparacion.cortandoEnPorciones);
		//System.out.println("Cortando pizza en porciones...");
		notificar();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Cuarta fase de preparación de las pizzas.
	 */
	protected void empaquetarPizza(){
		this.asginarEstado(TiposEstadosPreparacion.empaquetandoPizza);
		//System.out.println("Empaquetando Pizza...");
		notificar();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public TiposEstadosPreparacion obtenerEstado() {
		return this.estado;
	}
}
