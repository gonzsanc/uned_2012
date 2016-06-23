package GUI_Business;
import java.awt.Button;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

import GUI_eventos.*;
import GUI_Business.*;

/**
 * Exitende el formulario principal de Todopizza, agregándole lógica de negocio esencial para su integración con el resto de la aplicación.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class VentanaTodopizza extends GUI.FrameBaseTodopizza{

	private static final long serialVersionUID = 1L;
	
	private ItemListener gestorFranquicias;
	private ListSelectionListener gestorPizza;
	private ActionListener gestorIngredientes;
	private ActionListener gestorProcesar;
	private ActionListener gestorControl;
	private EventListener gestorInterno;
	private boolean bloqueado=false;
	
		/**
		 * Constructor.
		 */
		public VentanaTodopizza(){
			super();
		
			inicializarGestoresEventos();
		}


		/**
		 * Asigna a todos los controles de la ventana los manejadores de eventos correspondientes.
		 */
		private void inicializarGestoresEventos() {
			inicializarGestorEventosEstablecimiento();
			inicializarGestorEventosPizza();
			inicializarGestorEventosIngredientes();
			inicializarGestorEventosProcesar();
			inicializarGestorEventosControl();
			
		}

		/**
		 * Inicializa la gestión de eventos de tipo control
		 */
		private void inicializarGestorEventosControl() {
			this.gestorControl= new GUI_eventos.EventosBotonesControl(this);
			this.cmdSalir.addActionListener(gestorControl);
			this.cmdInicializar.addActionListener(gestorControl);
		}

		/**
		 * Asigna un observador al botón de procesar pedido.
		 */
		private void inicializarGestorEventosProcesar() {
			gestorProcesar = new EventosConfirmarPedido(this);
			this.cmdProcesarPedido.addActionListener(gestorProcesar);			
		}

		/**
		 * Asigna el mismo observador para todos los botones de ingredientes.
		 */
		private void inicializarGestorEventosIngredientes() {
			this.gestorIngredientes=new GUI_eventos.EventosBotonesIngredientes(this);
			
		  for(Component componente:  this.panModificacionIngrediente.getComponents() ){
			 
			  if (componente instanceof JButton){
				  ((JButton)componente).addActionListener(gestorIngredientes);
			  }
			  else if (componente instanceof Button){
				  ((Button)componente).addActionListener(gestorIngredientes);
			  }  
		  }
			
			
		}

		/**
		 * Agrega un observador a la lista de selección de tipo de pizza.
		 */
		private void inicializarGestorEventosPizza() {
			this.gestorPizza= new EventosPizza(this);
			this.lstPizza.addListSelectionListener(gestorPizza);
		}

		/**
		 * Suscribe un observador al combo de selección de franquicias
		 */
		private void inicializarGestorEventosEstablecimiento() {
			gestorFranquicias = new EventosFranquicia(this);
			this.cmbFranquicias.addItemListener(gestorFranquicias);
		}
		
		/**
		 * Pone a true una bandera de bloqueo de la clase.
		 */
		public void bloquear(){
			this.bloqueado=true;
		}
		
		/**
		 * Pone a false una bandera de bloqueo de la clase.
		 */
		public void desbloquear(){
			this.bloqueado=false;
		}
		
		/**
		 * Devuelve el estado de la bandera de bloqueo.
		 * @return boolean
		 */
		public boolean getBloqueado(){
			return this.bloqueado;
		}
	}


