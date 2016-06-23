package datos;

import datos.enumerados.TiposVehiculos;

public abstract class ConfiguracionVehiculos {

	public static class ConfiguracionUFO{
		
		//CONFIGURACION
		/* El numero total de naves enemigas (FILAS X COLUMNAS) */
		//public static final int COLUMNAS_ENEMIGAS = 11;
		public static final int COLUMNAS_ENEMIGAS = 5;
		public static final int FILAS_ENEMIGAS = 5;
		
		/* Que tipo de nave UFO aparece en cada fila */
		public static final TiposVehiculos UFO_F1 = TiposVehiculos.naveUFO40;
		public static final TiposVehiculos UFO_F2 = TiposVehiculos.naveUFO20;
		public static final TiposVehiculos UFO_F3 = TiposVehiculos.naveUFO20;
		public static final TiposVehiculos UFO_F4 = TiposVehiculos.naveUFO10;
		public static final TiposVehiculos UFO_F5 = TiposVehiculos.naveUFO10;
	}

	public static class ConfiguracionDefensa{
	
		public static final int VIDAS = 3;
		/* Puntos con el que la defensora conquista el Universo */
		public static final int PUNTOS_CONQUISTA = 1000;
		public static final int FILA_NAVE_DEFENSORA = 1;
	}
	
	public static class Representacion2D{
		
	}
		
}
