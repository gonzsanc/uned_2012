package pizzaFactoryMethod;

import peticiones.TiposEstadosPreparacion;

/**
 * Interfaz para la clase de objetos tipo Pizza.
 * Su función será representar una base de pizza la cual entrará en un proceso de pedido.
 * @author Gonzalo Sánchez Pla.
 *
 */
public interface IPizzaTodopizza {
		
		/**
		 * Devuelve el precio del objeto.
		 * @return precio del objeto.
		 */
		public double obtenerPrecio();
		
		/**
		 * Permite modificar el precio del objeto.
		 * @param precio Precio del objeto.
		 */
		public void asignarPrecio(double precio);
		
		/**
		 * Prepara la el pedido de pizza.
		 * Aunque en principio parece que este método no debería residir en el mismo objeto que es preparado,
		 * se trata de una previsión para implementar el patrón decorator y tratar al objeto como un pedido.
		 * Un pedido sí que debe implementar un proceso de preparación.
		 */
		public void preparar();
		
		/**
		 * En cada estadio de la preparación de una pizza hay que definir dicho estado mediante este método.
		 * @param estado - Tipo TiposEstadosPreparacion del catálogo de estados de preparación de pizza.
		 */
		public void asginarEstado(TiposEstadosPreparacion estado);
		
		/**
		 * Devuelve el estado de la pizza durante su preparación.
		 * @return estado - Objeto de tipo TiposEstadosPreparacion
		 */
		public TiposEstadosPreparacion obtenerEstado();
		
		
}
