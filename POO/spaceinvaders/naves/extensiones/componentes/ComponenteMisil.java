/**
 * 
 */
package naves.extensiones.componentes;

import datos.enumerados.TiposDecorador;
import datos.enumerados.TiposVehiculos;
import naves.extensiones.DecoradorNaves;
import naves.hangar.HangarVehiculos;
import naves.vehiculos.VehiculoAbstracto;

/**
 * @author Gonzalo Sánchez Pla.
 *
 */
public class ComponenteMisil extends DecoradorNaves {

	VehiculoAbstracto misil;
	
	/**
	 * @param componente
	 */
	public ComponenteMisil(VehiculoAbstracto componente) {
		super(componente);
	}
	
	public void setTipoMisil(TiposVehiculos tipo){
		super.tipo = TiposDecorador.misil;
		
		switch (tipo){
		case misilDefensor:
			misil = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(tipo, componente.getGestor());
			break;
		case misilUFO:
			misil = (VehiculoAbstracto) new HangarVehiculos().getVehiculo(tipo,componente.getGestor());
			break;
		default:
			misil=null;
					
		}
	}

	public VehiculoAbstracto getMisil(){
		return misil;
	}

	public void setMisil(VehiculoAbstracto misil){
		this.misil=misil;
	}
}
