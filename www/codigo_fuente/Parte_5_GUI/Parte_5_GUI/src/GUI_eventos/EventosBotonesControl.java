/**
 * 
 */
package GUI_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GUI.FramePrincipal;

/**
 * Previsión para implementar botones adicionales de control
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class EventosBotonesControl implements ActionListener {

	JFrame formulario;
	
	/**
	 * Constructor
	 */
	public EventosBotonesControl(JFrame formulario) {
		this.formulario=formulario;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		String objeto=e.getSource().toString();
		System.out.println(objeto);

	}

}
