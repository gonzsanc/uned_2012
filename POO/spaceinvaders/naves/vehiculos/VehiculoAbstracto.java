package naves.vehiculos;

import gestion.GestorAbstracto;
import gestion.gestores.GestorNavesUFO;

import java.awt.Point;


import observer.IObservable;
import observer.IObservador;
import observer.observable.Observable;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;

import naves.IVehiculo;



public  abstract class VehiculoAbstracto implements IVehiculo, IObservable {

	protected Point ordenInicial = new Point();
	protected Point posicionInicial = new Point();
	
	protected boolean desplazarse = false;
	protected boolean desplazado = false;
	protected int max_x;
	protected int max_y;
	protected Observable componente_observable;
	protected TiposVehiculos tipoPieza;
	protected TiposSucesos ultimoSuceso;
	protected GestorAbstracto gestor = null;
	
//	public VehiculoAbstracto(TiposVehiculos tipo){
//		
//	}
	
	public VehiculoAbstracto(TiposVehiculos tipo, GestorAbstracto gestor){
		componente_observable = new Observable();
		tipoPieza=tipo;
		componente_observable.setComponente(this);
	
		this.gestor=gestor;
	}
	
	public GestorAbstracto getGestor(){
		return gestor;
	}
	
	public void setGestor(GestorAbstracto gestor){
		this.gestor=gestor;
	}
	/**
	 * @return the componente_misil
	 */
	public VehiculoAbstracto getComponente_misil() {
		return componente_misil;
	}

	/**
	 * @param componente_misil the componente_misil to set
	 */
	public void setComponente_misil(VehiculoAbstracto componente_misil) {
		this.componente_misil = componente_misil;
	}

//	/**
//	 * @return the componente_observer
//	 */
//	public VehiculoAbstracto getComponente_observer() {
//		return componente_observable;
//	}
//
//	/**
//	 * @param componente_observer the componente_observer to set
//	 */
//	public void setComponente_observer(VehiculoAbstracto componente_observer) {
//		this.componente_observable = componente_observer;
//	}


	protected boolean movimientoSolicitado=false;

	protected int x;
	protected int y;
	protected int dx;
	protected int dy;
	
	protected VehiculoAbstracto componente_misil=null;
	//protected VehiculoAbstracto componente_observer=null;
	

	
	public void asignarPosicion(Point punto){
		this.x = punto.x;
		this.y=punto.y;
	}
	
	public void asignarX(int x){
		this.x=x;
	}
	
	public void asignarY(int y){
		this.y=y;
	}
	
	public Point getPosicion(){
		return new Point(x,y);
	}
	
	public int obtenerX(){
		return x;
	}
	public int obtenerY(){
		return y;
	}
	
	
	/**
	 * @return Si se ha solicitado un movimiento.
	 */
	public boolean isMovimientoSolicitado() {
		return movimientoSolicitado;
	}

	/**
	 * @param movimientoSolicitado the movimientoSolicitado to set
	 */
	public void setMovimientoSolicitado(boolean movimientoSolicitado) {
		this.movimientoSolicitado = movimientoSolicitado;
	}

	@Override
	public TiposVehiculos getTipo() {
		return tipoPieza;
	}
	
	public void setTipo(TiposVehiculos tipo){
		this.tipoPieza=tipo;
	}
	
	public void setSuceso(TiposSucesos suceso){
		this.ultimoSuceso=suceso;
		notificar();
	}
	
	public TiposSucesos getUltimoSuceso(){
		return ultimoSuceso;
	}

	@Override
	public void SolicitarDesplazamiento() {
		if (!desplazarse && tipoPieza != null) {
			desplazarse = true;
		}
	}
	
//	public void Mover() {
//		if (desplazarse) {
//			x += dx;
//			y += dy;
//			
//			desplazarse = false;
//		}
//
//		if (x == max_x || y == 0) {
//			
//		}
//		
//		notificar();
//	}
	
	
	public void asginarDY(int dy) {
		this.dy = dy;
	}

	public void asignarDX(int dx) {
		this.dx = dx;
	}

	public void asginarMaximaPosicionHorizontal(int max_x) {
		this.max_x = max_x;
	}

	public void asignarMaximaPosicionVertical(int max_y) {
		this.max_y = y;
	}


	public void AsignarPosicion(int x, int y) {
		this.x = x;
		this.y = y;
		
		if (this.ultimoSuceso==TiposSucesos.lanzado ||
				this.ultimoSuceso == TiposSucesos.desplazado){
			this.setSuceso(TiposSucesos.desplazado);
		}
	}
	
	public void destruirPieza(){
		this.setSuceso(TiposSucesos.destruido);
		this.setSuceso(TiposSucesos.detenido);
	}

	
	
	
	public boolean obtenerEstadoSolicitudDesplazamiento() {
		return desplazarse;
	}

	@Override
	public void adscribir(IObservador observador) {
		componente_observable.adscribir(observador);
		
	}

	@Override
	public void quitar(IObservador observador) {
		componente_observable.quitar(observador);
		
	}

	@Override
	public void notificar() {
		componente_observable.notificar();
		
	}

	@Override
	public Object obtenerEstadoObservable() {
		return this.getUltimoSuceso().toString();
	}

	@Override
	public int numeroObservadores() {
		return componente_observable.numeroObservadores();
	}

	@Override
	public void asignarEstadoObservable(String estado) {	}

	@Override
	public String getOrigen() {
		return componente_observable.getOrigen();
	}

	@Override
	public void setOrigen(String origen) {
		componente_observable.setOrigen(origen);
		
	}

	@Override
	public String getAccion() {
		return componente_observable.getAccion();
	}

	@Override
	public void setAccion(String accion) {
		componente_observable.setAccion(accion);
		
	}

}
