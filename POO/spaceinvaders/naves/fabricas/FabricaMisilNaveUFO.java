package naves.fabricas;


import gestion.GestorAbstracto;
import naves.vehiculos.Misil;
import naves.vehiculos.VehiculoAbstracto;

public class FabricaMisilNaveUFO extends FabricaVehiculosAbstracta {

	@Override
	public VehiculoAbstracto fabricarVehiculo(GestorAbstracto gestor) {
		return (VehiculoAbstracto) new Misil(datos.enumerados.TiposVehiculos.misilUFO, gestor);
	}

}
