package negocio;

import java.io.EOFException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import entidad.Articulo;
import entidad.CSVExport;
import persistencia.DaoAlmacen;

public class GestorArticulos {
	
	private static DaoAlmacen daoAlmacen;
	private static CSVExport exp;

	public GestorArticulos() {
		
		this.daoAlmacen = new DaoAlmacen();
		this.exp = new CSVExport();
	}


	/**
	 * Metodo que agrega un usuario a la persistencia
	 * @param usuario a agregar al motor de persistencia
	 * @return true en caso de que usuario se haya agregado, false 
	 * en caso contrario.
	 */
	public ArrayList<Articulo> ficheroCreado() {
		
	ArrayList<Articulo> ficheroExiste = (ArrayList<Articulo>) daoAlmacen.getListaArticulos();
	return ficheroExiste;
		
	}
	
	public static Articulo añadirArticulos(Articulo articulo) {

		daoAlmacen.añadir(articulo);
			return articulo;
	}
	
	
	public Articulo borrarArticulo(int id) {
		
		Articulo estaBorrado = daoAlmacen.borrar(id);
		return estaBorrado;
		
	}
	
	
	public Articulo consultarArticulo(int id) {
		for(Articulo a: daoAlmacen.getListaArticulos()) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	
	public static ArrayList<Articulo> getListarArticulos(){
		return daoAlmacen.getListaArticulos();
		
	}
	
	public static void exportar(String FileName, ArrayList<Articulo> listaArticulos) {
		exp.toCSV(FileName, listaArticulos);
	}
	
}


	

