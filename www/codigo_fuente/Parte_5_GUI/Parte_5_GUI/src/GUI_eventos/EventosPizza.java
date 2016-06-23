/**
 * 
 */
package GUI_eventos;

import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import GUI.FramePrincipal;
import GUI.FrameBaseTodopizza;

/**
 * Gestiona los eventos de la lista de pizzas.
 * Se le ha de pasar el formulario por el constructor para que pueda acceder a sus métodos fácilmente si recurrir a parent..
 * @author Gonzalo Sánchez Pla.
 */
public class EventosPizza implements ListSelectionListener {

	//referencia al formulario padre.
	private FrameBaseTodopizza formulario;
	
	/**
	 * Gestiona el cambio de selección del cuadro de lista de pizzas.
	 */
	public EventosPizza(FrameBaseTodopizza formulario) {
		this.formulario = formulario;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.ListSelectionListener#valueChanged(javax.swing.event.ListSelectionEvent)
	 */
	@Override
	public void valueChanged(ListSelectionEvent ev) {
		String valor;
		JList fuente;
		if (!ev.getValueIsAdjusting()){
			fuente = (JList)ev.getSource();
			valor = fuente.getSelectedValue().toString();
			procesarCambio(valor);
			fuente.getParent();
		}
	}

	/**
	 * Analiza el cambio de selección en la lista de pizzas del formulario y actualiza el mismo en función de ello.
	 * @param nombrePizzaNueva - Cadena con un nombre de pizza.
	 */
	private void procesarCambio(String nombrePizzaNueva) {
		
		double precioPizzaNueva;
		double precioPizzaAnterior;
		double importeTotal;
				
		importeTotal=Double.parseDouble(formulario.getTxtImporteTotal().getText());
		precioPizzaAnterior = Double.parseDouble(formulario.getTxtPrecioPizza().getText());
		precioPizzaNueva=obtenerPrecioDePizza(nombrePizzaNueva);
		
		importeTotal+=precioPizzaNueva-precioPizzaAnterior;
		
		
		formulario.getTxtImporteTotal().setText(Double.toString(importeTotal));
		formulario.asignarPizzaActiva(nombrePizzaNueva);
		formulario.getTxtPrecioPizza().setText(Double.toString(precioPizzaNueva));
	}
	
	/**
	 * Segun el nombre de la pizza, retorna su precio.
	 * @param valor - nombre de la pizza.
	 * @return double - precio de la pizza.
	 */
	private double obtenerPrecioDePizza(String valor){
		double precio;
		
		if (valor=="Pequeña"){
			precio=5.00;
		}else 
			if (valor=="Mediana"){
				precio=10.00;
		}else 
			if (valor=="Grande"){
				precio=15.00;
		}else 
			if (valor=="XL"){
				precio=20.00;
		}else 
			if (valor =="XXL"){
				precio=25.00;
		}
			else{
				precio=0.00;
		}
		return precio;
	}

}
