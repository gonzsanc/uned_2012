package naves.vehiculos;

import datos.enumerados.TiposVehiculos;
import gestion.GestorAbstracto;

public class NaveBuena extends VehiculoAbstracto {

	public NaveBuena(GestorAbstracto gestor) {
		super(TiposVehiculos.naveDefensa, gestor);
		// TODO Auto-generated constructor stub
		super.setOrigen(this.toString());
	}

}
