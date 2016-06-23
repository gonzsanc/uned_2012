package gestion.gestores;
// Cuando se gestionen los eventos del tablero, hay que bloquearlo (cerrarlo).

import gestion.GestorAbstracto;
import gestion.GestorJuego;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashSet;
import java.util.Iterator;


import observer.IObservable;
import observer.IObservador;
import observer.observable.Observable;

import juego.TableroSpaceInvaders;


import datos.ConfiguracionGUI;
import datos.DefinicionPiezaImagenes;
import datos.enumerados.TiposVehiculos;
import datos.enumerados.TiposSucesos;

import naves.bridge.ImpVehiculo2D;
import naves.extensiones.componentes.ComponenteObserver;
import naves.vehiculos.Misil;
import naves.vehiculos.NaveBuena;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;



//añadirlo como observador al subgestordefensa y ufo
public class GestorTablero extends GestorAbstracto {
	
	private final TableroSpaceInvaders tablero;
	private boolean tableroModificado=false;
	private HashSet<ImpVehiculo2D> piezaDefensa=new HashSet<ImpVehiculo2D>();
	private HashSet<ImpVehiculo2D> piezasUFO=new HashSet<ImpVehiculo2D>();
	private HashSet<ImpVehiculo2D> laserDefensa=new HashSet<ImpVehiculo2D>();
	private HashSet<ImpVehiculo2D> laserMarciano=new HashSet<ImpVehiculo2D>();
	private boolean ocupado;
	private boolean cerrado;
	
	
	public GestorTablero()  {
		tablero = new TableroSpaceInvaders();
		//tablero.adscribir(this);
		/*ThreadLectura = new Thread(this,"monitorPiezas");
		ThreadLectura.start();
		*/
	}
	
	
	public boolean getIsTableroModificado(){
		return tableroModificado;
	}
	
	public boolean ocupado(){
		return ocupado;
	}
	
	
	public synchronized boolean ocupar(){
		boolean retorno=false;
		
		if (!ocupado && !cerrado){
			ocupado=true;
			retorno=true;
		}
		
		return retorno;
	}
	
	
	public void desocupar(){
		ocupado=false;
	}
	
	
	public HashSet<ImpVehiculo2D> obtenerPiezasTablero(){
		tableroModificado=false;
		return tablero.obtenerPiezasTablero();
	}

	
	public TableroSpaceInvaders obtenerTablero(){
		return tablero;
	}
	

		private void agregarPiezasATablero(){
			HashSet<ImpVehiculo2D> piezas = new HashSet<ImpVehiculo2D>();
			piezas.addAll(piezasUFO);
			piezas.addAll(piezaDefensa);
			piezas.addAll(laserDefensa);
			piezas.addAll(laserMarciano);
			tablero.asignarPiezasTablero(piezas);
		}
				
		
		public String obtenerTipoGestionado() {
			return "tablero";
		}

		
		public String obtenerIDElementoGestionado() {
			return null;
		}



		/* (non-Javadoc)
	 * @see observer.observadorObservable.ObservadorObservable#actualizar(observer.IObservable)
	 */
	@Override
	public void actualizar(IObservable sujeto) {
		Observable aux = (Observable) sujeto;
		
			//Si es la nave defensa o el misil, acudimos directamente al vehiculo.
			if (
				aux.getComponente()instanceof NaveBuena ||
				aux.getComponente() instanceof Misil 
					)
			{
				actualizarUnVehiculo(sujeto);
				
			}
			// Si es una nave UFO, acudimos al gestor.
			else{
				String nSuper = NaveUFO.class.getName();
				String nSub = aux.getComponente().getClass().getName();
				
				if (nSuper.equals(nSub)){
					actualizarUFOS(sujeto);
				}
			}

	}
	
	private void actualizarUnVehiculo(IObservable sujeto){
		VehiculoAbstracto va = ((Observable)sujeto).getComponente();
		ImpVehiculo2D v2d = new ImpVehiculo2D(va);
		boolean tipoCorrecto=false;
		
		if(v2d.getUltimoSuceso()!=null){
			switch (v2d.getUltimoSuceso()){
			case desplazado: case lanzado:
				tipoCorrecto=true;
				v2d.asignarRepresentacion2D(datos.DefinicionPiezaImagenes.ObtenerDefinicionesPiezas(v2d.getTipo()));
				actualizarDesplazamiento(v2d);
				break;
			case destruido:
				tipoCorrecto=true;
				actualizarDestruccion(v2d);
				break;
			}
			if(tipoCorrecto) agregarPiezasATablero();
		}
		
	}
	
	
	private void actualizarUFOS(IObservable sujeto){
		
		VehiculoAbstracto va =(VehiculoAbstracto) ((Observable)sujeto).getComponente();
		ImpVehiculo2D v2d = new ImpVehiculo2D(va);
		boolean tipoCorrecto=false;
		
		GestorNavesUFO g = (GestorNavesUFO) va.getGestor();
		
		if(g!=null && v2d.getUltimoSuceso()!=null){
		
			//Discriminación de eventos.
			//Desplazamiento.
			if (
				va.getUltimoSuceso()==TiposSucesos.desplazado
				||
				va.getUltimoSuceso()==TiposSucesos.lanzado
			){
				tipoCorrecto=true;
				actualizarDesplazamientoMultiple(g);
			}
			//Eliminacion.
			else if(
					va.getUltimoSuceso()==TiposSucesos.destruido
					)
			{
				tipoCorrecto=true;
				actualizarDestruccion(v2d);
			}
			
			
		}//if(g!=null && v2d.getUltimoSuceso()!=null)
	}
	
	public void actualizarDesplazamiento(ImpVehiculo2D v2d){

		
		ArrayList<String> representaciones = new ArrayList<String>();
		HashSet <ImpVehiculo2D> conjuntoAModificar=null;
		
		boolean tipoCorrecto=false;
		boolean multiple = false;
		
		switch (v2d.getTipo()){
			case misilDefensor:
				tipoCorrecto=true;
				conjuntoAModificar=this.laserDefensa;
				break;
			
			case misilUFO:
				tipoCorrecto=true;
				conjuntoAModificar=this.laserMarciano;
			
				
			case naveDefensa:
				tipoCorrecto=true;
				conjuntoAModificar=this.piezaDefensa;
				break;
			case naveUFO10:  case naveUFO20: case naveUFO40:
				multiple=true;
				tipoCorrecto=true;
				conjuntoAModificar=this.piezasUFO;
				break;
			default:
				tipoCorrecto=false;
				conjuntoAModificar=null;
					
		}
		
		
		if (tipoCorrecto){
			ArrayList<ImpVehiculo2D> aux = new ArrayList<ImpVehiculo2D> ();
			aux.addAll(conjuntoAModificar);
			aux.trimToSize();
			
			int tamano=aux.size();
			int i=0;
			
			while (i<tamano){
				if (aux.get(i).getID2D().equals(v2d.getID2D())){
					aux.remove(i);
					aux.trimToSize();
					break;
				}
				i++;
			}//while
		}//if
			
		
		representaciones= datos.DefinicionPiezaImagenes.ObtenerDefinicionesPiezas(v2d.getTipo());
		representaciones.trimToSize();
		v2d.asignarRepresentacion2D(representaciones);
		conjuntoAModificar.clear();
		conjuntoAModificar.add(v2d);

		ocupado=false;
		cerrado=false;
	}
	
	public void actualizarDestruccion(ImpVehiculo2D v2d){
		ArrayList<String> representaciones = new ArrayList<String>();
		HashSet <ImpVehiculo2D> conjuntoAModificar=null;
		
		boolean tipoCorrecto=false;
	
		
		switch (v2d.getTipo()){
			case misilDefensor:
				tipoCorrecto=true;
				conjuntoAModificar=this.laserDefensa;
				break;
			case misilUFO:
				tipoCorrecto=true;
				conjuntoAModificar=this.laserMarciano;
			
			case naveDefensa:
				tipoCorrecto=true;
				conjuntoAModificar=this.piezaDefensa;
				break;
			case naveUFO10:  case naveUFO20: case naveUFO40:
				tipoCorrecto=true;
				conjuntoAModificar=this.piezasUFO;
				break;	
		}
		
		
		if (tipoCorrecto){
				
			ArrayList<ImpVehiculo2D> aux = new ArrayList<ImpVehiculo2D> ();
			aux.addAll(conjuntoAModificar);
			
			int tamano=aux.size();
			int i=0;
			
			while (i<tamano){
				if (aux.get(i).getID2D().equals(v2d.getID2D())){
					aux.remove(i);
					break;
				}
				i++;
			}//while
			conjuntoAModificar.clear();
			conjuntoAModificar.addAll(aux);
		
			
			
		}//if

		ocupado=false;
		cerrado=false;
	}

	private Boolean actualizandoDesplazamientoMultiple= new Boolean(false);
	
	public void actualizarDesplazamientoMultiple(GestorAbstracto g){
		
		if (actualizandoDesplazamientoMultiple==false){
			actualizandoDesplazamientoMultiple=true;
			
			if(ImpVehiculo2D.parimparUFOs==0){
				ImpVehiculo2D.parimparUFOs++;
			}else{
				ImpVehiculo2D.parimparUFOs--;
			}
			
			HashSet<ImpVehiculo2D>auxHS=new HashSet<ImpVehiculo2D>();
			
			ArrayList<VehiculoAbstracto> arv = new ArrayList<VehiculoAbstracto>();
			arv.addAll(((GestorNavesUFO)g).getTodasNaves());
			
		//	Iterator<VehiculoAbstracto> it = ((GestorNavesUFO)g).getTodasNave s().iterator();
			Iterator<VehiculoAbstracto> it = arv.iterator();
			while (it.hasNext()){
				ImpVehiculo2D aux = new ImpVehiculo2D(it.next());
				ArrayList<String>representaciones= datos.DefinicionPiezaImagenes.ObtenerDefinicionesPiezas(aux.getTipo());
				representaciones.trimToSize();
				aux.asignarRepresentacion2D(representaciones);
			
				auxHS.add(aux);
			}
			
			this.piezasUFO.clear();
			this.piezasUFO.addAll(auxHS);
			agregarPiezasATablero();
			actualizandoDesplazamientoMultiple=false;
		}
	}


	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		// TODO Auto-generated method stub
		return null;
	}

		
}
	
	
