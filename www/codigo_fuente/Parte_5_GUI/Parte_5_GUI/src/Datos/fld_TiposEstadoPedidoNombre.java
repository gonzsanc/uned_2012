package Datos;
import java.util.HashMap;
import peticiones.TiposEstadosPreparacion;

/**
 * El paquete Datos simula separación de la capa de datos del resto, un patrón de diseño típico en la actualidad.
 * Para poder implementarlo de manera sencilla, simulo tanto el SGBD como los datos mismos en el concepto de la clase.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class fld_TiposEstadoPedidoNombre {


	
	//Este objeto albergará una lista de pares con el tipo de ingrediente y su precio.
	private static HashMap<TiposEstadosPreparacion,String> tabla=null;
	
	/**
	 * Traduce los estados de preparación que utiliza la lógica del programa a una cadena legible.
	 * @param tipo tipo de estado.
	 * @return Cadena de texto.
	 */
	public static String obtenerNombre(TiposEstadosPreparacion tipo){
			if (tabla==null){
				tabla = new HashMap<TiposEstadosPreparacion,String>();
				insertIntoTabla();
			}
		return selectPrecioWhereTipoEquals(tipo);
	}
	
	/**
	 * Simula una sentencia contra una base de datos.
	 * En una base de datos tendríamos que implementar una sentencia tipo:
	 * INSERT INTO tbl_PreciosIngredientes VALUES ('aceitunas',.5) , etc...
	 */
	private static void insertIntoTabla() {
		
		tabla.put(TiposEstadosPreparacion.cocinandoEnHorno,	"horneando pizza");
		tabla.put(TiposEstadosPreparacion.cortandoEnPorciones,"cortando pizza en porciones");
		tabla.put(TiposEstadosPreparacion.empaquetandoPizza,"empaquetando la pizza");
		tabla.put(TiposEstadosPreparacion.pizzaPreparada,"pizza preparada");
		tabla.put(TiposEstadosPreparacion.preparandoIngredientes,"preparando los ingredientes");
		tabla.put(TiposEstadosPreparacion.sinPreparar,"pizza sin preparar");
	}

	
	/**
	 * Simula una llamada a una base de datos.
	 * En una base de datos tendríamos que implementar una sentencia tipo:
	 * SELECT precio FROM tbl_PrecioIngredientes where idTipo = tipo
	 */
	private static String  selectPrecioWhereTipoEquals(TiposEstadosPreparacion tipo){
		return tabla.get(tipo).toString();
	}
	
}
