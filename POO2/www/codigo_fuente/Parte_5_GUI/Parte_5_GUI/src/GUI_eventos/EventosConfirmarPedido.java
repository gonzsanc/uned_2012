package GUI_eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import patronObserver.ISujeto;
import patronObserver.ObservadorAbstracto;
import patronObserver.SujetoAbstracto;
import peticiones.FormularioPedido;
import peticiones.OperadorPanelControl;
import peticiones.TiposEstadosPreparacion;
import pizzaFactoryMethod.PizzaTodopizzaAbstracta;

import GUI.FrameBaseTodopizza;
import GUI.FramePrincipal;
import GUI_Business.VentanaTodopizza;

/**
 * Gestiona los eventos relacionados de la confirmación del pedido, en dos sentidos desde y hacia el formulario cliente.
 * @author Gonzalo Sánchez Pla.
 */
public class EventosConfirmarPedido extends ObservadorAbstracto implements ActionListener {

	FrameBaseTodopizza formulario;
	
	/**
	 * Al declarar la clase hay que enviar el JFrame tipo FrameBase como parámetro.
	 * @param formulario - Tipo FrameBase que se está escuchando.
	 */
	public EventosConfirmarPedido(FramePrincipal formulario){
		this.formulario=(FrameBaseTodopizza) formulario;
	}
	
	
		/**
		 * Gestiona los eventos del botón de confirmación de pedido y el reinicio del Frame a la finalización del mismo.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

		int seleccion = sinocancelar("Está a punto de enviar el pedido, pulse sí para procesarlo o no cancelar la solicitud");
		
		
		if (seleccion==JOptionPane.YES_OPTION){
			
			formulario.getCmdProcesarPedido().setEnabled(false);
			((GUI_Business.VentanaTodopizza)formulario).bloquear();
			
			OperadorPanelControl operador = new OperadorPanelControl(formulario);
			operador.procesar(this);
			
		}else{
			JOptionPane.showMessageDialog(null, "Confirmación detenida, puede seguir realizando su pedido", "Pedido Todopizza", JOptionPane.PLAIN_MESSAGE);
		}
		
	}

	
	/**
	 * Imlementación del rol observador.
	 * Esta clase actúa como observadora de los cambios de estado del proceso de pedido también.
	 * Es la engargada de modificar el fomulario de la IGU ante este tipo de notificaciones.
	 */
	/* (non-Javadoc)
	 * @see patronObserver.ObservadorAbstracto#actualizar(patronObserver.ISujeto)
	 */
	@Override
	public void actualizar(ISujeto sujeto) {
		
		TiposEstadosPreparacion estadoS=((PizzaTodopizzaAbstracta)sujeto).obtenerEstado();
		formulario.getTxtEstadoPedido().setText(Datos.fld_TiposEstadoPedidoNombre.obtenerNombre(estadoS));
		
		//System.out.println(this.getClass().toString()+ " notificado.") ;
		formulario.getProgBarEstadoPedido().setValue(
				formulario.getProgBarEstadoPedido().getValue()+16
				);
		
		
		if (((PizzaTodopizzaAbstracta)sujeto).obtenerEstado()==TiposEstadosPreparacion.pizzaPreparada){
			formulario.getProgBarEstadoPedido().setValue(100);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Gracias por su compra, esperamos que disfrute de la comida", "Pedido Todopizza", JOptionPane.PLAIN_MESSAGE);
			
			formulario.dispose();
			formulario =new VentanaTodopizza();
			formulario.setVisible(true);
			
		}
		
	}

	private int sinocancelar(String mensaje) {
		    int result = JOptionPane.showConfirmDialog(null, mensaje,"Pedido Todopizza", JOptionPane.YES_NO_CANCEL_OPTION);
		    return result;
	}

	/* (non-Javadoc)
	 * @see patronObserver.ObservadorAbstracto#actualizar(patronObserver.ISujeto)
	 */
	
	




}
