package ficheros_almacen_artículos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AlmacenApp implements Serializable{

	
	private static final long serialVersionUID = 5520601760842208001L;
	private static ArrayList<Artículo> listaArticulos;
	private static final String NOMBRE_FICHERO = "articulos.dat";
	private static final String NOMBRE_CSV = "articulos.csv";
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		inicializarListaArticulos();

		int opcion;
		do {
			mostrarMenu();
			System.out.print("Ingrese la opción deseada: ");
			opcion = scanner.nextInt();
			scanner.nextLine(); 

			switch (opcion) {
			case 1:
				agregarArticulo();
				break;
			case 2:
				borrarArticulo();
				break;
			case 3:
				consultarArticulo();
				break;
			case 4:
				listarArticulos();
				break;
			case 5:
				exportarAArchivoCSV();
				break;
			case 6:
				terminarPrograma();
				break;
			default:
				System.out.println("Opción no válida. Inténtelo de nuevo.");
			}

		} while (opcion != 6);
	}

	private static void inicializarListaArticulos() {
		File file = new File(NOMBRE_FICHERO);
		if (file.exists()) {
			listaArticulos = (ArrayList<Artículo>) LecturaListaArtículos.cargarArticulosDesdeArchivo(file);
		} else {
			listaArticulos = new ArrayList<>();
			
			listaArticulos.add(new Artículo(1, "Camiseta", "Estampados", 45, 10));
			listaArticulos.add(new Artículo(2, "Pantalón", "Vaqueros", 60, 15));
			listaArticulos.add(new Artículo(3, "Vestidos", "Flores", 50, 20));
		}
	}

	private static void exportarAArchivoCSV() {
		System.out.println("\n------ Exportar artículos a archivo CSV ------");

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOMBRE_CSV))) {
			
			writer.write("ID,Nombre,Descripción,Stock,Precio");
			writer.newLine();
		
			for (Artículo articulo : listaArticulos) {
				writer.write(String.format("%d,%s,%s,%d,%.2f", articulo.getId(), articulo.getNombre(),
						articulo.getDescripcion(), articulo.getStock(), articulo.getPrecio()));
				writer.newLine();
			}
			System.out.println("Artículos exportados correctamente a " + NOMBRE_CSV);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void mostrarMenu() {
		System.out.println("\n============= Menú ===================");
		System.out.println("1. Añadir nuevo artículo");
		System.out.println("2. Borrar artículo por id");
		System.out.println("3. Consultar artículo por id");
		System.out.println("4. Listado de todos los artículos");
		System.out.println("5. Exportar artículos a archivo CSV");
		System.out.println("6. Terminar el programa");
	}

	private static void agregarArticulo() {
	    System.out.println("\n======== Añadir nuevo artículo ========");

	    
	    System.out.print("Ingrese el ID del artículo: ");
	    int nuevoId = scanner.nextInt();
	    
	
	    if (existeIdEnLista(nuevoId)) {
	        System.out.println("Error: El ID del artículo ya existe. No se puede duplicar.");
	        return;
	    }

	    scanner.nextLine(); 

	    System.out.print("Ingrese el nombre del artículo: ");
	    String nombre = scanner.nextLine();

	    System.out.print("Ingrese la descripción del artículo: ");
	    String descripcion = scanner.nextLine();

	    System.out.print("Ingrese el stock del artículo: ");
	    int stock = scanner.nextInt();

	    System.out.print("Ingrese el precio del artículo: ");
	    double precio = scanner.nextDouble();

	 
	    Artículo nuevoArticulo = new Artículo(nuevoId, nombre, descripcion, stock, precio);
	    listaArticulos.add(nuevoArticulo);

	    System.out.println("Artículo agregado correctamente.");
	}
	
	private static boolean existeIdEnLista(int id) {
	    for (Artículo articulo : listaArticulos) {
	        if (articulo.getId() == id) {
	            return true; 
	        }
	    }
	    return false; 
	}
	

	private static void borrarArticulo() {
		System.out.println("\n=======Borrar artículo por id ============");

		
		System.out.print("Ingrese el ID del artículo a borrar: ");
		int idABorrar = scanner.nextInt();

		
		boolean encontrado = false;
		for (Artículo articulo : listaArticulos) {
			if (articulo.getId() == idABorrar) {
				listaArticulos.remove(articulo);
				encontrado = true;
				System.out.println("Artículo borrado con éxito.");
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ningún artículo con ese ID.");
		}
	}

	private static void consultarArticulo() {
		System.out.println("\n========= Consultar artículo por id =========");

	
		System.out.print("Ingrese el ID del artículo a consultar: ");
		int idAConsultar = scanner.nextInt();

		
		boolean encontrado = false;
		for (Artículo articulo : listaArticulos) {
			if (articulo.getId() == idAConsultar) {
				System.out.println("Detalles del artículo:");
				System.out.println(articulo);
				encontrado = true;
				break;
			}
		}

		if (!encontrado) {
			System.out.println("No se encontró ningún artículo con ese ID.");
		}
	}

	private static void listarArticulos() {
		System.out.println("\n======== Listado de todos los artículos ========");

	
		if (listaArticulos.isEmpty()) {
			System.out.println("No hay artículos para mostrar.");
		} else {
			for (Artículo articulo : listaArticulos) {
				System.out.println(articulo);
			}
		}
	}

	private static void terminarPrograma() {
		EscrituraListaArtículos.guardarArticulosEnArchivo(listaArticulos);
		System.out.println("Programa terminado. Artículos guardados en " + NOMBRE_FICHERO);
	}
}