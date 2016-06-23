/**
 * 
 */
package naves.fabricas;

import gestion.GestorAbstracto;
import naves.vehiculos.Misil;
import naves.vehiculos.VehiculoAbstracto;

/**
 * @author Gon
 *
 */
public class FabricaMisilNaveDefensa extends FabricaVehiculosAbstracta {

	/* (non-Javadoc)
	 * @see naves.fabricas.FabricaVehiculosAbstracta#fabricarVehiculo()
	 */
	@Override
	public VehiculoAbstracto fabricarVehiculo(GestorAbstracto gestor) {
		return (VehiculoAbstracto) new Misil(datos.enumerados.TiposVehiculos.misilDefensor, gestor);
	}


}
