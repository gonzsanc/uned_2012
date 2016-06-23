package naves.extensiones;

import datos.enumerados.TiposDecorador;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;
import naves.vehiculos.VehiculoAbstracto;

/**
 * Decora un vehículo o un componente con la extensión/compoente que sea.
 * Evitando de este modo recurrir masivamente a herencia o a una saturación de subclases.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class DecoradorNaves extends VehiculoAbstracto{

	// *** Decorador***
	protected VehiculoAbstracto componente=null;
	protected datos.enumerados.TiposDecorador tipo;
	
	/**
	 * Constructor. Hay que suministrale a la clase un componente para que pueda decorarlo.
	 * @param componente Un vehículo al que se le quiera añadir una capa.
	 */
	public DecoradorNaves(VehiculoAbstracto componente){
		super(null,componente.getGestor());
		this.componente = componente;
	}
	
	public TiposDecorador getTipoDecorador(){
		return tipo;
	}
	
	/**
	 * Devuelve el componente envuelto por esta clase.
	 * @return VehiculoAbstracto conteniendo el componente inmediatamente superior esta clase.
	 */
	public VehiculoAbstracto getComponente(){
		return componente;
	}
	
	/**
	 * Devuelve el vehículo que es envuelto por esta clase y sus componentes padre.
	 * @return VehiculoAbstracto con el vehículo envuelto.
	 */
	public VehiculoAbstracto getVehiculo(){
		return this.componente;
	}
	
	// *** VehiculoAbstracto ***
	

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#isMovimientoSolicitado()
	 */
	@Override
	public boolean isMovimientoSolicitado() {
		return componente.isMovimientoSolicitado();
	}

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#setMovimientoSolicitado(boolean)
	 */
	@Override
	public void setMovimientoSolicitado(boolean movimientoSolicitado) {
		componente.setMovimientoSolicitado(movimientoSolicitado);
	}

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#getTipo()
	 */
	@Override
	public TiposVehiculos getTipo() {
		return componente.getTipo();
	}

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#setSuceso(datos.TiposSucesos)
	 */
	@Override
	public void setSuceso(TiposSucesos suceso) {
		componente.setSuceso(suceso);
	}

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#getSuceso()
	 */
	@Override
	public TiposSucesos getUltimoSuceso() {
		
		return componente.getUltimoSuceso();
	}

	/* (non-Javadoc)
	 * @see naves.vehiculos.VehiculoAbstracto#SolicitarDesplazamiento()
	 */
	@Override
	public void SolicitarDesplazamiento() {
		componente.SolicitarDesplazamiento();
	}
	
}
