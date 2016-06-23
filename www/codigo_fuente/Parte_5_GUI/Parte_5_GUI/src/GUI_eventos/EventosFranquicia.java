/**
 * 
 */
package GUI_eventos;
import GUI.FrameBaseTodopizza;
import GUI_Business.VentanaTodopizza;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;


/**
 * Gestiona los eventos del formulario relativos a la selección de la franquicia.
 * @author Gonzalo Sánchez Pla.
 */
public final class EventosFranquicia  implements ItemListener {
	
	FrameBaseTodopizza formulario;
	
	/**
	 * Al declarar la clase hay que enviar el JFrame tipo FrameBase como parámetro.
	 * @param formulario - Tipo FrameBase que se está escuchando.
	 */
	public EventosFranquicia(FrameBaseTodopizza formulario){
		this.formulario=formulario;
	}
	/**
	 * Revisa el estado del formulario, y si hay ingredientes activa el botón de procesar pedido cuando se selecciona una franquicia.
	 */
	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent ev) {
		if (ev.getSource() instanceof JComboBox && ev.getStateChange()==ItemEvent.SELECTED){
			if (Double.parseDouble(formulario.getTxtImporteTotal().getText())!=
						Double.parseDouble(formulario.getTxtPrecioPizza().getText()) 
						&& formulario.getCmbFranquicias().getSelectedIndex()>0
						&& !((VentanaTodopizza)formulario).getBloqueado()
					){
				formulario.getCmdProcesarPedido().setEnabled(true);
			}else{
				formulario.getCmdProcesarPedido().setEnabled(false);
			}
		}
	}
}
	
