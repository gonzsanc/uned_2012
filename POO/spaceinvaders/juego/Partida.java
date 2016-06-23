package juego;

import java.awt.event.*;
import java.util.Iterator;

import observer.observadorObservable.ObservadorObservable;



/**
 * Representa el estado y curso de la partida. Implementa un gestor de eventos
 * al que pueden suscribirse otras clases que implementen IEventListener. El
 * sistema de de eventos (EventosPartida) comunica todos los cambios que va
 * teniendo la partida. Esta clase no conoce de las reglas del juego, sino tan
 * solo de los curso y estado del mismo.
 * 
 * @author Gonzalo Sanchez Pla
 * 
 */
public abstract class Partida extends ObservadorObservable  {

	protected boolean detenida = true;
	protected boolean enCurso = false;
	protected boolean enPausa = false;

	public Partida() {
	}

	public void ComenzarPartida() {
		if (this.detenida) {
			this.enCurso = true;
			this.detenida = false;
			this.enPausa = false;
			super.asignarEstadoObservable("encurso");
			notificar();
		}
	}

	public void PausarPartida() {
		if (this.enCurso) {
			this.enPausa = true;
			this.enCurso = false;
			super.asignarEstadoObservable("enpausa");
			notificar();
		}
	}

	public void DenenerPartida() {
		if (this.enCurso || this.enPausa) {
			this.enCurso = false;
			this.detenida = true;
			this.enPausa = false;
			super.asignarEstadoObservable("detenido");
			notificar();
		}
	}

	public void ReanudarPartida() {
		if (this.enPausa) {
			this.enCurso = true;
			this.enPausa = false;
			super.asignarEstadoObservable("reanudado");
			notificar();
		}
	}

	public boolean encurso() {
		return this.enCurso;
	}

	public boolean enPausa() {
		return this.enPausa;
	}

}
