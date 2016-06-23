package naves;

import datos.enumerados.TiposVehiculos;

/**
 * @author Gonzalo Sánchez Pla
 * 
 */
public interface IVehiculo{
	public TiposVehiculos getTipo();
	public void SolicitarDesplazamiento();
	
}
