package GUI;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import datos.ConfiguracionGUI;


/*
 * Esta clase es un panel con una imagen de fondo.
 */
public abstract class CanvasConImagen extends Canvas {

	/**
	 * Eclipse pide generar esta variable.
	 */
	private static final long serialVersionUID = -4264151796080653669L;
	protected int ancho =datos.ConfiguracionGUI.TAMANO_CANVAS.width;
	protected int alto = datos.ConfiguracionGUI.TAMANO_CANVAS.height;
	
	protected Image imagenCanvas;
	protected Image ImagenDeFondo;
	protected Image imagenSuperpuesta;
	protected boolean ocupado;
	protected boolean inicializado=false;

	/**
	 * Constructor. Obligatorio pasar como par�metro un objeto imagen.
	 * 
	 * @param imagenCanvas
	 *            . Objeto de java.awt.image.BufferedImage.
	 */
	public CanvasConImagen(){
	}
	
	/**
	 * Consturctor de la clase.
	 * Recibe una cadena con la ruta completa a la imagen de fondo.
	 * Esa imagen siempre aparecerá como fondo del canvas hasta que se solicite su modificación.
	 * @param imagenFondo Ruta a la imagen de fondo de canvas.
	 */
	public CanvasConImagen(String imagenFondo) {
		
		this.setSize(ConfiguracionGUI.TAMANO_CANVAS.width,
				ConfiguracionGUI.TAMANO_CANVAS.height);
		inicializaImagenSuperpuesta();
		ImagenDeFondo= new ImagenExtendida(imagenFondo).obtenerImagen();
		Graphics g2 =ImagenDeFondo.getGraphics();
		
		imagenCanvas = new BufferedImage(this.getSize().width,this.getSize().height,BufferedImage.TYPE_INT_RGB);
		
		Graphics g1 = imagenCanvas.getGraphics();
		
		g2.drawImage(new ImagenExtendida(imagenFondo).obtenerImagen(),0,0,null);
		g1.drawImage(ImagenDeFondo,0,0,null);
		//asignarImagenDeFondoCanvas(imagenCanvas);
	}
	
	private void inicializaImagenSuperpuesta(){
		
		imagenSuperpuesta =  new BufferedImage(this.getSize().width,this.getSize().height,BufferedImage.TYPE_INT_ARGB);
	}

	
	
	/**
	 * Cambia la imagen de fondo, sin alterar la imagen superpuesta.
	 * @param imagenOffscreen
	 */
	public void asignarImagenDeFondoCanvas(Image imagenOffscreen){
		ImagenDeFondo=imagenOffscreen;
		Graphics g2 = imagenCanvas.getGraphics();
		g2.drawImage(ImagenDeFondo,0,0,null);
		g2.drawImage(imagenSuperpuesta,0,0,null);
	}
	
	public void cambiarImagenDeFondoCanvas(String rutaImagen){
		ImagenDeFondo =new ImagenExtendida(rutaImagen).obtenerImagen();
		asignarImagenDeFondoCanvas(ImagenDeFondo);
		repaint();
	}
	
	public  void limpiarSinRepaint(){
		imagenSuperpuesta=null;
		imagenSuperpuesta = new BufferedImage(this.getSize().width,this.getSize().height,BufferedImage.TYPE_INT_RGB);
		Graphics g2 = imagenSuperpuesta.getGraphics();
		g2.drawImage(ImagenDeFondo,0,0,null);
	}
	
	
	
	protected void pintar (int x, int y,String rutaImagen){
		Graphics g2 = imagenSuperpuesta.getGraphics();
		Image img = new ImagenExtendida(rutaImagen).obtenerImagen();
		g2.drawImage(img, x,y,null);
		Graphics g3= imagenCanvas.getGraphics();
		g3.drawImage(imagenSuperpuesta,0,0,null);
	}

	
	
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(imagenCanvas,0,0,null);
		inicializado=true;
	}
	
	@Override
	public void update(Graphics g){
		g.drawImage(imagenCanvas,0,0,null);
		inicializado=true;
	}
	
	

}
