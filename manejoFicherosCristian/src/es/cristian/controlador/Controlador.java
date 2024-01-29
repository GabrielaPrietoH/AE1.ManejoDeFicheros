package es.cristian.controlador;

import java.util.ArrayList;

import es.cristian.modelo.entidad.Articulo;
import es.cristian.modelo.entidad.CSVExport;
import es.cristian.modelo.persistencia.DaoArticulo;

public class Controlador {
	
	private DaoArticulo daoArt;
	private CSVExport exp;
	
	public Controlador() {
		this.daoArt = new DaoArticulo();
		this.exp = new CSVExport();
	}
	
	//add
	public void addArticulo(Articulo art) {
		
		//Recibo el objeto Artículo que rellene el usuario y lo añado en memoria
		//del ArrayList de Dao.
		
		daoArt.add(art);
	}
	
	//delete
	public void deleteArticulo(int id) {
		//recibo la posición y elimino ese objeto del Array en Dao.
		daoArt.delete(id);
	}
		
	//get
	public Articulo getArticulo(int id) {
		for(Articulo a: daoArt.getListaArticulos()) {
			if(a.getId() == id) {
				return a;
			}
		}
		//No se encontró
		//System.out.println("No se encontró el artículo con ID: " + id);
		return null;
	}
	
	//list
	public ArrayList<Articulo> getListaArticulos() {
		return daoArt.getListaArticulos();
	}
	
	public void exportar(String FileName, ArrayList<Articulo> listaArticulos) {
		exp.toCSV(FileName, listaArticulos);
	}
	
		

}
