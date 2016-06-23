package juego;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.util.HashSet;

import observer.observador.Observador;
import observer.observadorObservable.ObservadorObservable;


import naves.bridge.*;




public abstract class TableroAbstracto extends ObservadorObservable implements Runnable{

	protected Dimension dimensionTablero = new Dimension(0,0);
	protected Graphics2D grafico;
	HashSet<ImpVehiculo2D> piezas = new HashSet<ImpVehiculo2D>();
	protected boolean actualizado = false;
	protected boolean ocupado = false;

	
	public void limpiar() {
		piezas.clear();
	}

	public boolean getOcupado() {
		return ocupado;
	}

	public boolean isActualizado() {
		return actualizado;
	}

	public Dimension obtenerDimensionesTablero() {
		return dimensionTablero;
	}

	public int obtenerAnchoTablero() {
		return dimensionTablero.width;
	}

	public int obtenerAltoTablero() {
		return dimensionTablero.height;
	}

	public synchronized HashSet<ImpVehiculo2D> obtenerPiezasTablero() {
		ocupado=true;
		this.actualizado=false;
		ocupado=false;
		return piezas;
	}

	public void asignarPiezasTablero(HashSet<ImpVehiculo2D> piezas) {
		ocupado=true;
		this.piezas.clear();
		this.piezas = piezas;
		this.actualizado=true;
		ocupado=false;
	}
	
	protected abstract class Configuracion{};
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
	}

}