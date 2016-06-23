package gestion.gestores;

import naves.extensiones.componentes.ComponenteObserver;
import naves.extensiones.componentes.ComponenteMisil;
import naves.extensiones.componentes.TiposComponente;
import naves.extensiones.DecoradorNaves;

import naves.vehiculos.NaveBuena;
import naves.vehiculos.VehiculoAbstracto;

public abstract class GestorComponente {

	
	public static boolean esObservador(VehiculoAbstracto componente){
	
		if (componente instanceof ComponenteObserver ){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static boolean esMisil(VehiculoAbstracto componente){
		if (componente instanceof ComponenteMisil){
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public static VehiculoAbstracto getComponenteAntesDe(VehiculoAbstracto componente, TiposComponente tipoEncontrar, TiposComponente tipoPosterior) throws ClassNotFoundException{
		DecoradorNaves componenteActual;
		DecoradorNaves componenteDeReferencia;
		DecoradorNaves componenteAnterior=null;
		
		componenteActual=(DecoradorNaves)componente;
		
		boolean encontrado=false;
	
		do{
			if (componenteActual.getClass() == getTipo(tipoPosterior).getClass()){
				encontrado=true;
			}else{
				componenteActual = (DecoradorNaves) componenteActual.getComponente();
			}
			
		}while (!encontrado && componenteActual.getComponente().getClass().isAssignableFrom(Class.forName(DecoradorNaves.class.getName())));
		
		
		if (encontrado){
			componenteDeReferencia=componenteActual;
			componenteActual=(DecoradorNaves) componenteDeReferencia.getComponente();
		}
		
		if (encontrado && componenteActual.getClass().isAssignableFrom(new DecoradorNaves(null).getClass()) ){
			encontrado=false;
			
			do{
				if (componenteActual.getClass()==getTipo(tipoEncontrar).getClass()){
					componenteAnterior=componenteActual;
				}else{
					
					if (componenteActual.getClass()==getTipo(tipoPosterior).getClass()){
						componenteDeReferencia=componenteActual;
					}
					componenteActual=(DecoradorNaves) componenteActual.getComponente();
				}
				
			}while (!encontrado && componenteActual.getComponente().getClass().isAssignableFrom(Class.forName(DecoradorNaves.class.getName())));
		}
		
		
		return componenteAnterior;
		
	}

	
	public static VehiculoAbstracto getComponenteDespuesDe(VehiculoAbstracto componente, 
			TiposComponente tipoAnterior, TiposComponente tipoEncontrar) throws ClassNotFoundException{
		
		DecoradorNaves componenteActual;
		//DecoradorNaves componenteDeReferencia;
		DecoradorNaves componentePosterior=null;
		
		componenteActual=(DecoradorNaves)componente;
		
		boolean seguir=true;
		boolean encontrado=false;
		
			
			while (seguir){
				
				do{
					if(componenteActual.getClass()==getTipo(tipoEncontrar).getClass()){
						componentePosterior=componenteActual;
						encontrado=true;
						seguir=false;
					}else{
						
						componenteActual=(DecoradorNaves) componenteActual.getComponente();
						seguir=true;
					}
				} while (!encontrado && componenteActual.getComponente().getClass().isAssignableFrom(Class.forName(DecoradorNaves.class.getClass().getName())) );
				
				
				if (encontrado && componenteActual.getComponente().getClass().isAssignableFrom(Class.forName(DecoradorNaves.class.getClass().getName()))){
					
					encontrado=false;
					
					do{
						componenteActual=(DecoradorNaves) componenteActual.getComponente();
						
						if (componenteActual.getClass()==getTipo(tipoAnterior).getClass())
						{
							//componenteDeReferencia=componenteActual;
							encontrado=true;
							seguir=false;
						}
						else
						{
							if (componenteActual.getClass()==getTipo(tipoEncontrar).getClass()){
								componentePosterior=componenteActual;
								encontrado=false;
								seguir=true;
							}
							
						}
						
						
					}while(!encontrado);
				} //fin if.
				
			}// while seguir.
			
		return componentePosterior;
		
	}

	public static VehiculoAbstracto getComponenteDeVehiculo(VehiculoAbstracto vehiculo, TiposComponente tipoComponente){
		
		return null;
	}
	
	protected static VehiculoAbstracto getTipo(TiposComponente tipo){
		switch (tipo){
		case misil:
			return new ComponenteMisil(null);
		case naveDefensa:
			return  new  NaveBuena(null);
		case naveUFO:
			return null;
		case observador:
			return new ComponenteObserver(null);
		default:
			return null;
		}
	}
	
	protected static <T,Q> boolean coincidenTipos (T tipo1,Q tipo2){
			
			if (tipo1.getClass() == tipo2.getClass()){
				return true;
			}
			else
			{
				return false;
			}
		}
	
}
