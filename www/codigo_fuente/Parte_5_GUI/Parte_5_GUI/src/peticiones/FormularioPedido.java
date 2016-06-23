package peticiones;

import ingredientesDecorator.TiposIngredientes;

import java.util.ArrayList;

import establecimientosTodopizza.TiposFranquicia;

import patronObserver.IObservador;
import pizzaFactoryMethod.TipoPizza;

/**
 * Representa el pedido realizado por un cliente.
 * La fábrica de pizzas debe ser capaz de interpretarlo o bien de ejecutarlo.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class FormularioPedido {
	
	
	/**
	 * Sujeto que realiza el pedido.
	 */
	protected IObservador peticionario;
	/**
	 * Tipo de franquicia
	 */
	protected TiposFranquicia franquicia;
	/**
	 * Tipo de pizza.
	 */
	protected pizzaFactoryMethod.TipoPizza basePizza;
	/**
	 * Listado de todos los ingredientes del pedido.
	 */
	protected ArrayList<TiposIngredientes> ingredientes;
	
	
	/**
	 * Constructor
	 */
	public FormularioPedido(IObservador peticionario){
		this.peticionario=peticionario;
		ingredientes = new ArrayList<TiposIngredientes>();
	}
	
	
	/**
	 * Asigna el tipo de franquicia.
	 * @param franquicia
	 */
	public void asginarFranquicia(TiposFranquicia franquicia){
		this.franquicia=franquicia;
	}	

	/**
	 * Devuelve la franquicia a la que se realiza el pedido.
	 * @return - Clase de tienda de la franquicia (TiposFranquicia)
	 */
	public TiposFranquicia obtenerFranquicia(){
		return this.franquicia;
	}
	
	/**
	 * Asigna el tipo de pizza que se va a preparar.
	 * @param basePizza pizza dentro del catálogo de Todopizza.
	 */
	public void asignarTipoPizza(TipoPizza basePizza){
		this.basePizza=basePizza;
	}
	
	/**
	 * Devuelve el tipo de pizza que se va a preparar.
	 * @return TipoPizza - tipo de pizza del catálogo de pizzas.
	 */
	public TipoPizza obtenerTipoPizza(){
		return this.basePizza;
	}
	
	/**
	 * Añade un ingrediente (pueden repetirse) a la base de la pizza.
	 * @param  ingrediente - ingrediente Ha de ser uno de los definidos en el catálogo de ingredientes de Todopizza.
	 */
	public void agregarIngrediente(TiposIngredientes ingrediente){
		ingredientes.add(ingrediente);
	}
	
	
	/**
	 * Devuelve el listado completo de los ingredientes asignados hasta el momento.
	 * @return ArrayList con la lista completa de ingredientes por tipo.
	 */
	public ArrayList<TiposIngredientes>  obtenerIngredientes(){
		return ingredientes;
	}

	
	/**
	 * Elimina una unidad de ingrediente de la lista de ingredientes.
	 * @param ingrediente El tipo de ingrediente a eliminar.
	 */
	public void quitarIngrediente(TiposIngredientes ingrediente){
		
		int i=0;
		boolean salir=false;
		
		while (i<ingredientes.size() && !salir){
			
			if (ingredientes.get(i)==ingrediente){
				ingredientes.remove(i);
				salir=true;
			}
			i++;
		}
		
	}
	
	
	/**
	 * Elimina todos los ingredientes del tipo indicado en el parámetro.
	 * @param ingrediente El tipo de ingrediente a quitar de la pizza.
	 */
	public void quitarTodosIngredientes(TiposIngredientes ingrediente){
		for (int i=0;i<ingredientes.size();i++ ){
			
			if (ingredientes.get(i)==ingrediente) {
				ingredientes.remove(i);
				i--;
			}
		}
	}


	/**
	 * Devuelve una referencia al objeto que realiza el pedido.
	 * @return peticionario - objeto de tipo IObservador 
	 */
	public IObservador obtenerPeticionario() {
		return this.peticionario;
	}
}
