package datos;

public abstract class ConfiguracionTimers {

	/* Este lo ponemos a double para aleatorizarlo */
	public static final int TIMER_NAVES_ENEMIGAS = 1500;
	public static final int TIMER_MISIL_UFO = 500;
	private static final int TIMER_MAX_DISPARO_ENEMIGO = 8000;
	public static final int TIMER_MIN_DISPARO_ENEMIGO = 500;
	
	public static int TIMER_DISPARO_ENEMIGO(){
		return TIMER_MIN_DISPARO_ENEMIGO + (int)(Math.random()*TIMER_MAX_DISPARO_ENEMIGO);
	}

	/* COEFICIENTE DE DURACION DE LOS DISTINTOS TIMERS DEL JUEGO */
	public static final int TIMER_NAVE_DEFENSA = 100;
	public static final int TIMER_MISIL_DEFENSA = 125;
}
