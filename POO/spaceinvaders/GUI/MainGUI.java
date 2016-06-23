package GUI;

import gestion.gestores.GestorCanvasSpaceInvaders;

import javax.swing.*;

import observer.IObservable;
import observer.IObservador;
import observer.observadorObservable.ObservadorObservable;


import datos.ConfiguracionGUI;


import java.awt.event.*;
import java.awt.*;

import java.awt.image.BufferedImage;
import java.util.*;
import java.awt.event.KeyListener;

public class MainGUI extends JFrame implements ActionListener, IObservable {
	
	JFrame frame;
	ObservadorObservable ooInterno;
	/*
	public void ShowDialogBox(){
		  frame = new JFrame("Show Message Dialog");
		  JButton button = new JButton("Click Me");
		  button.addActionListener(new MyAction());
		  frame.add(button);
		  frame.setSize(400, 400);
		  frame.setVisible(true);
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  }*/
	 /*
	 public class MyAction implements ActionListener{
		  public void actionPerformed(ActionEvent e){
		  JOptionPane.showMessageDialog(frame,"Roseindia.net");
		  }
	 }
	 */

	/**
	 * Exigido por Eclipse.
	 */
	protected static final long serialVersionUID = -7176613539092305405L;

	protected int ancho;
	protected int alto;
	protected String nombre;

	private JPanel p = new JPanel();
	private GestorCanvasSpaceInvaders canvasJuego;
	private ImagenExtendida imgFondoCanvas;
	
	
	
	private JButton botonInicio;
	private JButton botonFin;
	private JButton botonMusica;
	private JButton botonPausar;
	private JButton botonAcercaDe;

	public MainGUI() {
		super("Práctica UNED 2012 - Space Invaders - Gonzalo Sánchez Pla");
		nombre = "Frame principal";
		this.alto = 600;
		this.ancho = 700;
		setSize(this.ancho, this.alto);
		ooInterno = new ObservadorObservable();
		Inicializa();
		InicializarListeners();
		crearWindowListener();

		
	}
	
	protected void Inicializa() {
		CrearPanel();
		CreaBotones();
		CrearFondoInvaders();
	}
	

	
	protected void CrearPanel(){
		this.add(p);
		p.setLayout(new BorderLayout());
	}


	protected void InicializarListeners() {
		AgregarListenerABoton(botonInicio, this);
	}

	protected void CreaBotones() {
		JPanel pbotones = new JPanel();
		pbotones.setLayout(new GridLayout(1, 4));
		pbotones.setSize(500, 100);
		p.add(pbotones, BorderLayout.SOUTH);

		botonInicio = new JButton("Iniciar");
		botonInicio.setText("Comenzar");
		pbotones.add(botonInicio);

		botonFin = new JButton("Finalizar");
		pbotones.add(botonFin);

		botonPausar = new JButton("Pausa");
		pbotones.add(botonPausar);

		botonMusica = new JButton("Musica OFF");
		pbotones.add(botonMusica);

		botonAcercaDe = new JButton("Informacion");
		pbotones.add(botonAcercaDe);
	}

	protected void CrearFondoInvaders() {
		//imgFondoCanvas= new subgestorImagenes(Datos.DefinicionGUI.imagenFondoJuego);
		canvasJuego = new GestorCanvasSpaceInvaders();
		p.add(canvasJuego,BorderLayout.CENTER);

		
	}
	
	public Canvas obtenerCanvasPanel(){
		return this.canvasJuego;
	}
	
	public JPanel obtenerPanel(){
		return this.p;
	}
	
	
	/**
	 * Cuando se pulse una tecla mientras el foco lo reciba el JFrame, los objetos asignados mediante
	 * este método recibirán la notificación de dicha pulsación y la tecla.
	 * @param lector objeto interesado en conocer qué teclas se pulsan.
	 */
	public void asignarLectorDeTeclado(KeyListener lector) {
		this.addKeyListener(lector);
		canvasJuego.addKeyListener(lector);
		botonInicio.addKeyListener(lector);
		botonFin.addKeyListener(lector);
		botonMusica.addKeyListener(lector);
		botonPausar.addKeyListener(lector);
		botonAcercaDe.addKeyListener(lector);

	}

	protected void AgregarListenerABoton(JButton boton, EventListener objeto) {
		boton.addActionListener((ActionListener) objeto);
	}

	public void AgregarListenerBotonMusica(ActionListener objeto) {
		AgregarListenerABoton(botonMusica, objeto);
	}

	
	/* EVENTOS */
	private void crearWindowListener(){
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	

	@Override
	public void actionPerformed(ActionEvent elemento) {
		System.out.println("Botones --->");
		System.out.println(elemento.getActionCommand() + ": "
				+ ActionEvent.ACTION_PERFORMED);
	}

	public void actionPerformed(EventObject elemento) {

	}

	public void actionPerformed(KeyEvent elemento) {
		System.out.println(elemento.getKeyChar());
		char tecla = elemento.getKeyChar();
		String strTecla = Character.toString(tecla);
		int codigoTecla = elemento.getKeyCode();

		if (strTecla.toLowerCase() == "o" || strTecla.toLowerCase() == "p") {

		} else if (codigoTecla == KeyEvent.VK_SPACE
				|| codigoTecla == KeyEvent.VK_ESCAPE) {

		}
	}
	
	

	/*
	protected class gestorEventosPersonalizados extends Observador {

		
		@Override
		public void GestionarEventoPersonalizado(EventObject e) {

			if (e instanceof EventosGestorMusica) {
				tiposEventosGestorMusica tipo = ((EventosGestorMusica) e).TIPO_EVENTO;

				switch (tipo) {
				case reproducir:
					break;
				case pausar:
					break;
				case detener:
					break;
				case reanudar:
					break;
				}

			} else if (e instanceof EventosPartida) {
				tiposEventosPartida tipo = ((EventosPartida) e).TIPO_EVENTO;

				switch (tipo) {
				case iniciar:
					break;
				case detener:
					break;
				case pausar:
					break;
				case reanudar:
					break;
				case salvamosElMundoDeLosInvasores:
					break;
				case invasoresGanan:
					break;
				}

			} else if (e instanceof EventosTablero) {
				TiposEventosTablero tipo = ((EventosTablero) e).TIPO_EVENTO;

				switch (tipo) {
				case actualizado:
					break;
				case inicializado:
					break;
				}

			} else {
				// ...
			}

		}

	}
	
	
	*/
	
	public void actualizarImagenJuego(BufferedImage imagen) {
		canvasJuego.asignarImagenDeFondoCanvas(imagen);
	}

	//ObservadorObservable.
	@Override
	public void adscribir(IObservador observador) {
		ooInterno.adscribir(observador);
		
	}

	@Override
	public void quitar(IObservador observador) {
		ooInterno.quitar(observador);
		
	}

	@Override
	public void notificar() {
		ooInterno.notificar();
		
	}

	@Override
	public Object obtenerEstadoObservable() {
		return ooInterno.obtenerEstadoObservable();
	}

	@Override
	public int numeroObservadores() {
		return ooInterno.numeroObservadores();
	}

	@Override
	public void asignarEstadoObservable(String estado) {
		ooInterno.asignarEstadoObservable(estado);
		
	}

	@Override
	public String getOrigen() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOrigen(String origen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getAccion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAccion(String accion) {
		// TODO Auto-generated method stub
		
	}

}
