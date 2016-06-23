package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import observer.observable.Observable;

public class ListenerTeclado extends Observable implements KeyListener{

	private static ListenerTeclado c=null;

	
	public static ListenerTeclado Singleton(){
		if (c==null){
			c=new ListenerTeclado();
		}
		
		return c;
	}
	
	/**
	 * Se recoge un evento de pulsación de teclado y se guardan en el estado, tanto la tecla pulsada
	 * como el objeto que ha disparado el evento en formato String.
	 * La clase extraerCódigoCadena es capaz de extraer un Integer con el código de tecla pulsado.
	 * Para todo esto, se utiliza un caracter separador arbitrario.
	 * Este enfoque permite compartir un evento tipo KeyEvent a través de un observador que solo
	 * procesa estados representados por el tipo String.
	 */
	@Override
	public void keyPressed(KeyEvent ev) {
		String codigo = new Integer(ev.getKeyCode()).toString();
		codigo+="#";
		codigo+= ev.getSource().getClass().getSimpleName();
		asignarEstadoObservable(codigo);
		notificar();
	}

	
	
	@Override
	public int numeroObservadores() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	public static Integer extraerCodigoCadena(String cadena){
		String [] auxiliar=null;
		String caracterSeparador="#";
		Integer resultado=null;
		
		try{
			auxiliar = cadena.split(caracterSeparador);
			resultado = new Integer(auxiliar[0]);
			return resultado;
		}catch (Exception e){
			return null;
		}
	
	}
	
}