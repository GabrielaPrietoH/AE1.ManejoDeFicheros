package es.cristian.modelo.entidad;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CSVExport {
	
	public void toCSV(String fileName, ArrayList<Articulo> listaArticulos){
		
		try(FileWriter fW = new FileWriter(fileName);
				PrintWriter pW = new PrintWriter(fW)){
			
			//Escribe la cabecera. Aquí y en el artículo, la separación por ";" 
			//es necesaria para que lo abra correctamente.
			pW.println("ID;Nombre;Descripción;Stock;Precio");
			
			//Escribe los datos de cada artículo recibido por param en el CSV
			for(Articulo art: listaArticulos) {
				String data = String.format("%d;%s;%s;%.2f;%.2f",
						art.getId(),
						art.getNombre().replace(";", ","),
						art.getDescripcion().replace(";", ","),
						art.getStock(),
						art.getPrecio());
				
				pW.println(data);
						
			}
			System.out.println("Archivo CSV " + fileName + " ha sido creado correctamente.");
			
		} catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el archivo: " + e.getMessage());
        }
		
	}

}
