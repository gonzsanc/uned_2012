/**
 * 
 */
package naves.hangar;

import gestion.GestorAbstracto;

import java.util.HashSet;

import datos.enumerados.TiposVehiculos;


import naves.fabricas.*;
import naves.vehiculos.VehiculoAbstracto;

/**
 * Implementa el fabricante de piezas.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class HangarVehiculos  {

	HashSet<VehiculoAbstracto> parqueVehiculos= new HashSet<VehiculoAbstracto>();
	
	/* (non-Javadoc)
	 * @see naves.IFabricantePiezas#Fabricar(naves.IPiezaMovil)
	 */
	
	public VehiculoAbstracto getVehiculo(TiposVehiculos tipoPieza, GestorAbstracto gestor) {
		VehiculoAbstracto auxV;
		
		switch (tipoPieza){
		case misilDefensor:
			auxV = (VehiculoAbstracto) new FabricaMisilNaveDefensa() .fabricarVehiculo(gestor);
			break;
		case misilUFO:
			auxV = (VehiculoAbstracto) new FabricaMisilNaveUFO() .fabricarVehiculo(gestor); 
			break;
		case naveDefensa:
			auxV = (VehiculoAbstracto) new FabricaNaveDefensora() .fabricarVehiculo(gestor);
			
			break;
		case naveUFO10:
			auxV = (VehiculoAbstracto) new FabricaNaveUFO1()  .fabricarVehiculo(gestor);
			break;
		case naveUFO20:
			auxV = (VehiculoAbstracto) new FabricaNaveUFO2() .fabricarVehiculo(gestor); 
			break;
		case naveUFO40:
			auxV = (VehiculoAbstracto) new FabricaNaveUFO3() .fabricarVehiculo(gestor); 
			break;
			default:
				auxV=null;
		}
		
		if (auxV!=null){
			parqueVehiculos.add(auxV);
		}
		
		return  auxV;
	}

}
