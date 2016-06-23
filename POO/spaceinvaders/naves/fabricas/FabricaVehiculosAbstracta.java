package naves.fabricas;

import gestion.GestorAbstracto;
import naves.IFabricaVehiculos;
import naves.vehiculos.VehiculoAbstracto;

public abstract class FabricaVehiculosAbstracta implements IFabricaVehiculos{

	@Override
	public abstract VehiculoAbstracto fabricarVehiculo(GestorAbstracto gestor) ;

}
