package GUI;

/**
 * Frame base realizado con AWT/Swing y prototipado con el editor wysiwyg Mantisse.
 * @author Gonzalo Sánchez Pla.
 */
public abstract class FramePrincipal extends javax.swing.JFrame {

    /**
	 * Eclipse lo pide.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
     * Constructor del JFrame.
     */
    public FramePrincipal () {
        inicializarTodo();
    }

  
    private void inicializarTodo() {

        PanSeleccionTienda = new javax.swing.JPanel();
        cmbFranquicias = new javax.swing.JComboBox();
        lblFabrifca = new java.awt.Label();
        panConfirmarPedido = new javax.swing.JPanel();
        lblConfirmarPedido = new java.awt.Label();
        panProcesoPedido = new javax.swing.JPanel();
        cmdProcesarPedido = new javax.swing.JButton();
        progBarEstadoPedido = new javax.swing.JProgressBar();
        txtEstadoPedido = new javax.swing.JTextField();
        panSeleccionPizza = new javax.swing.JPanel();
        scrollPizzas = new javax.swing.JScrollPane();
        lstPizza = new javax.swing.JList();
        lblTamanoPizza = new java.awt.Label();
        panPrecioPizza = new javax.swing.JPanel();
        lblPrecioPizza = new java.awt.Label();
        txtPrecioPizza = new java.awt.TextField();
        lblBienvenida = new java.awt.Label();
        panControl = new javax.swing.JPanel();
        cmdInicializar = new javax.swing.JButton();
        cmdSalir = new javax.swing.JButton();
        panIngredientes = new javax.swing.JPanel();
        panIngrediente = new javax.swing.JPanel();
        lblIngrediente = new java.awt.Label();
        lblExtraQueso = new java.awt.Label();
        lblBacon = new java.awt.Label();
        lblPimientos = new java.awt.Label();
        lblPina = new java.awt.Label();
        lblPollo = new java.awt.Label();
        lblAnchoas = new java.awt.Label();
        lblCarne = new java.awt.Label();
        lblAceitunas = new java.awt.Label();
        lblSalami = new java.awt.Label();
        panModificacionIngrediente = new javax.swing.JPanel();
        cmdPolloMas = new java.awt.Button();
        cmdSalamiMas = new java.awt.Button();
        cmdPimientosMas = new java.awt.Button();
        cmdPinaMas = new java.awt.Button();
        lblCantidadIngredientes = new java.awt.Label();
        cmdAceitunasMenos = new java.awt.Button();
        cmdAnchoasMenos = new java.awt.Button();
        cmdPimientosMenos = new java.awt.Button();
        cmdPinaMenos = new java.awt.Button();
        cmdPolloMenos = new java.awt.Button();
        cmdSalamiMenos = new java.awt.Button();
        cmdAnchoasMas = new java.awt.Button();
        cmdAceitunasMas = new java.awt.Button();
        cmdExtraQuesoMas = new java.awt.Button();
        cmdBaconMas = new java.awt.Button();
        cmdCarneMas = new java.awt.Button();
        cmdExtraQuesoMenos = new java.awt.Button();
        cmdBaconMenos = new java.awt.Button();
        cmdCarneMenos = new java.awt.Button();
        panUnidadesIngrediente = new javax.swing.JPanel();
        txtCantidadAnchoas = new java.awt.TextField();
        txtCantidadAceitunas = new java.awt.TextField();
        txtCantidadBacon = new java.awt.TextField();
        txtCantidadCarne = new java.awt.TextField();
        txtCantidadPollo = new java.awt.TextField();
        txtCantidadPimientos = new java.awt.TextField();
        txtCantidadPina = new java.awt.TextField();
        lblSeleccionIngredientes = new java.awt.Label();
        txtCantidadSalami = new java.awt.TextField();
        txtCantidadExtraQueso = new java.awt.TextField();
        panImporteIngrediente = new javax.swing.JPanel();
        txtImporteBacon = new java.awt.TextField();
        txtImporteAceitunas = new java.awt.TextField();
        txtImporteExtraQueso = new java.awt.TextField();
        txtImporteAnchoas = new java.awt.TextField();
        lblImporteIngredientes = new java.awt.Label();
        txtImporteSalami = new java.awt.TextField();
        txtImportePollo = new java.awt.TextField();
        txtImportePimientos = new java.awt.TextField();
        txtImportePina = new java.awt.TextField();
        txtImporteCarne = new java.awt.TextField();
        panImporteTotal = new javax.swing.JPanel();
        lblImporteTotal = new java.awt.Label();
        txtImporteTotal = new java.awt.TextField();
        lblIngredientes = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbFranquicias.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccionar", "Barcelona", "Bilbao", "Guadalajara", "Madrid", "Tarragona", "" }));

        lblFabrifca.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblFabrifca.setText("1 - Elegir Tienda Todopizza");

        javax.swing.GroupLayout PanSeleccionTiendaLayout = new javax.swing.GroupLayout(PanSeleccionTienda);
        PanSeleccionTienda.setLayout(PanSeleccionTiendaLayout);
        PanSeleccionTiendaLayout.setHorizontalGroup(
            PanSeleccionTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSeleccionTiendaLayout.createSequentialGroup()
                .addComponent(lblFabrifca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(PanSeleccionTiendaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmbFranquicias, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanSeleccionTiendaLayout.setVerticalGroup(
            PanSeleccionTiendaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanSeleccionTiendaLayout.createSequentialGroup()
                .addComponent(lblFabrifca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbFranquicias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        lblConfirmarPedido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblConfirmarPedido.setText("4 - Confirmar pedido");

        panProcesoPedido.setBackground(new java.awt.Color(204, 204, 204));

        cmdProcesarPedido.setText("Procesar Pedido");
        cmdProcesarPedido.setToolTipText("");
        cmdProcesarPedido.setEnabled(false);

        txtEstadoPedido.setBackground(new java.awt.Color(204, 204, 204));
        txtEstadoPedido.setEditable(false);
        txtEstadoPedido.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtEstadoPedido.setText("Complete su selección para procesar el pedido");
        txtEstadoPedido.setToolTipText("");

        javax.swing.GroupLayout panProcesoPedidoLayout = new javax.swing.GroupLayout(panProcesoPedido);
        panProcesoPedido.setLayout(panProcesoPedidoLayout);
        panProcesoPedidoLayout.setHorizontalGroup(
            panProcesoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                .addGroup(panProcesoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(progBarEstadoPedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                        .addGroup(panProcesoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(txtEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(cmdProcesarPedido)))
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panProcesoPedidoLayout.setVerticalGroup(
            panProcesoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panProcesoPedidoLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(cmdProcesarPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addComponent(txtEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(progBarEstadoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout panConfirmarPedidoLayout = new javax.swing.GroupLayout(panConfirmarPedido);
        panConfirmarPedido.setLayout(panConfirmarPedidoLayout);
        panConfirmarPedidoLayout.setHorizontalGroup(
            panConfirmarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfirmarPedidoLayout.createSequentialGroup()
                .addComponent(lblConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panConfirmarPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panProcesoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panConfirmarPedidoLayout.setVerticalGroup(
            panConfirmarPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panConfirmarPedidoLayout.createSequentialGroup()
                .addComponent(lblConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(panProcesoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lstPizza.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Pequeña", "Mediana", "Grande", "XL", "XXL" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        lstPizza.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollPizzas.setViewportView(lstPizza);

        lblTamanoPizza.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblTamanoPizza.setText("2 - Seleccionar Tamaño de Pizza");

        lblPrecioPizza.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        lblPrecioPizza.setText("Precio base:");

        txtPrecioPizza.setEditable(false);
        txtPrecioPizza.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        txtPrecioPizza.setText("0");

        javax.swing.GroupLayout panPrecioPizzaLayout = new javax.swing.GroupLayout(panPrecioPizza);
        panPrecioPizza.setLayout(panPrecioPizzaLayout);
        panPrecioPizzaLayout.setHorizontalGroup(
            panPrecioPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPrecioPizzaLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(lblPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(txtPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panPrecioPizzaLayout.setVerticalGroup(
            panPrecioPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout panSeleccionPizzaLayout = new javax.swing.GroupLayout(panSeleccionPizza);
        panSeleccionPizza.setLayout(panSeleccionPizzaLayout);
        panSeleccionPizzaLayout.setHorizontalGroup(
            panSeleccionPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSeleccionPizzaLayout.createSequentialGroup()
                .addComponent(lblTamanoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 27, Short.MAX_VALUE))
            .addGroup(panSeleccionPizzaLayout.createSequentialGroup()
                .addGroup(panSeleccionPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panSeleccionPizzaLayout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(panPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panSeleccionPizzaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(scrollPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panSeleccionPizzaLayout.setVerticalGroup(
            panSeleccionPizzaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSeleccionPizzaLayout.createSequentialGroup()
                .addComponent(lblTamanoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(panPrecioPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lblBienvenida.setFont(new java.awt.Font("Papyrus", 1, 14)); // NOI18N
        lblBienvenida.setName("");
        lblBienvenida.setText("Todopizza le da la bienvenida");

        cmdInicializar.setText("Inicializar");

        cmdSalir.setText("Salir");

        javax.swing.GroupLayout panControlLayout = new javax.swing.GroupLayout(panControl);
        panControl.setLayout(panControlLayout);
        panControlLayout.setHorizontalGroup(
            panControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cmdInicializar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(cmdSalir)
                .addContainerGap())
        );
        panControlLayout.setVerticalGroup(
            panControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(cmdInicializar)
                .addComponent(cmdSalir))
        );

        lblIngrediente.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblIngrediente.setText("Ingrediente");

        lblExtraQueso.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblExtraQueso.setPreferredSize(new java.awt.Dimension(23, 23));
        lblExtraQueso.setText("Extra de queso");

        lblBacon.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblBacon.setText("Bacon");

        lblPimientos.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblPimientos.setText("Pimientos");

        lblPina.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblPina.setText("Piña");

        lblPollo.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblPollo.setText("Pollo");

        lblAnchoas.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblAnchoas.setText("Anchoas");

        lblCarne.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblCarne.setText("Carne");

        lblAceitunas.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblAceitunas.setText("Aceitunas");

        lblSalami.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        lblSalami.setText("Salami");

        javax.swing.GroupLayout panIngredienteLayout = new javax.swing.GroupLayout(panIngrediente);
        panIngrediente.setLayout(panIngredienteLayout);
        panIngredienteLayout.setHorizontalGroup(
            panIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblSalami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblPina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblBacon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblPimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(panIngredienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panIngredienteLayout.setVerticalGroup(
            panIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panIngredienteLayout.createSequentialGroup()
                .addComponent(lblIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lblAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lblAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblBacon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblCarne, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPimientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblPina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblPollo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSalami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmdPolloMas.setLabel("+");
        cmdPolloMas.setName("cmdPolloMas");

        cmdSalamiMas.setLabel("+");
        cmdSalamiMas.setName("cmdSalamiMas");

        cmdPimientosMas.setLabel("+");
        cmdPimientosMas.setName("cmdPimientosMas");

        cmdPinaMas.setLabel("+");
        cmdPinaMas.setName("cmdPinaMas");

        lblCantidadIngredientes.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblCantidadIngredientes.setText("Cantidad");

        cmdAceitunasMenos.setLabel("-");
        cmdAceitunasMenos.setName("cmdAceitunasMenos");
        
        cmdAnchoasMenos.setLabel("-");
        cmdAnchoasMenos.setName("cmdAnchoasMenos");

        cmdPimientosMenos.setLabel("-");
        cmdPimientosMenos.setName("cmdPimientosMenos");

        cmdPinaMenos.setLabel("-");
        cmdPinaMenos.setName("cmdPinaMenos");

        cmdPolloMenos.setLabel("-");
        cmdPolloMenos.setName("cmdPolloMenos");

        
        
        cmdSalamiMenos.setLabel("-");
        cmdSalamiMenos.setName("cmdSalamiMenos");

        cmdAnchoasMas.setLabel("+");
        cmdAnchoasMas.setName("cmdAnchoasMas");

        cmdAceitunasMas.setLabel("+");
        cmdAceitunasMas.setName("cmdAceitunasMas");

        cmdExtraQuesoMas.setLabel("+");
        cmdExtraQuesoMas.setName("cmdExtraQuesoMas");

        cmdBaconMas.setLabel("+");
        cmdBaconMas.setName("cmdBaconMas");

        cmdCarneMas.setLabel("+");
        cmdCarneMas.setName("cmdCarneMas");

        cmdExtraQuesoMenos.setLabel("-");
        cmdExtraQuesoMenos.setName("cmdExtraQuesoMenos");

        cmdBaconMenos.setLabel("-");
        cmdBaconMenos.setName("cmdBaconMenos");
        

        cmdCarneMenos.setLabel("-");
        cmdCarneMenos.setName("cmdCarneMenos");

        javax.swing.GroupLayout panModificacionIngredienteLayout = new javax.swing.GroupLayout(panModificacionIngrediente);
        panModificacionIngrediente.setLayout(panModificacionIngredienteLayout);
        panModificacionIngredienteLayout.setHorizontalGroup(
            panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCantidadIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdExtraQuesoMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdExtraQuesoMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdAceitunasMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdAceitunasMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdCarneMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCarneMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdBaconMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdBaconMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdPimientosMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdPimientosMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdPinaMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdPinaMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdAnchoasMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdAnchoasMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                            .addComponent(cmdSalamiMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdSalamiMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                            .addComponent(cmdPolloMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdPolloMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        panModificacionIngredienteLayout.setVerticalGroup(
            panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                .addComponent(lblCantidadIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdAnchoasMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAnchoasMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdAceitunasMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdAceitunasMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdBaconMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdBaconMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdCarneMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCarneMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdExtraQuesoMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdPimientosMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panModificacionIngredienteLayout.createSequentialGroup()
                        .addComponent(cmdExtraQuesoMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(cmdPimientosMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdPinaMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdPinaMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmdPolloMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdPolloMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panModificacionIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cmdSalamiMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdSalamiMas, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtCantidadAnchoas.setBackground(new java.awt.Color(240, 240, 240));
        txtCantidadAnchoas.setEditable(false);
        txtCantidadAnchoas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadAnchoas.setName("");
        txtCantidadAnchoas.setText("0");

        txtCantidadAceitunas.setEditable(false);
        txtCantidadAceitunas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadAceitunas.setName("");
        txtCantidadAceitunas.setText("0");

        txtCantidadBacon.setEditable(false);
        txtCantidadBacon.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadBacon.setName("");
        txtCantidadBacon.setText("0");

        txtCantidadCarne.setEditable(false);
        txtCantidadCarne.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadCarne.setName("");
        txtCantidadCarne.setText("0");

        txtCantidadPollo.setEditable(false);
        txtCantidadPollo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadPollo.setName("");
        txtCantidadPollo.setText("0");

        txtCantidadPimientos.setEditable(false);
        txtCantidadPimientos.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadPimientos.setName("");
        txtCantidadPimientos.setText("0");

        txtCantidadPina.setEditable(false);
        txtCantidadPina.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadPina.setName("");
        txtCantidadPina.setText("0");

        lblSeleccionIngredientes.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblSeleccionIngredientes.setText("Selección");

        txtCantidadSalami.setBackground(new java.awt.Color(240, 240, 240));
        txtCantidadSalami.setEditable(false);
        txtCantidadSalami.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadSalami.setName("");
        txtCantidadSalami.setText("0");

        txtCantidadExtraQueso.setEditable(false);
        txtCantidadExtraQueso.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtCantidadExtraQueso.setName("");
        txtCantidadExtraQueso.setText("0");

        javax.swing.GroupLayout panUnidadesIngredienteLayout = new javax.swing.GroupLayout(panUnidadesIngrediente);
        panUnidadesIngrediente.setLayout(panUnidadesIngredienteLayout);
        panUnidadesIngredienteLayout.setHorizontalGroup(
            panUnidadesIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                .addGroup(panUnidadesIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panUnidadesIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidadPollo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadPina, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadPimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadBacon, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSeleccionIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCantidadAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtCantidadSalami, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtCantidadExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panUnidadesIngredienteLayout.setVerticalGroup(
            panUnidadesIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panUnidadesIngredienteLayout.createSequentialGroup()
                .addComponent(lblSeleccionIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadBacon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtCantidadCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtCantidadExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtCantidadPimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadPina, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadPollo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCantidadSalami, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtImporteBacon.setEditable(false);
        txtImporteBacon.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteBacon.setName("");
        txtImporteBacon.setText("0.0");

        txtImporteAceitunas.setEditable(false);
        txtImporteAceitunas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteAceitunas.setName("");
        txtImporteAceitunas.setText("0.0");

        txtImporteExtraQueso.setEditable(false);
        txtImporteExtraQueso.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteExtraQueso.setName("");
        txtImporteExtraQueso.setText("0.0");

        txtImporteAnchoas.setEditable(false);
        txtImporteAnchoas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteAnchoas.setName("");
        txtImporteAnchoas.setText("0.0");

        lblImporteIngredientes.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        lblImporteIngredientes.setName("");
        lblImporteIngredientes.setText("Importe");

        txtImporteSalami.setEditable(false);
        txtImporteSalami.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteSalami.setName("");
        txtImporteSalami.setText("0.0");

        txtImportePollo.setEditable(false);
        txtImportePollo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImportePollo.setName("");
        txtImportePollo.setText("0.0");

        txtImportePimientos.setEditable(false);
        txtImportePimientos.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImportePimientos.setName("");
        txtImportePimientos.setText("0.0");

        txtImportePina.setEditable(false);
        txtImportePina.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImportePina.setName("");
        txtImportePina.setText("0.0");

        txtImporteCarne.setEditable(false);
        txtImporteCarne.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        txtImporteCarne.setName("");
        txtImporteCarne.setText("0.0");

        javax.swing.GroupLayout panImporteIngredienteLayout = new javax.swing.GroupLayout(panImporteIngrediente);
        panImporteIngrediente.setLayout(panImporteIngredienteLayout);
        panImporteIngredienteLayout.setHorizontalGroup(
            panImporteIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panImporteIngredienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panImporteIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtImporteAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteBacon, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImportePimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImportePina, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImportePollo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtImporteSalami, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblImporteIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        panImporteIngredienteLayout.setVerticalGroup(
            panImporteIngredienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panImporteIngredienteLayout.createSequentialGroup()
                .addComponent(lblImporteIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImporteAnchoas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtImporteAceitunas, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(txtImporteBacon, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImporteCarne, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtImporteExtraQueso, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(txtImportePimientos, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtImportePina, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImportePollo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtImporteSalami, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblImporteTotal.setFont(new java.awt.Font("Dialog", 3, 12)); // NOI18N
        lblImporteTotal.setName("");
        lblImporteTotal.setText("Importe total pedido");

        txtImporteTotal.setEditable(false);
        txtImporteTotal.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        txtImporteTotal.setName("");
        txtImporteTotal.setText("0.0");

        javax.swing.GroupLayout panImporteTotalLayout = new javax.swing.GroupLayout(panImporteTotal);
        panImporteTotal.setLayout(panImporteTotalLayout);
        panImporteTotalLayout.setHorizontalGroup(
            panImporteTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panImporteTotalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(lblImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(txtImporteTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        panImporteTotalLayout.setVerticalGroup(
            panImporteTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(txtImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lblIngredientes.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblIngredientes.setText("3 - Escoger los ingredientes");

        javax.swing.GroupLayout panIngredientesLayout = new javax.swing.GroupLayout(panIngredientes);
        panIngredientes.setLayout(panIngredientesLayout);
        panIngredientesLayout.setHorizontalGroup(
            panIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIngredientesLayout.createSequentialGroup()
                .addComponent(lblIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panIngredientesLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panModificacionIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(panUnidadesIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panImporteIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panIngredientesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        panIngredientesLayout.setVerticalGroup(
            panIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panIngredientesLayout.createSequentialGroup()
                .addComponent(lblIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(panIngredientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panModificacionIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(panUnidadesIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(panImporteIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(panIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panImporteTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(panIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(11, 11, 11)
                                        .addComponent(PanSeleccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(panControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panSeleccionPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblBienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PanSeleccionTienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panSeleccionPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panConfirmarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>

   

	/**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


    }
    // Variables declaration - do not modify
    protected javax.swing.JPanel PanSeleccionTienda;
    protected javax.swing.JComboBox cmbFranquicias;
    protected java.awt.Button cmdAceitunasMas;
    protected java.awt.Button cmdAceitunasMenos;
    protected java.awt.Button cmdAnchoasMas;
    protected java.awt.Button cmdAnchoasMenos;
    protected java.awt.Button cmdBaconMas;
    protected java.awt.Button cmdBaconMenos;
    protected java.awt.Button cmdCarneMas;
    protected java.awt.Button cmdCarneMenos;
    protected java.awt.Button cmdExtraQuesoMas;
    protected java.awt.Button cmdExtraQuesoMenos;
    protected javax.swing.JButton cmdInicializar;
    protected java.awt.Button cmdPimientosMas;
    protected java.awt.Button cmdPimientosMenos;
    protected java.awt.Button cmdPinaMas;
    protected java.awt.Button cmdPinaMenos;
    protected java.awt.Button cmdPolloMas;
    protected java.awt.Button cmdPolloMenos;
    protected javax.swing.JButton cmdProcesarPedido;
    protected java.awt.Button cmdSalamiMas;
    protected java.awt.Button cmdSalamiMenos;
    protected javax.swing.JButton cmdSalir;
    private java.awt.Label lblAceitunas;
    private java.awt.Label lblAnchoas;
    private java.awt.Label lblBacon;
    protected java.awt.Label lblBienvenida;
    protected java.awt.Label lblCantidadIngredientes;
    private java.awt.Label lblCarne;
    protected java.awt.Label lblConfirmarPedido;
    private java.awt.Label lblExtraQueso;
    protected java.awt.Label lblFabrifca;
    protected java.awt.Label lblImporteIngredientes;
    protected java.awt.Label lblImporteTotal;
    private java.awt.Label lblIngrediente;
    protected java.awt.Label lblIngredientes;
    private java.awt.Label lblPimientos;
    private java.awt.Label lblPina;
    private java.awt.Label lblPollo;
    private java.awt.Label lblPrecioPizza;
    private java.awt.Label lblSalami;
    private java.awt.Label lblSeleccionIngredientes;
    private java.awt.Label lblTamanoPizza;
    protected javax.swing.JList lstPizza;
    protected javax.swing.JPanel panConfirmarPedido;
    protected javax.swing.JPanel panControl;
    protected javax.swing.JPanel panImporteIngrediente;
    protected javax.swing.JPanel panImporteTotal;
    protected javax.swing.JPanel panIngrediente;
    protected javax.swing.JPanel panIngredientes;
    protected javax.swing.JPanel panModificacionIngrediente;
    private javax.swing.JPanel panPrecioPizza;
    private javax.swing.JPanel panProcesoPedido;
    protected javax.swing.JPanel panSeleccionPizza;
    protected javax.swing.JPanel panUnidadesIngrediente;
    protected javax.swing.JProgressBar progBarEstadoPedido;
    protected javax.swing.JScrollPane scrollPizzas;
    protected java.awt.TextField txtCantidadAceitunas;
    protected java.awt.TextField txtCantidadAnchoas;
    protected java.awt.TextField txtCantidadBacon;
    protected java.awt.TextField txtCantidadCarne;
    protected java.awt.TextField txtCantidadExtraQueso;
    protected java.awt.TextField txtCantidadPimientos;
    protected java.awt.TextField txtCantidadPina;
    protected java.awt.TextField txtCantidadPollo;
    protected java.awt.TextField txtCantidadSalami;
    protected javax.swing.JTextField txtEstadoPedido;
    protected java.awt.TextField txtImporteAceitunas;
    protected java.awt.TextField txtImporteAnchoas;
    protected java.awt.TextField txtImporteBacon;
    protected java.awt.TextField txtImporteCarne;
    protected java.awt.TextField txtImporteExtraQueso;
    protected java.awt.TextField txtImportePimientos;
    protected java.awt.TextField txtImportePina;
    protected java.awt.TextField txtImportePollo;
    protected java.awt.TextField txtImporteSalami;
    protected java.awt.TextField txtImporteTotal;
    protected java.awt.TextField txtPrecioPizza;
    // Final de la declaración de variables.
	}
