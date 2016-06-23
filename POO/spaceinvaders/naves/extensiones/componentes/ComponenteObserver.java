package naves.extensiones.componentes;
import observer.IObservable;
import observer.IObservador;
import observer.observadorObservable.ObservadorObservable;

import datos.enumerados.TiposDecorador;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;



import naves.extensiones.DecoradorNaves;
import naves.vehiculos.VehiculoAbstracto;

public class ComponenteObserver extends DecoradorNaves implements IObservador,IObservable {

	
	DecoradorNaves d;
	ObservadorObservable oo;
	
	
	// *** Decorador. ***
	public ComponenteObserver(VehiculoAbstracto componente){
		super(componente);
		super.tipo = TiposDecorador.observadorObservable;

		d = new DecoradorNaves(componente);
		oo = new ObservadorObservable();
	}
	
	
	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#getComponente()
	 */
	public VehiculoAbstracto getComponente() {
		return d.getComponente();
	}
	
	
	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#getComponente()
	 */
	public TiposDecorador getTipoDecorador(){
		return this.tipo;
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#getVehiculo()
	 */
	
	public VehiculoAbstracto getVehiculo() {
		return d.getVehiculo();
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#isMovimientoSolicitado()
	 */
	
	public boolean isMovimientoSolicitado() {
		return d.isMovimientoSolicitado();
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#setMovimientoSolicitado(boolean)
	 */
	
	public void setMovimientoSolicitado(boolean movimientoSolicitado) {
		d.setMovimientoSolicitado(movimientoSolicitado);
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#getTipo()
	 */
	
	public TiposVehiculos getTipo() {
		return d.getTipo();
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#setSuceso(datos.TiposSucesos)
	 */
	
	public void setSuceso(TiposSucesos suceso) {
		d.setSuceso(suceso);
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#getSuceso()
	 */
	
	public TiposSucesos getUltimoSuceso() {
		return d.getUltimoSuceso();
	}

	/* (non-Javadoc)
	 * @see naves.extensiones.DecoradorNaves#SolicitarDesplazamiento()
	 */
	
	public void SolicitarDesplazamiento() {
		d.SolicitarDesplazamiento();
	}


	// *** Observador Observable ***
	
	@Override
	public void adscribir(IObservador observador) {
		oo.adscribir(observador);
		
	}

	
	@Override
	public void quitar(IObservador observador) {
		oo.quitar(observador);
		
	}


	@Override
	public void notificar() {
		oo.notificar();
		
	}


	@Override
	public Object obtenerEstadoObservable() {
		oo.obtenerEstadoObservable();
		return null;
	}

	
	@Override
	public int numeroObservadores() {
		oo.numeroObservadores();
		return 0;
	}


	@Override
	public void asignarEstadoObservable(String estado) {
		oo.asignarEstadoObservable(estado);
		
	}

	
	@Override
	public void actualizar(IObservable sujeto) {
		oo.actualizar(sujeto);
		
	}
	
	


}
