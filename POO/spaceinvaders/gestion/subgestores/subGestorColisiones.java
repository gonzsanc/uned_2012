package gestion.subgestores;


import gestion.GestorAbstracto;
import gestion.GestorJuego;

import java.util.ArrayList;
import java.util.Iterator;

import observer.IObservable;
import observer.observable.Observable;

import datos.ConfiguracionGUI;
import datos.enumerados.TiposSucesos;
import datos.enumerados.TiposVehiculos;

import naves.bridge.ImpVehiculo2D;
import naves.vehiculos.Misil;
import naves.vehiculos.NaveBuena;
import naves.vehiculos.NaveUFO;
import naves.vehiculos.VehiculoAbstracto;



/**
 * Extiende ObservadorObservable para detectar colisiones entre piezas.
 * @author Gonzalo Sánchez Pla.
 *
 */
public class subGestorColisiones extends gestion.GestorAbstracto  {
	
	private VehiculoAbstracto[][][] matrizPosiciones;
	private Integer[][] reglasDeColision;
	private int D1 = ConfiguracionGUI.DIVISIONES_DE_OCUPACION_HORIZONTAL_DEL_TABLERO;
	private int D2 = ConfiguracionGUI.DIVISIONES_DE_OCUPACION_VERTICAL_DEL_TABLERO;
	
	private GestorAbstracto gestorNaveDefensa;
	private GestorAbstracto gestorNavesUFO;
	private GestorAbstracto gestorMisilUFO;
	private GestorAbstracto gestorMisilDefensa;
	private GestorAbstracto gestorJuego;
	
	public void setGestorJuego(GestorAbstracto g){
		this.gestorJuego=g;
	}
	
	

	/**
	 * El constructor crea una matriz, la cual puede albergar 2 piezas en cada par xy.
	 */
	public subGestorColisiones(){
		matrizPosiciones = new VehiculoAbstracto[D1][D2][2];
		reglasDeColision = new Integer[3][4];
		//inicializarReglas();
	}
	
	
	
	/**
	 * Define las reglas de colisión. Primero se indican los dos elementos que pueden 
	 * colisionar, después el índice relativo al elemento que vence en la colisión.
	 * Por último el efecto de dicha colisión.
	 */
//	private void inicializarReglas(){
//		reglasDeColision[0][0]= TiposVehiculos.misilDefensor.ordinal();
//		reglasDeColision[0][1]= TiposVehiculos.naveUFO10.ordinal();
//		reglasDeColision[0][2]= 0;
//		reglasDeColision[0][3]= TiposSucesos.destruido.ordinal();
//		
//		reglasDeColision[0][0]= TiposVehiculos.misilDefensor.ordinal();
//		reglasDeColision[0][1]= TiposVehiculos.naveUFO20.ordinal();
//		reglasDeColision[0][2]= 0;
//		reglasDeColision[0][3]= TiposSucesos.destruido.ordinal();
//		
//		reglasDeColision[0][0]= TiposVehiculos.misilDefensor.ordinal();
//		reglasDeColision[0][1]= TiposVehiculos.naveUFO40.ordinal();
//		reglasDeColision[0][2]= 0;
//		reglasDeColision[0][3]= TiposSucesos.destruido.ordinal();
//		
//		
//		
//		reglasDeColision[1][0]= TiposVehiculos.misilUFO.ordinal();
//		reglasDeColision[1][1]= TiposVehiculos.naveDefensa.ordinal();
//		reglasDeColision[1][2]= 0;
//		reglasDeColision[1][3]= TiposSucesos.destruido.ordinal();
//				
//		reglasDeColision[2][0]= TiposVehiculos.naveDefensa.ordinal();
//		reglasDeColision[2][1]= TiposVehiculos.naveUFO10.ordinal();
//		reglasDeColision[2][2]= 1;
//		reglasDeColision[2][3]= TiposSucesos.vencedor.ordinal();
//	}

	/**
	 * Este método permite vaciar la matriz con las piezas del juego de un tipo determinado.
	 * El resto de elementos se conservará.
	 * @param tiposVehiculos
	 */
	private void limpiarMatrizDePiezasTipo(TiposVehiculos tiposVehiculos){
		for (int i = 0;i<D1;i++){
			for(int j=0;j<D2;j++){
				for (int k=0;k<2;k++){
					VehiculoAbstracto auxPieza = matrizPosiciones[i][j][k];
					if (auxPieza!=null){
						TiposVehiculos id = auxPieza.getTipo();
						if (id==tiposVehiculos){
							matrizPosiciones[i][j][k]=null;
						}
					}
				}
			}
		}
	}
	
	/**
	 * Una vez limpia la matriz de piezas de un tipo, se rellena de nuevo con las nuevas piezas.
	 * Cada par x,y  de la matriz soporta dos elementos simultáneamente.
	 * @param arrayList
	 */
	private void insertarPiezasEnMatriz(ArrayList<VehiculoAbstracto> arrayList){
		
		for (VehiculoAbstracto aux : arrayList){
			int orden =0;
			int x = aux.obtenerX();
			int y = aux.obtenerY();
			
			if (this.matrizPosiciones[x][y][0]!=null){
				orden=1;
			}
			matrizPosiciones[x][y][orden]=aux;
		}
	}
	
	private void eliminarPiezaEnMatriz(String cadena){
		for (int i = 0;i<D1;i++){
			for(int j=0;j<D2;j++){
				for (int k=0;k<2;k++){
					if (matrizPosiciones[i][j][k]!=null){
					
						if (matrizPosiciones[i][j][k].toString().equals(cadena)){
							matrizPosiciones[i][j][k]=null;
							break;
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * Se borran todas las posiciones donde haya una pieza de ese tipo antes de insertar el resto.
	 * @param impVehiculo2D
	 */
	private void gestionarEventoDeColision(VehiculoAbstracto vehiculo){
		
		//Hay que traerse el gestor porque esta clase contiene una colección de todas las piezas.
		try{
			actualizarMovimientoDePiezas(vehiculo.getGestor().getArrayListDeElementos());
			resolverColisiones();
		}catch (Exception e){
			
			((GestorJuego)gestorJuego).pararTodo();
		}
		
	}
	
	private void actualizarMovimientoDePiezas(ArrayList<VehiculoAbstracto> arrayList){

		limpiarMatrizDePiezasTipo(arrayList.get(0).getTipo());
		if (arrayList.size()>0){
			insertarPiezasEnMatriz(arrayList);
		}
	}
	
	@Override
	public void actualizar(IObservable sujeto) {
		Observable aux = (Observable) sujeto;
		
		if (aux.getComponente() instanceof Misil){
			
			VehiculoAbstracto va = aux.getComponente();
			
			if(va.getUltimoSuceso()==TiposSucesos.desplazado || va.getUltimoSuceso()==TiposSucesos.lanzado){	
				gestionarEventoDeColision(new ImpVehiculo2D(va));
			}
	
		}else{
			if (aux.getComponente() instanceof NaveBuena || aux.getComponente() instanceof NaveUFO){
				actualizarMovimientoDePiezas(aux.getComponente().getGestor().getArrayListDeElementos());
			}
		}

	}
	
	
	private void resolverColisiones(){
		for (int i = 0;i<D1;i++){
			for(int j=0;j<D2;j++){
					VehiculoAbstracto auxPieza1 = matrizPosiciones[i][j][0];
					VehiculoAbstracto auxPieza2 = matrizPosiciones[i][j][1];
					if (auxPieza1!=null && auxPieza2!=null){
						
					    String ID1=obtenerTipoCorto(auxPieza1.getTipo());
						String ID2 =obtenerTipoCorto(auxPieza2.getTipo());
				//		System.out.println(auxPieza1.obtenerIDUnica() +" "+ auxPieza2.obtenerIDUnica());
						
						if (
							( ID1.equals("naveUFO") && ID2.equals(TiposVehiculos.misilDefensor.toString()) )
							||
							( ID2.equals("naveUFO") && ID1.equals(TiposVehiculos.misilDefensor.toString()) )
							||
							( ID1.equals(TiposVehiculos.naveDefensa.toString()) && ID2.equals(obtenerTipoCorto(TiposVehiculos.misilUFO)) )
							||
							( ID2.equals(TiposVehiculos.naveDefensa.toString()) && ID1.equals(obtenerTipoCorto(TiposVehiculos.misilUFO)) )
						 ){
							
							eliminarPiezaEnMatriz(auxPieza1.toString());
							eliminarPiezaEnMatriz(auxPieza2.toString());
							
							auxPieza1.setSuceso(TiposSucesos.destruido);
							auxPieza2.setSuceso(TiposSucesos.destruido);
			
							
						}
						
						
						if (
							(ID1==TiposVehiculos.naveDefensa.toString() && ID2 == "naveUFO")
							||
							(ID2==TiposVehiculos.naveDefensa.toString() && ID1 == "naveUFO")
						){
								
							if (ID1==TiposVehiculos.naveDefensa.toString()){
//								auxPieza2.setSuceso(TiposSucesos.vencedor);
//								auxPieza1.setSuceso(TiposSucesos.bloqueado);
//								auxPieza1.notificar();
//								auxPieza2.notificar();
								((GestorJuego)gestorJuego).pararTodo();
							}else{
//								auxPieza1.setSuceso(TiposSucesos.vencedor);
//								auxPieza2.setSuceso(TiposSucesos.bloqueado);
//								auxPieza1.notificar();
//								auxPieza2.notificar();
								((GestorJuego)gestorJuego).pararTodo();
							}
								
						}
					}
			}
		
		}
	}
	
	
	private void MostrarMatrices(){
		for (int i = 0;i<D1;i++){
			for(int j=0;j<D2;j++){
				for (int k=0;k<2;k++){
					VehiculoAbstracto auxPieza = matrizPosiciones[i][j][k];
					if (auxPieza!=null){
						//System.out.println(auxPieza.obtenerID() + "-" + auxPieza.obtenerX() + "|" + auxPieza.obtenerY());
					}
				}
			}
		}
	}
	
	
	private String obtenerTipoCorto(TiposVehiculos tipo){
		String tipoS=null;
		
		switch (tipo){
		case naveUFO10: case naveUFO20: case naveUFO40:
			tipoS =  tipo.toString().substring(0,7);
			break;
		case misilDefensor: case misilUFO: case naveDefensa:
			tipoS = tipo.toString();
			break;
		}
		return tipoS;
		
	}



	@Override
	public ArrayList<VehiculoAbstracto> getArrayListDeElementos() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
