package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.ietf.jgss.Oid;

import entidad.Articulo;
import negocio.GestorArticulos;


public class DaoAlmacen {

	private static final String FICHERO = "almacen.dat";
	/*
	 * Metrodo que introduce un objeto usuario en un fichero en formto USUARIO/PASSWORD
	 * @param usuario que queremos introducir en el fichero
	 * @return true en caso de que hayamos introducido el usuario en el fhicero
	 * false en caso contraio.
	 */
	
	private ArrayList<Articulo> listarArticulos;
	private int contador;
	
	
	public ArrayList<Articulo> ficheroExiste() {
		File fichero = new File(FICHERO);
		if(fichero.exists()) {
			
			//1. leerlo 
			try(FileInputStream file = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(file)){
				
				//Leído
			
				ArrayList<Articulo> listaArticulos = ((ArrayList<Articulo>)ois.readObject());
				
				//Escribir en el array: Recorrer cada artículo de la lista y agregarlo al controlador->DAO
				for(Articulo a: listaArticulos) {
					GestorArticulos gestorArticulos = new GestorArticulos();
					GestorArticulos.añadirArticulos(a);
				}
				
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		
		}else {
			return null;

		}
		return listarArticulos;
	
	}
	
	public DaoAlmacen() {
		listarArticulos = new ArrayList<>();
		
	//artículos de prueba
		try(FileWriter fw = new FileWriter(FICHERO, true);
				BufferedWriter pw = new BufferedWriter(fw);) {
		listarArticulos.add( new Articulo(contador++,"nombre1","descripcion1",120,12.50));
		listarArticulos.add( new Articulo(contador++,"nombre2","descripcion2",100,9.50));
		listarArticulos.add( new Articulo(contador++,"nombre3","descripcion3",90,15.50));
		
	} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch(NullPointerException e) {
		System.err.println("Pesadilla de error");
			e.printStackTrace();
		}
		//ya no hace falta cerrar los recursos ya que se cerraran automaticamente
	}
	public void añadir(Articulo articulo) {
		
		//Importante poner true para añadir al fichero cuando se abra, sino borra todo
		try(FileWriter fw = new FileWriter(FICHERO, true);
				BufferedWriter pw = new BufferedWriter(fw);) {
			
			pw.newLine();
			pw.write(contador);
			pw.write(articulo.getNombre());
			pw.write(articulo.getDescripcion());
			pw.write((int) articulo.getStock());
			pw.write((int) articulo.getPrecio());
			pw.flush();
			
			articulo.setId(++contador);
			listarArticulos.add(articulo);
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch(NullPointerException e) {
		System.err.println("Pesadilla de error");
			e.printStackTrace();
		}
		//ya no hace falta cerrar los recursos ya que se cerraran automaticamente
	}
	
	public Articulo borrar(int id) {
	
		
		 boolean encontrado = false;

		    try (ObjectOutputStream escribir = new ObjectOutputStream(new FileOutputStream(FICHERO));
		         ObjectInputStream leer = new ObjectInputStream(new FileInputStream(FICHERO))) {

		    	for(int i= 0; 1 < listarArticulos.size(); i++) {
					if(listarArticulos.get(i).getId() == id) {
						return listarArticulos.remove(i);
					}
				}
				return null;

		    } catch (EOFException eof) {
		        if (!encontrado) {
		          return null;
		        }
		    } catch (FileNotFoundException fnf) {
		        System.out.println("Archivo no encontrado " + fnf.toString());
		    } catch (IOException ioe) {
		        ioe.printStackTrace();
		    } catch (Exception e) {
		        System.out.println("Error al leer el archivo. "+ e.getMessage());
		    }

		  
			return null;
		}

		
	
	/**
	 * Método que devuelve un objeto persona a partir de un id
	 * @return el objeto articulo si existe en el fichero, null en caso 
	 * de que no exista
	 */
	public  Articulo getArticuloPorId(int id) {

		try (FileReader fr = new FileReader(FICHERO);
			   BufferedReader br = new BufferedReader(fr);) {
			for(Articulo a: listarArticulos) {
				if(a.getId() == id) {
					return a;
				}
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	

	
	public ArrayList<Articulo> getListaArticulos() {
		
		return listarArticulos;
	}
}
