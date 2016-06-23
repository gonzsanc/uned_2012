/**
 * 
 */
package naves.fabricas;

import gestion.GestorAbstracto;
import datos.enumerados.TiposVehiculos;

import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;

/**
 * @author Gonzalo Sánchez Pla.
 *
 */
public class FabricaNaveUFO3 extends FabricaVehiculosAbstracta {


	/* (non-Javadoc)
	 * @see naves.fabricas.FabricaVehiculosAbstracta#fabricarPieza()
	 */
	@Override
	public VehiculoAbstracto fabricarVehiculo(GestorAbstracto gestor) {
		return (VehiculoAbstracto) new NaveUFO(TiposVehiculos.naveUFO10, gestor);
	}

}
