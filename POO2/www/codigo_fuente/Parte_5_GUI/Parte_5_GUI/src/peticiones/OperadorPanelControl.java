package peticiones;

import establecimientosTodopizza.TiposFranquicia;
import ingredientesDecorator.IngredienteAbstracto;
import ingredientesDecorator.TiposIngredientes;
import patronObserver.IObservador;
import patronObserver.ObservadorAbstracto;
import pizzaFactoryMethod.TipoPizza;
import GUI.FrameBaseTodopizza;

/**
 * Gestiona los pedidos realizados a través de la interfaz gráfica de Todopizza.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class OperadorPanelControl extends ObservadorAbstracto {

	private FrameBaseTodopizza ff; //IGU
	private FormularioPedido pedido; //Objeto pedido para todopizza.
	private TipoPizza tipoPizza;
	private String pizzaSolicitada;
	private IngredienteAbstracto ingredientes;
	private TiposFranquicia tipoFanquicia;
	

	/**
	 * Constructor
	 */
	public OperadorPanelControl(){
		ff=null;
	}
	
	/**
	 * Constructor
	 */
	public OperadorPanelControl(FrameBaseTodopizza FrameFormulario){
		this.ff=FrameFormulario;
	}

	/**
	 * Procesa el pedido. Como parámetro hay que insertar el peticionario.
	 * @param peticionario
	 * @return boolean
	 */
	public boolean procesar(IObservador peticionario){
		procesarFramePeticionesTodopizza(peticionario);
		Thread th = new Thread(new PreparadorPedidos(pedido));
		th.start();
		return true;
	}

	
	/**
	 * @return frameFormulario
	 */
	public FrameBaseTodopizza getFrameFormulario() {
		return ff;
	}

	/**
	 * @param frameFormulario the frameFormulario a asignar.
	 */
	public void setFrameFormulario(FrameBaseTodopizza frameFormulario) {
		ff = frameFormulario;
	}
	

	/**
	 * Lanza el proceso de gestión de un pedido y adscribe un oyente al curso del mismo.
	 * @param peticionario
	 */
	private void procesarFramePeticionesTodopizza(IObservador peticionario) {
	
		pedido = new FormularioPedido(peticionario);
		tipoFanquicia = obtenerTipoFranquicia(ff.getCmbFranquicias().getSelectedItem().toString());
		pizzaSolicitada=ff.obtenerPizzaActiva();
		tipoPizza = obtenerTipoPizza(pizzaSolicitada);
		
		if (tipoPizza!=null && tipoFanquicia!=null){
			pedido.asginarFranquicia(tipoFanquicia);
			pedido.asignarTipoPizza(tipoPizza);
			prepararIngredientes();
			
		}
	
	}

	/**
	 * Interpreta el combo del Frame y lo traduce al tipo utilizado por la lógica de negocio.
	 * @param franquicia El valor del combo (su texto, no el índice).
	 * @return Tipo de franquicia
	 */
	private TiposFranquicia obtenerTipoFranquicia(String franquicia) {
	
		TiposFranquicia tipof;
		
		if (franquicia=="Barcelona"){
			tipof=TiposFranquicia.barcelona;
		}
		
		
		else
		if (franquicia=="Bilbao"){
			tipof=TiposFranquicia.bilbao;
		}
		
		
		else
		if (franquicia=="Guadalajara"){
			tipof=TiposFranquicia.guadalajara;
		}
		
		
		else
		if (franquicia=="Madrid"){
			tipof=TiposFranquicia.madrid;
		}
		
		
		else
			if (franquicia=="Tarragona"){
				tipof=TiposFranquicia.tarragona;
			}
		
		
		else{
			tipof=null;
		}
		
		
		return tipof;
	}

	/**
	 * Agrega al pedido los ingredientes del Frame de la IGU de Todopizza.
	 */
	private void prepararIngredientes() {
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadAceitunas().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.aceitunas);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadAnchoas().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.anchoas);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadBacon().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.anchoas);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadCarne().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.carne);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadExtraQueso().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.extraQueso);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadPimientos().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.pimientos);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadPina().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.pina);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadPollo().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.pollo);
		}
		
		for (int i=0;i<Integer.parseInt(this.ff.getTxtCantidadSalami().getText());i++){
			this.pedido.agregarIngrediente(TiposIngredientes.salami);
		}
		
		
	}

	
	/**
	 * Lee el Frame de Todopizza y extrae el tipo de pizza seleccionado.
	 * @param pizzaSolicitada el texto del elemento de lista seleccionado en el Frame de la IGU de Todopizza.
	 * @return Tipo de pizza Tipo de pizza.
	 */
	private TipoPizza obtenerTipoPizza(String pizzaSolicitada) {
		TipoPizza tipo;
		if (pizzaSolicitada=="Pequeña"){
			tipo = TipoPizza.Pequena;
		}else 
			if (pizzaSolicitada=="Mediana"){
				tipo = TipoPizza.Mediana;
		}else 
			if (pizzaSolicitada=="Grande"){
				tipo = TipoPizza.Grande;
		}else 
			if (pizzaSolicitada=="XL"){
				tipo = TipoPizza.XL;
		}else 
			if (pizzaSolicitada =="XXL"){
				tipo = TipoPizza.XXL;
		}
			else{
				tipo = null;
		}
		
		return tipo;
	}
}
