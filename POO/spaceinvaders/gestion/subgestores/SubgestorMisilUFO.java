/**
 * 
 */
package gestion.subgestores;

import java.util.ArrayList;

import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;
import naves.extensiones.componentes.ComponenteMisil;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;

/**
 * Define un misil UFO.
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class SubgestorMisilUFO extends SubgestorMisilAbstracto {

	public SubgestorMisilUFO(VehiculoAbstracto misil,NaveUFO nave) {
		super(misil,nave);
		super.tipo=TiposVehiculos.misilUFO;
		super.sentidoSolicitado=-1;
		this.misil.setGestor(this);
	}

	
	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		ArrayList<VehiculoAbstracto> aux = new ArrayList<VehiculoAbstracto> ();
		aux.add(this.misil);
		aux.trimToSize();
		return aux;
	}

	

}
