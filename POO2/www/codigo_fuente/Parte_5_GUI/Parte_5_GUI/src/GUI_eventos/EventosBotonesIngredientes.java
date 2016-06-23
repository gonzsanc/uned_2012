/**
 * 
 */
package GUI_eventos;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Datos.tbl_IngredientesPrecios;
import ingredientesDecorator.TiposIngredientes;

import GUI.FrameBaseTodopizza;
import GUI_Business.VentanaTodopizza;

/**
 * Gestiona los eventos relativos a los botones de selección de ingredientes.
 * Todos los botones de ingredientes van asociados a este ActionListener.
 * La clase analiza el emisor del evento y modifica la cantidad de ingredientes y el importe del pedido adecuadamente. 
 * @author Gonzalo Sánchez Pla.
 *
 */

public class EventosBotonesIngredientes implements ActionListener {

	FrameBaseTodopizza formulario;
	
	/**
	 * Al instanciar la clase, para adscribirla al emisor de eventos, hay que pasarle también el formulario padre.
	 * De esta manera se simplifica asignación de la referencia al mismo, evitando utilizar métodos de acceso tipo "getParent"
	 * @param formulario - El formulario principal de la aplicación.
	 */
	public EventosBotonesIngredientes(FrameBaseTodopizza formulario) {
		this.formulario=formulario;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ev) {
		if (ev.getSource() instanceof Button){
			
			Button jb;
			jb=(Button)ev.getSource();
			procesarPulsacion(jb);
		}
	}

	/**
	 * A través del análisis del botón pulsado y del formulario principal, este método procesa la petición.
	 * @param jb - El botón pulsado.
	 */
	private void procesarPulsacion(Button jb) {
		// Obtenemos la cantidad de unidades que hay actualmente en el formulario y 
		// asignamos las referencias a los campos de cantidad y de importe del ingrediente que corresponda.
		
		obtenerValoresParaFormulario cv = analizarFormulario(jb);
		
		Integer existenciasActualesIngrediente = Integer.parseInt(cv.getTextFieldCantidadDelIngrediente().getText());
		Double precioTotalPedidoAnterior= Double.parseDouble(formulario.getTxtImporteTotal().getText());
		Double precioIngrediente = Double.parseDouble(cv.getPrecioUnitarioIngrediente().toString());
		
		Integer incremento = cv.getIncrementoDeCantidadAAplicarEnTextField();
		Integer nuevasExistencias = existenciasActualesIngrediente;
		
		if(incremento==1){
			nuevasExistencias=incrementoCantidad(nuevasExistencias);
		}
		
		else if (incremento==-1){
			nuevasExistencias=decrementoCantidad(nuevasExistencias);
		}
		
		Double importeFinalIngrediente = nuevasExistencias * precioIngrediente;
		Double precioTotalDelPedido =  precioTotalPedidoAnterior + 	
										(nuevasExistencias-existenciasActualesIngrediente)*precioIngrediente;
		
		formulario.getTxtImporteTotal().setText(precioTotalDelPedido.toString());
		cv.getTextFieldCantidadDelIngrediente().setText(nuevasExistencias.toString());
		cv.getTextFieldImporteDelIngrediente().setText(importeFinalIngrediente.toString());
		
		
		if (Double.parseDouble(formulario.getTxtImporteTotal().getText())!=
					Double.parseDouble(formulario.getTxtPrecioPizza().getText()) && formulario.getCmbFranquicias().getSelectedIndex()>0
				&& !((VentanaTodopizza)formulario).getBloqueado()
				
				){
			formulario.getCmdProcesarPedido().setEnabled(true);
		}else{
			formulario.getCmdProcesarPedido().setEnabled(false);
		}
	}
	
	/**
	 * Obtiene las principales referencias al formulario principal y los valores numéricos que necesita para poder
	 * calcular los nuevos precio e importe.
	 * @param jb botón que realiza la acción.
	 * @return Conjunto de datos.
	 */
	private obtenerValoresParaFormulario analizarFormulario(Button jb) {
		
		int cantidad; //cantidad de ingrediente
		TextField txtCantidad; //referencia al campo de texto donde está la cantidad del ingrediente.
		TextField txtImporte; // referencia al campo de texto donde está el importe del ingrediente.
		double precio; // precio unitario del ingrediente.
		int incremento; //unidades que habrán de sumarse (positivas, nulas o negativas) a la cantidad del ingrediente.
		
		obtenerValoresParaFormulario vf = new obtenerValoresParaFormulario();
		
		//Aceitunas
		if (jb==formulario.getCmdAceitunasMas() || jb==formulario.getCmdAceitunasMenos()){
			
			txtCantidad=formulario.getTxtCantidadAceitunas();
			txtImporte = formulario.getTxtImporteAceitunas();
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.aceitunas);
			cantidad=Integer.parseInt(txtCantidad.getText());
			
			if (jb==formulario.getCmdAceitunasMas() ){
				incremento=1;
			}else{
				incremento=-1;
				
			}
		}
		
			
		else
		//Anchoas
		if (jb==formulario.getCmdAnchoasMas() || jb==formulario.getCmdAnchoasMenos()){
			txtCantidad=formulario.getTxtCantidadAnchoas();
			txtImporte = formulario.getTxtImporteAnchoas();
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.anchoas);
			cantidad=Integer.parseInt(formulario.getTxtCantidadAnchoas().getText());
			
			if (jb==formulario.getCmdAnchoasMas() ){
				incremento=1;
			}else{
				incremento=-1;
			}
		}
		
		
		else
		//Bacon
		if (jb==formulario.getCmdBaconMas() || jb==formulario.getCmdBaconMenos()){
			
			cantidad=Integer.parseInt(formulario.getTxtCantidadBacon().getText());
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.bacon);
			txtCantidad=formulario.getTxtCantidadBacon();
			txtImporte = formulario.getTxtImporteBacon();
			if (jb==formulario.getCmdBaconMas() ){
				incremento=1;
			}else{
				incremento=-1;
			}
		}
		
		else
		//Carne
		if (jb==formulario.getCmdCarneMas() || jb==formulario.getCmdCarneMenos()){
			
			cantidad=Integer.parseInt(formulario.getTxtCantidadCarne().getText());
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.carne);
			txtCantidad=formulario.getTxtCantidadCarne();
			txtImporte = formulario.getTxtImporteCarne();
			
			if (jb==formulario.getCmdCarneMas() ){
				incremento=1;
			}else{
				incremento=-1;
			}
		}
		
		
		else
		// Extra de queso.
		if (jb==formulario.getCmdExtraQuesoMas() || jb==formulario.getCmdExtraQuesoMenos()){
			
			cantidad=Integer.parseInt(formulario.getTxtCantidadExtraQueso().getText());
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.extraQueso);
			txtCantidad=formulario.getTxtCantidadExtraQueso();
			txtImporte = formulario.getTxtImporteExtraQueso();
			
			if (jb==formulario.getCmdExtraQuesoMas() ){
				incremento=1;
			}else{
				incremento=-1;
			}
		}
		
		
		else
		// Pimientos.
		if (jb==formulario.getCmdPimientosMas() || jb==formulario.getCmdPimientosMenos()){
			
			cantidad=Integer.parseInt(formulario.getTxtCantidadPimientos().getText());
			precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.pimientos);
			txtCantidad=formulario.getTxtCantidadPimientos();
			txtImporte = formulario.getTxtImportePimientos();
			
			if (jb==formulario.getCmdPimientosMas() ){
				incremento=1;
				}else{
					incremento=-1;
				}
		}
		
		
		
		else
			// Piña.
			if (jb==formulario.getCmdPinaMas() || jb==formulario.getCmdPinaMenos()){
				
				cantidad=Integer.parseInt(formulario.getTxtCantidadPina().getText());
				precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.pina);
				txtCantidad=formulario.getTxtCantidadPina();
				txtImporte = formulario.getTxtImportePina();
				
				if (jb==formulario.getCmdPinaMas() ){
					incremento=1;
					}else{
						incremento=-1;
					}
			}
		
		
			else
				// Pollo.
				if (jb==formulario.getCmdPolloMas() || jb==formulario.getCmdPolloMenos()){
					
					cantidad=Integer.parseInt(formulario.getTxtCantidadPollo().getText());
					precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.pollo);
					txtCantidad=formulario.getTxtCantidadPollo();
					txtImporte = formulario.getTxtImportePollo();
					
					if (jb==formulario.getCmdPolloMas() ){
						incremento=1;
						}else{
							incremento=-1;
						}
				}
			
		
				else
					// Salami.
					if (jb==formulario.getCmdSalamiMas() || jb==formulario.getCmdSalamiMenos()){
						
						cantidad=Integer.parseInt(formulario.getTxtCantidadSalami().getText());
						precio = tbl_IngredientesPrecios.obtenerPrecio(TiposIngredientes.salami);
						txtCantidad = formulario.getTxtCantidadSalami();
						txtImporte = formulario.getTxtImporteSalami();
						if (jb==formulario.getCmdSalamiMas() ){
							incremento=1;
							}else{
								incremento=-1;
							}
					}
		
					else
					{
						incremento=0;
						precio=0d;
						cantidad=0;
						txtCantidad=null;
						txtImporte=null;
					}
		
		vf.setCantidadDelIngredienteEnFormulario(cantidad);
		vf.setPrecioUnitarioIngrediente(precio);
		vf.setTextFieldCantidadDelIngrediente(txtCantidad);
		vf.setTextFieldImporteDelIngrediente(txtImporte);
		vf.setIncrementoDeCantidadAAplicarEnTextField(incremento);
				
		return vf;
	}
			

	/**
	 * Resta uno a la cantidad de ingrediente, con un valor mínimo de 0 unidades.
	 * @param cantidad - unidades del ingrediente a modificar.
	 * @return - Entero, resultado de la operación de resta.
	 */
	private int decrementoCantidad(int cantidad) {
		cantidad--;
		if (cantidad<0){
			cantidad=0;
		}
		return cantidad;
	}

	/**
	 * Suma uno a la cantidad de ingrediente, con un valor máximo de 15 unidades.
	 * @param cantidad - unidades del ingrediente a modificar.
	 * @return  Entero, resultado de la operación de suma.
	 */
	private int incrementoCantidad(int cantidad) {
		cantidad++;
		if (cantidad>15){
			cantidad=15;
		}
		
		return cantidad;
	}

	
	/**
	 * Clase interna para representar un conjunto de datos de un JFrame de Todopizza.
	 * Es un adaptador entre la ventana del IGU y la lógica interna del programa.
	 * @author Gonzalo Sánchez Pla.
	 */
	private final class obtenerValoresParaFormulario{
		
		private Integer cantidadDelIngredienteEnFormulario;
		private TextField textFieldCantidadDelIngrediente;
		private TextField textFieldImporteDelIngrediente;
		private Double precioUnitarioIngrediente;
		private Integer incrementoDeCantidadAAplicarEnTextField;
		

		public obtenerValoresParaFormulario(){
			cantidadDelIngredienteEnFormulario=0;
			textFieldCantidadDelIngrediente=null;
			textFieldImporteDelIngrediente=null;
			precioUnitarioIngrediente =0d;
		}
		
		/**
		 * @return the cantidad
		 */
		public Integer getCantidadDelIngredienteEnFormulario() {
			return cantidadDelIngredienteEnFormulario;
		}
		
		/**
		 * @param cantidad the cantidad to set
		 */
		public void setCantidadDelIngredienteEnFormulario(Integer cantidad) {
			this.cantidadDelIngredienteEnFormulario = cantidad;
		}

		
		/**
	
		 * @return the txtCantidad
		 */
		public TextField getTextFieldCantidadDelIngrediente() {
			return textFieldCantidadDelIngrediente;
		}
		/**
		 * @param txtCantidad the txtCantidad to set
		 */
		public void setTextFieldCantidadDelIngrediente(TextField txtCantidad) {
			this.textFieldCantidadDelIngrediente = txtCantidad;
		}
	
		
		/**
		 * @return thetxtImporte
		 */
		public TextField getTextFieldImporteDelIngrediente() {
			return textFieldImporteDelIngrediente;
		}
		/**
		 * @param txtImporte the txtImporte to set
		 */
		public void setTextFieldImporteDelIngrediente(TextField txtImporte) {
			this.textFieldImporteDelIngrediente = txtImporte;
		}
		/**
		 * @return the importe
		 */

		
		public Double getPrecioUnitarioIngrediente() {
			return precioUnitarioIngrediente;
		}
		/**
		 * @param precio the importe to set
		 */
		public void setPrecioUnitarioIngrediente(Double precio) {
			this.precioUnitarioIngrediente = precio;
		}
		
		
		
		/**
		 * @return the incrementoDeCantidadAAplicarEnTextField
		 */
		public Integer getIncrementoDeCantidadAAplicarEnTextField() {
			return incrementoDeCantidadAAplicarEnTextField;
		}

		/**
		 * @param incrementoDeCantidadAAplicarEnTextField the incrementoDeCantidadAAplicarEnTextField to set
		 */
		public void setIncrementoDeCantidadAAplicarEnTextField(
				Integer incrementoDeCantidadAAplicarEnTextField) {
			this.incrementoDeCantidadAAplicarEnTextField = incrementoDeCantidadAAplicarEnTextField;
		}
		
		
	}
	
}
