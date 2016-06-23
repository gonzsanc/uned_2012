/**
 * 
 */
package gestion.subgestores;

import java.util.ArrayList;

import observer.IObservable;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;
import naves.extensiones.DecoradorNaves;
import naves.extensiones.componentes.ComponenteMisil;
import naves.vehiculos.NaveBuena;
import naves.vehiculos.VehiculoAbstracto;

/**
 * @author Gonzalo Sánchez Pla.
 *
 */
public final class SubgestorMisilDefensa extends SubgestorMisilAbstracto {

	/**
	 * @param misil
	 */
	public SubgestorMisilDefensa(VehiculoAbstracto misil, NaveBuena nave) {
		super(misil,nave);
		super.tipo=TiposVehiculos.misilDefensor;
		super.sentidoSolicitado=1;
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
