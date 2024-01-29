package es.cristian.modelo.persistencia;

import java.util.ArrayList;

import es.cristian.modelo.entidad.Articulo;

public class DaoArticulo {
	
	private ArrayList<Articulo> listaArticulos;
	private int contador;
	
	public DaoArticulo() {
		listaArticulos = new ArrayList<>();
		
		
		//artículos de prueba
		
	    listaArticulos.add(new Articulo(++contador, "Artículo 1", "Descripción 1", 10, 100.0));
	    listaArticulos.add(new Articulo(++contador, "Artículo 2", "Descripción 2", 20, 200.0));
	    listaArticulos.add(new Articulo(++contador, "Artículo 3", "Descripción 3", 30, 300.0));
	    
	    //añadir el array al fichero???
	}
	
	//add
	public void add(Articulo art) {
		
		art.setId(++contador);
		listaArticulos.add(art);
		/*
		if(art.getId() > contador) {
			contador = art.getId();
		}else {
			art.setId(++contador);
			
		}
		listaArticulos.add(art);
		 * */
		 
	}
	
	//delete
	public  Articulo delete(int id) {
		
		
		for(int i= 0; 1 < listaArticulos.size(); i++) {
			if(listaArticulos.get(i).getId() == id) {
				return listaArticulos.remove(i);
			}
		}
		return null;
				
	}
	
	//get
	public Articulo get(int id) {
		
		for(Articulo a: listaArticulos) {
			if(a.getId() == id) {
				return a;
			}
		}
		return null;
	}
	
	//list
	public ArrayList<Articulo> getListaArticulos(){
		return listaArticulos;
	}
	
		
	

}
