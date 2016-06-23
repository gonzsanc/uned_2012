/**
 * 
 */
package establecimientosTodopizza;
import pizzaFactoryMethod.*;
import pizzaFactoryMethod.creadores.*;


/**
 * Superclase para implementar el método abstract factory 
 * @author Gonzalo Sánchez Pla
 * 
 */
public abstract class FactoriaFranquiciasTodopizzaAbstracta extends patronObserver.ObservadorAbstracto {
	
	/**
	 * Atributo de ejemplo que contiene la ubicación de cada franquicia concreta.
	 */
	protected String ubicacion = "Sin determinar";
	
	/**
	 * Método para preparar un pedido de pizza. 
	 * @param tipo define el tipo de pizza que hay que preparar.
	 * @return devuelve una pizza ya lista para llevar.
	 */
	public IPizzaTodopizza prepararBasePizza(TipoPizza tipo){
		
		IPizzaTodopizza pizza;
		
		pizza=crearPizza(tipo);
			
		return pizza;
	}
	
	
	/**
	 * Cada tipo de factoría deberá implementar esta clase.
	 * En caso de que todas o la mayor parte de las factorías creen el mismo tipo de pizza, entonces será mejor implementarla aquí.
	 * Y luego sobreescribir los métodos en la subclase que difiera.
	 * Incorpora el patrón Método Fábrica para la creación de los productos.
	 * @param tipo el tipo de pizza que queremos preparar.
	 * @return un objeto de tipo pizza, según se prepare en cada factoría.
	 */	
	protected IPizzaTodopizza crearPizza(TipoPizza tipo){
		
		//Aplicamos el patrón Factory Method.
		CreadorPizza creador=null;
		
		//Según el tipo de pizza solicitamos, instanciamos el creador correspondiente.
		switch(tipo){
		case Grande:
			creador = new CreadorPizzaGrande();
			break;
		case Mediana:
			creador = new CreadorPizzaMediana();
			break;
		case Pequena:
			creador = new CreadorPizzaPequena();
			break;
		case XL:
			creador = new CreadorPizzaXL();
			break;
		case XXL:
			creador = new CreadorPizzaXXL();
			break;
		}
		
		//Previsión para evitar errores de tipo null reference.
		if (creador!=null){
		return creador.crearPizza();
		}else{
			return null;
		}
	}
	
	/**
	 * Devuelve la ubicación de la Franquicia.
	 * @return Cadena con el tipo (ubicación) de la franquicia.
	 */
	public String obtenerUbicacionFranquicia(){
		return ubicacion;
	}

}
