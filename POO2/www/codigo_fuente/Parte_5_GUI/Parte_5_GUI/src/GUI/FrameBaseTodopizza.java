package GUI;

import javax.swing.JProgressBar;
import javax.swing.JScrollPane;

/**
 * Extiende el formulario base de Todopizza, agregando sobre todo métodos de acceso a sus atributos.
 * El constructor inicializa algunas variables.
 * @author Gon
 *
 */
public abstract class FrameBaseTodopizza extends FramePrincipal {
	protected String pizzaActiva="Mediana";
	  
	/**
	 * Constructor de la clase.
	 */
	public FrameBaseTodopizza(){
		super.cmdSalir.setVisible(false);
		super.cmdInicializar.setVisible(false);
		super.lstPizza.setSelectedIndex(0);
		super.txtImporteTotal.setText("5.00");
		super.txtPrecioPizza.setText("5.00");
	}
	
	// A partir de aquí se implementan métodos de acceso a distintas partes del formulario principal.
	
	  /**
		 * @return el combo de las franquicias
		 */
		public javax.swing.JComboBox getCmbFranquicias() {
			return cmbFranquicias;
		}

		/**
		 * @param cmbFranquicias the cmbFranquicias to set
		 */
		public void setCmbFranquicias(javax.swing.JComboBox cmbFranquicias) {
			this.cmbFranquicias = cmbFranquicias;
		}

	    public void asignarPizzaActiva(String pizzaActiva){
	   	 this.pizzaActiva=pizzaActiva;
	    }
	    
	    public String obtenerPizzaActiva(){
	   	return this.pizzaActiva;
	    }
	    

		public java.awt.TextField getTxtCantidadAceitunas() {
			return txtCantidadAceitunas;
		}

		public void setTxtCantidadAceitunas(java.awt.TextField txtCantidadAceitunas) {
			this.txtCantidadAceitunas = txtCantidadAceitunas;
		}

		public java.awt.TextField getTxtCantidadAnchoas() {
			return txtCantidadAnchoas;
		}

		public void setTxtCantidadAnchoas(java.awt.TextField txtCantidadAnchoas) {
			this.txtCantidadAnchoas = txtCantidadAnchoas;
		}

		public java.awt.TextField getTxtCantidadBacon() {
			return txtCantidadBacon;
		}

		public void setTxtCantidadBacon(java.awt.TextField txtCantidadBacon) {
			this.txtCantidadBacon = txtCantidadBacon;
		}

		public java.awt.TextField getTxtCantidadCarne() {
			return txtCantidadCarne;
		}

		public void setTxtCantidadCarne(java.awt.TextField txtCantidadCarne) {
			this.txtCantidadCarne = txtCantidadCarne;
		}

		public java.awt.TextField getTxtCantidadExtraQueso() {
			return txtCantidadExtraQueso;
		}

		public void setTxtCantidadExtraQueso(java.awt.TextField txtCantidadExtraQueso) {
			this.txtCantidadExtraQueso = txtCantidadExtraQueso;
		}

		public java.awt.TextField getTxtCantidadPimientos() {
			return txtCantidadPimientos;
		}

		public void setTxtCantidadPimientos(java.awt.TextField txtCantidadPimientos) {
			this.txtCantidadPimientos = txtCantidadPimientos;
		}

		public java.awt.TextField getTxtCantidadPina() {
			return txtCantidadPina;
		}

		public void setTxtCantidadPina(java.awt.TextField txtCantidadPina) {
			this.txtCantidadPina = txtCantidadPina;
		}

		public java.awt.TextField getTxtCantidadPollo() {
			return txtCantidadPollo;
		}

		public void setTxtCantidadPollo(java.awt.TextField txtCantidadPollo) {
			this.txtCantidadPollo = txtCantidadPollo;
		}

		public java.awt.TextField getTxtCantidadSalami() {
			return txtCantidadSalami;
		}

		public void setTxtCantidadSalami(java.awt.TextField txtCantidadSalami) {
			this.txtCantidadSalami = txtCantidadSalami;
		}

		public javax.swing.JTextField getTxtEstadoPedido() {
			return txtEstadoPedido;
		}

		public void setTxtEstadoPedido(javax.swing.JTextField txtEstadoPedido) {
			this.txtEstadoPedido = txtEstadoPedido;
		}

		public java.awt.TextField getTxtImporteAceitunas() {
			return txtImporteAceitunas;
		}

		public void setTxtImporteAceitunas(java.awt.TextField txtImporteAceitunas) {
			this.txtImporteAceitunas = txtImporteAceitunas;
		}

		public java.awt.TextField getTxtImporteAnchoas() {
			return txtImporteAnchoas;
		}

		public void setTxtImporteAnchoas(java.awt.TextField txtImporteAnchoas) {
			this.txtImporteAnchoas = txtImporteAnchoas;
		}

		public java.awt.TextField getTxtImporteBacon() {
			return txtImporteBacon;
		}

		public void setTxtImporteBacon(java.awt.TextField txtImporteBacon) {
			this.txtImporteBacon = txtImporteBacon;
		}

		public java.awt.TextField getTxtImporteCarne() {
			return txtImporteCarne;
		}

		public void setTxtImporteCarne(java.awt.TextField txtImporteCarne) {
			this.txtImporteCarne = txtImporteCarne;
		}

		public java.awt.TextField getTxtImporteExtraQueso() {
			return txtImporteExtraQueso;
		}

		public void setTxtImporteExtraQueso(java.awt.TextField txtImporteExtraQueso) {
			this.txtImporteExtraQueso = txtImporteExtraQueso;
		}

		public java.awt.TextField getTxtImportePimientos() {
			return txtImportePimientos;
		}

		public void setTxtImportePimientos(java.awt.TextField txtImportePimientos) {
			this.txtImportePimientos = txtImportePimientos;
		}

		public java.awt.TextField getTxtImportePina() {
			return txtImportePina;
		}

		public void setTxtImportePina(java.awt.TextField txtImportePina) {
			this.txtImportePina = txtImportePina;
		}

		public java.awt.TextField getTxtImportePollo() {
			return txtImportePollo;
		}

		public void setTxtImportePollo(java.awt.TextField txtImportePollo) {
			this.txtImportePollo = txtImportePollo;
		}

		public java.awt.TextField getTxtImporteSalami() {
			return txtImporteSalami;
		}

		public void setTxtImporteSalami(java.awt.TextField txtImporteSalami) {
			this.txtImporteSalami = txtImporteSalami;
		}

		public java.awt.TextField getTxtImporteTotal() {
			return txtImporteTotal;
		}

		public void setTxtImporteTotal(java.awt.TextField txtImporteTotal) {
			this.txtImporteTotal = txtImporteTotal;
		}

		public java.awt.TextField getTxtPrecioPizza() {
			return txtPrecioPizza;
		}

		public void setTxtPrecioPizza(java.awt.TextField txtPrecioPizza) {
			this.txtPrecioPizza = txtPrecioPizza;
		}
		
		 public java.awt.Button getCmdAceitunasMas() {
				return cmdAceitunasMas;
			}

			public void setCmdAceitunasMas(java.awt.Button cmdAceitunasMas) {
				this.cmdAceitunasMas = cmdAceitunasMas;
			}

			public java.awt.Button getCmdAceitunasMenos() {
				return cmdAceitunasMenos;
			}

			public void setCmdAceitunasMenos(java.awt.Button cmdAceitunasMenos) {
				this.cmdAceitunasMenos = cmdAceitunasMenos;
			}

			public java.awt.Button getCmdAnchoasMas() {
				return cmdAnchoasMas;
			}

			public void setCmdAnchoasMas(java.awt.Button cmdAnchoasMas) {
				this.cmdAnchoasMas = cmdAnchoasMas;
			}

			public java.awt.Button getCmdAnchoasMenos() {
				return cmdAnchoasMenos;
			}

			public void setCmdAnchoasMenos(java.awt.Button cmdAnchoasMenos) {
				this.cmdAnchoasMenos = cmdAnchoasMenos;
			}

			public java.awt.Button getCmdBaconMas() {
				return cmdBaconMas;
			}

			public void setCmdBaconMas(java.awt.Button cmdBaconMas) {
				this.cmdBaconMas = cmdBaconMas;
			}

			public java.awt.Button getCmdBaconMenos() {
				return cmdBaconMenos;
			}

			public void setCmdBaconMenos(java.awt.Button cmdBaconMenos) {
				this.cmdBaconMenos = cmdBaconMenos;
			}

			public java.awt.Button getCmdCarneMas() {
				return cmdCarneMas;
			}

			public void setCmdCarneMas(java.awt.Button cmdCarneMas) {
				this.cmdCarneMas = cmdCarneMas;
			}

			public java.awt.Button getCmdCarneMenos() {
				return cmdCarneMenos;
			}

			public void setCmdCarneMenos(java.awt.Button cmdCarneMenos) {
				this.cmdCarneMenos = cmdCarneMenos;
			}

			public java.awt.Button getCmdExtraQuesoMas() {
				return cmdExtraQuesoMas;
			}

			public void setCmdExtraQuesoMas(java.awt.Button cmdExtraQuesoMas) {
				this.cmdExtraQuesoMas = cmdExtraQuesoMas;
			}

			public java.awt.Button getCmdExtraQuesoMenos() {
				return cmdExtraQuesoMenos;
			}

			public void setCmdExtraQuesoMenos(java.awt.Button cmdExtraQuesoMenos) {
				this.cmdExtraQuesoMenos = cmdExtraQuesoMenos;
			}

			public javax.swing.JButton getCmdInicializar() {
				return cmdInicializar;
			}

			public void setCmdInicializar(javax.swing.JButton cmdInicializar) {
				this.cmdInicializar = cmdInicializar;
			}

			public java.awt.Button getCmdPimientosMas() {
				return cmdPimientosMas;
			}

			public void setCmdPimientosMas(java.awt.Button cmdPimientosMas) {
				this.cmdPimientosMas = cmdPimientosMas;
			}

			public java.awt.Button getCmdPimientosMenos() {
				return cmdPimientosMenos;
			}

			public void setCmdPimientosMenos(java.awt.Button cmdPimientosMenos) {
				this.cmdPimientosMenos = cmdPimientosMenos;
			}

			public java.awt.Button getCmdPinaMas() {
				return cmdPinaMas;
			}

			public void setCmdPinaMas(java.awt.Button cmdPinaMas) {
				this.cmdPinaMas = cmdPinaMas;
			}

			public java.awt.Button getCmdPinaMenos() {
				return cmdPinaMenos;
			}

			public void setCmdPinaMenos(java.awt.Button cmdPinaMenos) {
				this.cmdPinaMenos = cmdPinaMenos;
			}

			public java.awt.Button getCmdPolloMas() {
				return cmdPolloMas;
			}

			public void setCmdPolloMas(java.awt.Button cmdPolloMas) {
				this.cmdPolloMas = cmdPolloMas;
			}

			public java.awt.Button getCmdPolloMenos() {
				return cmdPolloMenos;
			}

			public void setCmdPolloMenos(java.awt.Button cmdPolloMenos) {
				this.cmdPolloMenos = cmdPolloMenos;
			}

			public javax.swing.JButton getCmdProcesarPedido() {
				return cmdProcesarPedido;
			}

			public void setCmdProcesarPedido(javax.swing.JButton cmdProcesarPedido) {
				this.cmdProcesarPedido = cmdProcesarPedido;
			}

			public java.awt.Button getCmdSalamiMas() {
				return cmdSalamiMas;
			}

			public void setCmdSalamiMas(java.awt.Button cmdSalamiMas) {
				this.cmdSalamiMas = cmdSalamiMas;
			}

			public java.awt.Button getCmdSalamiMenos() {
				return cmdSalamiMenos;
			}

			public void setCmdSalamiMenos(java.awt.Button cmdSalamiMenos) {
				this.cmdSalamiMenos = cmdSalamiMenos;
			}

			public javax.swing.JButton getCmdSalir() {
				return cmdSalir;
			}

			public void setCmdSalir(javax.swing.JButton cmdSalir) {
				this.cmdSalir = cmdSalir;
			}
	    
			public JProgressBar getProgBarEstadoPedido(){
				return  progBarEstadoPedido;
			}
			
}
