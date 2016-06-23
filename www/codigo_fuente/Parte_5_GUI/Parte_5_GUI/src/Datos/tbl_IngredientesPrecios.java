/**
 * 
 */
package Datos;
import java.util.HashMap;
import ingredientesDecorator.TiposIngredientes;

/**
 * El paquete Datos simula separación de la capa de datos del resto, un patrón de diseño típico en la actualidad.
 * Para poder implementarlo de manera sencilla, simulo tanto el SGBD como los datos mismos en el concepto de la clase.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class tbl_IngredientesPrecios {


	
	//Este objeto albergará una lista de pares con el tipo de ingrediente y su precio.
	private static HashMap<TiposIngredientes,Double> tbl_PreciosIngredientes=null;
	
	/**
	 * Devuelve el precio de un ingrediente según su tipo.
	 * @param tipo Tipo de ingrediente.
	 * @return Precio del ingrediente.s
	 */
	public static double obtenerPrecio(TiposIngredientes tipo){
			if (tbl_PreciosIngredientes==null){
				tbl_PreciosIngredientes = new HashMap<TiposIngredientes,Double>();
				insertInto_tbl_PreciosIngredientesValues();
			}
		return selectPrecioWhereTipoEquals(tipo);
	}
	
	/**
	 * Simula una sentencia contra una base de datos.
	 * En una base de datos tendríamos que implementar una sentencia tipo:
	 * INSERT INTO tbl_PreciosIngredientes VALUES ('aceitunas',.5) , etc...
	 */
	private static void insertInto_tbl_PreciosIngredientesValues() {
		
		tbl_PreciosIngredientes.put(TiposIngredientes.aceitunas,	.5);
		tbl_PreciosIngredientes.put(TiposIngredientes.anchoas,		.75);
		tbl_PreciosIngredientes.put(TiposIngredientes.bacon,		.75);
		tbl_PreciosIngredientes.put(TiposIngredientes.carne,		1d);
		tbl_PreciosIngredientes.put(TiposIngredientes.extraQueso,	.5);
		tbl_PreciosIngredientes.put(TiposIngredientes.pimientos,	.25);
		tbl_PreciosIngredientes.put(TiposIngredientes.pina,			.25);
		tbl_PreciosIngredientes.put(TiposIngredientes.pollo,		1d);
		tbl_PreciosIngredientes.put(TiposIngredientes.salami,		.5);
	}

	
	/**
	 * Simula una llamada a una base de datos.
	 * En una base de datos tendríamos que implementar una sentencia tipo:
	 * SELECT precio FROM tbl_PrecioIngredientes where idTipo = tipo
	 */
	private static double  selectPrecioWhereTipoEquals(TiposIngredientes tipo){
		return tbl_PreciosIngredientes.get(tipo).doubleValue();
	}
	
}
