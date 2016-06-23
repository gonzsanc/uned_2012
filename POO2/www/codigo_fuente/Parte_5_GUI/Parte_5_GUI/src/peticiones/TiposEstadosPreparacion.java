package peticiones;

/**
 * Catálogo de estados de preparación de pedido en los que un producto puede encontrarse.
 * @author Gonzalo Sánchez Pla.
 *
 */
public enum TiposEstadosPreparacion {
	sinPreparar,
	preparandoIngredientes,
	cocinandoEnHorno,
	cortandoEnPorciones,
	empaquetandoPizza,
	pizzaPreparada
}
