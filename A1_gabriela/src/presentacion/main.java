package presentacion;

import java.io.EOFException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entidad.Articulo;
import negocio.GestorArticulos;



public class main {

	 public static final String fileName = "articulos.csv";
	 
	public static void main(String[] args) throws EOFException {
		
		System.out.println("Bienvenido al Programa");
		Articulo articulo = new Articulo();
		GestorArticulos al = new GestorArticulos();
		Scanner sc = new Scanner(System.in);
		int opcion;

		al.ficheroCreado();
		System.out.println(al);
		
		 ArrayList<Articulo> listaArt;
			try {
				listaArt = al.ficheroCreado();
				if(listaArt.isEmpty()) {
					System.out.println("No hay artículos en el listado.");
				}else {
					for(Articulo a: listaArt) {
						System.out.println(a);
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		
		do {
			
			System.out.println("Menu de opciones:\n"
					+ "1.Añadir nuevo artículo\r\n"
					+ "2.Borrar artículo por id\r\n"
					+ "3.Consulta artículo por id\r\n"
					+ "4.Listado de todos los artículos\r\n"
					+ "5.Exportar archivo CSV\r\n"
					+ "6.Terminar el programa");

			System.out.println("Escoge una opcion: ");
			
			
			opcion = sc.nextInt();
			int ID = 0;
			
			try {
			switch(opcion) {
			
			case 1:
			
					System.out.println("Bienvenido al almacen");
					System.out.println("Agregue un Articulo");
					System.out.println("introduzca el nombre: ");
					String nombre = sc.nextLine();
					nombre = sc.nextLine();
					articulo.setNombre(nombre);
					System.out.println("El nombre es " + nombre);
					System.out.println("introduzca el descripcion: ");
					String descripcion = sc.nextLine();
					articulo.setDescripcion(descripcion);
					System.out.println("introduzca el stock: ");
					int stock = sc.nextInt();
					articulo.setStock(stock);
					System.out.println("introduzca el precio: ");
					double precio = sc.nextDouble();
					articulo.setPrecio(precio);
					al.añadirArticulos(articulo);
					
					System.out.println("has añadido el artículo: " + articulo);
					break;
				
			case 2:	
				
				System.out.println("Bienvenido al almacen");
				System.out.println("introduzca el ID que desea borrar: ");
				ID = sc.nextInt();	

				Articulo estaBorrado = al.borrarArticulo(ID);
				if(estaBorrado != null) {
					System.out.println("Articulo borrado correctamente");
				}else {
					System.out.println("Articulo NO BORRADO");
				}
				
			     break;
			   
			  
			 case 3:
				
				 System.out.println("Bienvenido al almacen");
				 System.out.println("introduzca el ID que desea consultar: ");
				 ID = sc.nextInt();	

				 Articulo consultarArticulo = al.consultarArticulo(ID);
				 if(consultarArticulo != null) {
						System.out.println("El articulo es: " + consultarArticulo);
				 }else {
						System.out.println("Articulo NO ENCONTRADO");
				 }
					
				 break; 
			
			 case 4:
				 
			
				 System.out.println("Bienvenido al almacen");
	
				 
				 ArrayList<Articulo> listaArticulos;
				try {
					listaArticulos = GestorArticulos.getListarArticulos();
					if(listaArticulos.isEmpty()) {
						System.out.println("No hay artículos en el listado.");
					}else {
						for(Articulo a: listaArticulos) {
							System.out.println(a);
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					
				 break; 
				 
			 case 5:
				 
					System.out.println("Se va a exportar a formato CSV el siguiente archivo: " + fileName);
					
					ArrayList<Articulo> listado = GestorArticulos.getListarArticulos();
					GestorArticulos.exportar(fileName, listado);
					break;
				 
			 case 6:
				
				 System.out.println("Ha decidido salir del programa");
				 break;
			}
			
			}catch(Exception e) {
				System.out.println("Opcion incorrecta");
			}
					 
			 
		}while(opcion != 5);
		
		System.out.println("Programa Terminado");

		}
}


