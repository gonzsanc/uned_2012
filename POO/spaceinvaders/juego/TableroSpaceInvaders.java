	package juego;

import java.awt.Dimension;

import datos.ConfiguracionGUI;


public final class TableroSpaceInvaders extends TableroAbstracto {


	public TableroSpaceInvaders() {
		this.dimensionTablero = new Dimension (Configuracion.DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO,
												Configuracion.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO);
	}

	
	private final  class Configuracion extends ConfiguracionGUI {};

}
