package gestion.gestores;

import java.awt.Point;
import java.util.ArrayList;

import naves.bridge.ImpVehiculo2D;
import naves.vehiculos.VehiculoAbstracto;

public interface IGestorUFO {

	/**
	 * Devuelve un arreglo con todas las coordenadas ocupadas por naves UFO.
	 * @return ArrayList con las coordenadas.
	 */
	public abstract ArrayList<Point> obtenerPosicionesNaves();

	/**
	 * Permite destruir una nave en unas coordenadas específicas.
	 * @param x coordenada horizontal.
	 * @param y coordenada vertical.
	 */

	public abstract void destruirNave(int x, int y);

	/**
	 * Elimina una nave UFO de la lista.
	 * @param auxNave nave UFO.
	 */
	public abstract void destruirNave(final VehiculoAbstracto auxNave);

	public abstract void detenerTimer();

	public abstract void iniciarTimer();

	public abstract ArrayList<ImpVehiculo2D> obtenerPiezas2DGenericas();

}