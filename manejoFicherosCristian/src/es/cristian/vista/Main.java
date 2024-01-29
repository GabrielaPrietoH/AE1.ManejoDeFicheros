package es.cristian.vista;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

import es.cristian.controlador.Controlador;
import es.cristian.modelo.entidad.Articulo;

public class Main {
	
	 public static final String nombreFichero = "articulos.dat";
	 public static final String fileName = "articulos.csv";

	public static void main(String[] args) {
		
		Controlador controlador = new Controlador();
		Scanner leer = new Scanner(System.in);
		
		//Array para leer el fichero
		//ArrayList<Articulo> listaArticulos = new ArrayList<>();
		
		
		File fichero = new File(nombreFichero);
		if(fichero.exists()) {
			
			//1. leerlo 
			try(FileInputStream file = new FileInputStream(fichero);
					ObjectInputStream ois = new ObjectInputStream(file)){
				
				
				//Leído
				ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>)ois.readObject();
				
				//Escribir en el array: Recorrer cada artículo de la lista y agregarlo al controlador->DAO
				for(Articulo a: listaArticulos) {
					controlador.addArticulo(a);
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
			
			
			
			//System.out.println("Cerrando programa");
			
		
			
			
			//2. para llenar una colección de tipo ArrayList con todos los 
			//objetos ‘Articulo’ existentes en el fichero.
			
			
		}else {
			/*
			 * Si no existe el archivo, no tendrás nada que hacer por el momento,
				pero sí debes dejar la colección ArrayList disponible, aunque esté
				vacía.
			 */
			//ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>)ois.readObject();
		}

		
		String eleccion = "";
		boolean continuar = true;
		
		do {
			
			System.out.println("\n Elige una opción del menú numérico: \n");
			System.out.println("1. Añadir nuevo artículo.");
			System.out.println("2. Borrar artículo por id.");
			System.out.println("3. Consulta artículo por id.");
			System.out.println("4. Listado de todos los artículos.");
			System.out.println("5. Terminar el programa.");
			System.out.println("6. Exportar artículos a archivos CSV.");
			eleccion = leer.nextLine();
			
			//Me aseguro de recibir un número
			try {
				int choice = Integer.parseInt(eleccion);
				
				if(choice == 1) {
					System.out.println("Has elegido añadir un nuevo artículo.");
					
					Articulo art = new Articulo();
					System.out.println("Introduce un nombre para el artículo: ");
					String nombre = leer.nextLine();
					art.setNombre(nombre);
					System.out.println("Introduce una descripción para el artículo: ");
					String descripcion = leer.nextLine();
					art.setDescripcion(descripcion);
					System.out.println("Introduce el stock del artículo: ");
					double stock = leer.nextDouble();
					leer.nextLine(); //consume el resto de la línea.
					art.setStock(stock);
					System.out.println("Introduce el precio del artículo: ");
					double precio = leer.nextDouble();
					leer.nextLine();
					art.setPrecio(precio);
										
					//Se pasa el artículo al Controlador->DAO
					controlador.addArticulo(art);
					
					System.out.println("has añadido el artículo: " + art);
					
				}else if(choice == 2) {
					System.out.println("Has elegido borrar un artículo por su id.");
					System.out.println("Elige qué artículo quieres borrar mediante su ID. Aquí tienes el listado: ");
					System.out.println(controlador.getListaArticulos());
					int idElegido = leer.nextInt();	
					leer.nextLine();
					
					System.out.println("has borrado el artículo: " + controlador.getArticulo(idElegido));
					controlador.deleteArticulo(idElegido);
					
					
								
					
					
				}else if(choice == 3) {
					
					System.out.println("Has elegido consultar un artículo por id.");
					System.out.println("Elige qué artículo consultar  mediante su ID. Aquí tienes el listado: ");
					System.out.println(controlador.getListaArticulos());
					int idElegido = leer.nextInt();	
					leer.nextLine();
					
					Articulo articulo = controlador.getArticulo(idElegido);
					
					if(articulo != null) {
						System.out.println("El artículo con id " + idElegido + " es: " + articulo);
					}else {
						System.out.println("No se encontró el artículo con ID: " + idElegido);
					}
					
					
					
					
				}else if(choice == 4) {
					System.out.println("Has elegido recibir un listado de todos los artículos.");
					
					ArrayList<Articulo> listaArt = controlador.getListaArticulos();
					
					//Si hay artículos lso imprime, sino lo avisa.
					if(listaArt.isEmpty()) {
						System.out.println("No hay artículos en el listado.");
					}else {
						for(Articulo a: listaArt) {
							System.out.println(a);
						}
					}
					
					
					
					
				}else if(choice == 5) {
					System.out.println("Has elegido terminar el programa.");
					
					System.out.println("Creando fichero...");
					
					File file = new File(nombreFichero);
					try(FileOutputStream fos = new FileOutputStream(file);
							ObjectOutputStream oos = new ObjectOutputStream(fos)) {
						
						//Array con el listado de artículos.
						ArrayList<Articulo> listado = controlador.getListaArticulos();
						oos.writeObject(listado);
						System.out.println("Fichero creado con éxito");
						System.out.println("Fin del programa");
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Error al escribir en el archivo: " + e.getMessage());
				} 
			
					
					
					continuar = false;
					
					
				}else if(choice == 6) {
					
					
					System.out.println("Se va a exportar a formato CSV el siguiente archivo: " + fileName);
					
					ArrayList<Articulo> listado = controlador.getListaArticulos();
					controlador.exportar(fileName, listado);
				}
				
				
			}catch(NumberFormatException e) {
				System.out.println("La elección no es un número válido, vuelve a intentarlo.");
			}
			
			
			
		}while(continuar);
		
		leer.close();
	}
	
}

