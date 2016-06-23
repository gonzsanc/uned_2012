package naves;

import gestion.GestorAbstracto;
import naves.vehiculos.VehiculoAbstracto;

public interface IFabricaVehiculos {
	
	public abstract VehiculoAbstracto fabricarVehiculo(GestorAbstracto gestor) ;
}
