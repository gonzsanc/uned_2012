/**
 * 
 */
package peticiones;


import ingredientesDecorator.IngredienteAbstracto;
import ingredientesDecorator.TiposIngredientes;
import ingredientesDecorator.ingredientes.IngredienteSoloBasePizza;

import java.util.ArrayList;
import java.util.Iterator;


import patronObserver.IObservador;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;
import pizzaFactoryMethod.TipoPizza;
import establecimientosTodopizza.FactoriaFranquiciasTodopizzaAbstracta;
import establecimientosTodopizza.TiposFranquicia;

/**
 * Clase encargada de aceptar las peticiones de los clientes y convertirlas en peticiones a las distintas clases de la fábrica.
 * También cumple una función como gestor del patrón observer, ya que se encarga de suscribir 
 * @author Gonzalo Sánchez Pla.
 */
public class PreparadorPedidos implements Runnable {

	/**
	 * Representa un pedido realizado por un cliente.
	 */
	protected FormularioPedido formulario;
	protected FactoriaFranquiciasTodopizzaAbstracta fabrica;
	protected  pizzaFactoryMethod.PizzaTodopizzaAbstracta pizza;
	protected ingredientesDecorator.IngredienteAbstracto pedido;
	protected IObservador peticionario;
	
	/**
	 * Constructor de la clase.
	 * Al instanciarse, crea un pedido y lo cursa en un hilo independiente.
	 */
	public PreparadorPedidos(FormularioPedido formulario) {
		this.peticionario=formulario.obtenerPeticionario();
		this.formulario=formulario;
		
	}
	
	
	/**
	 * Envía el pedido a la franquicia para que se gestione.
	 */
	public void gestionarPedido(){
		gestionarPedido(formulario.franquicia,formulario.basePizza,formulario.obtenerIngredientes());
	}
	
	/**
	 * Punto de entrada en multihilo.
	 */
	@Override
	public void run() {
		gestionarPedido(formulario.franquicia,formulario.basePizza,formulario.obtenerIngredientes());
		
	}

	
	/**
	 * Inicia el proceso de preparación de un pedido.
	 * @param franquicia - Tipo de franquicia (del catálogo).
	 * @param basePizza - Tipo de pizza del catálogo.
	 * @param ingredientes - Listado de ingredientes que llevará la pizza (pueden repetirse) del catálogo.
	 */
	protected void gestionarPedido(TiposFranquicia franquicia, TipoPizza basePizza, ArrayList<TiposIngredientes> ingredientes){
		asginarFabrica(franquicia);
		crearPizza(basePizza);
		agregarIngredientes(ingredientes);
		if (pedido==null){
			pedido=new IngredienteSoloBasePizza(null);
		}
		pedido.preparar();
	}


	/**
	 * Instancia un objeto que representa la franquicia concreta a la que se va a realizar el pedido.
	 * @param franquicia - Una franquicia del catálogo de franquicias.
	 */
	private void asginarFabrica(TiposFranquicia franquicia) {
		switch (franquicia){
		case barcelona:
			fabrica = new establecimientosTodopizza.franquicias.FactoriaBarcelona();
		break;
		case bilbao:
			fabrica = new establecimientosTodopizza.franquicias.FactoriaBilbao();
			break;
		case guadalajara:
			fabrica = new establecimientosTodopizza.franquicias.FactoriaGuadalajara();
			break;
		case madrid:
			fabrica = new establecimientosTodopizza.franquicias.FactoriaMadrid();
			break;
		case tarragona:
			fabrica = new establecimientosTodopizza.franquicias.FactoriaTarragona();
			break;
		}
	}
	
	/**
	 * Crea la base de la pizza y adscribe al peticionario a la misma.
	 * @param basePizza
	 */
	private void crearPizza(TipoPizza basePizza) {
		pizza=(PizzaTodopizzaAbstracta) fabrica.prepararBasePizza(basePizza);
		pizza.adscribir(peticionario);
	}


	/**
	 * Lee el pedido y añade uno a uno los ingredientes a la pizza.
	 * Cuando añade el primer ingrediente lo marca como el primero, por si en un caso es necesario
	 * recorrer la secuencia, se pueda saber cuál es el último ingrediente (sin contar la pizza).
	 * @param ingredientes - Listado de ingredientes (del enumerado TiposIngredientes).
	 */
	private void agregarIngredientes(ArrayList<TiposIngredientes> ingredientes) {
		Iterator<TiposIngredientes> it = ingredientes.iterator();
		
	
		if (it.hasNext()){
			this.agregarUnIngrediente(pizza, it.next());
			pedido.establecerPrimero();
		}
		
		while (it.hasNext()){
			this.agregarUnIngrediente(pedido, it.next());
		}
		
	}
	
	
	/**
	 * Agrega un ingrediente suscribiendo al peticionario como observador al decorador, de manera que sea notificado de los cambios de estado del pedido.
	 * El peticionario normalmente será el cliente (front-end) de la aplicación que el usuario manipula. 
	 * @param componente pizza o componente que se va a decorar con un ingrediente adicional.
	 * @param ingredienteEnvolvente Tipo de ingrediente (enumerado) que hay que añadir al componente.
	 */
	private void agregarUnIngrediente(PizzaTodopizzaAbstracta componente, TiposIngredientes ingredienteEnvolvente){
		switch (ingredienteEnvolvente){
		case aceitunas:
			pedido = new ingredientesDecorator.ingredientes.IngredienteAceitunas(componente);
			break;
		case anchoas:
			pedido = new ingredientesDecorator.ingredientes.IngredienteAnchoas(componente);
			break;
		case bacon:
			pedido = new ingredientesDecorator.ingredientes.IngredienteBacon(componente);
		break;
		case carne:
			pedido = new ingredientesDecorator.ingredientes.IngredienteCarne(componente);
			break;
		case extraQueso:
			pedido = new ingredientesDecorator.ingredientes.IngredienteExtraDeQueso(componente);
			break;
		case pimientos:
			pedido = new ingredientesDecorator.ingredientes.IngredientePimientos(componente);
			break;
		case pina:
			pedido = new ingredientesDecorator.ingredientes.IngredientePina(componente);
			break;
		case pollo:
			pedido = new ingredientesDecorator.ingredientes.IngredientePollo(componente);
			break;
		case salami:
			pedido = new ingredientesDecorator.ingredientes.IngredienteSalami(componente);
			break;
		}
		pedido.adscribir(peticionario);
	}


}



