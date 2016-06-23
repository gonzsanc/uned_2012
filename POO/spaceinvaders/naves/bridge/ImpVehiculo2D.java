/**
 * Define un puente entre la abstracción de nave y su representación como objeto 2D.
 */
package naves.bridge;

import gestion.GestorAbstracto;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import naves.vehiculos.VehiculoAbstracto;

public class ImpVehiculo2D extends VehiculoAbstracto {

	private Dimension dimensiones2D;
	private  String id2D;
	//private long id_unica;
	private  ArrayList<String> representacion;
	public static int parimparUFOs=0;
	GestorAbstracto gestor;
	VehiculoAbstracto componente;

	/**
	 * Elemento lógico que permite representar el conjunto de objetos cualquiera como una matriz de dos dimensiones con elementos comunes (cadenas y enteros).
	 * Según se informen los atributos de strPieza distintos objetos podrán hacer uso del tablero de forma sencilla.
	 * @param x posición horizontal.
	 * @param y posición vertical.
	 * @param representacion Un listado de cadenas ordenadas donde se especifique, por ejemplo, las rutas a las imágenes.
	 */
	public ImpVehiculo2D(VehiculoAbstracto vehiculo)
		 {
			super(null, vehiculo.getGestor());
			componente = vehiculo;
			this.tipoPieza=componente.getTipo();
			this.asignarID2D(vehiculo.toString());
			this.x=componente.obtenerX();
			this.y=componente.obtenerY();
			this.dimensiones2D= new Dimension(0,0);
			this.ultimoSuceso=componente.getUltimoSuceso();
		}
	
	
	public Dimension obtenerDimensiones(){
		return dimensiones2D;
	}
	
	public void asginarDimensiones(int ancho,int alto){
		if (ancho>-1 && alto>-1){
			dimensiones2D = new Dimension(ancho,alto);
		}
	}
	
	private void asignarID2D(String id){
		this.id2D=id;
	}
	
	public void asignarRepresentacion2D(ArrayList<String> representacion){
		this.representacion=representacion;
	}
	
	
	
	public ArrayList<String> obtenerRepresentacion2D(){
		return representacion;
	}
	
	public String getID2D(){
		return id2D;
	}
	

	public String obtenerRepresentacion() {
		
		return this.representacion.get(ImpVehiculo2D.parimparUFOs);
	}

	
}
