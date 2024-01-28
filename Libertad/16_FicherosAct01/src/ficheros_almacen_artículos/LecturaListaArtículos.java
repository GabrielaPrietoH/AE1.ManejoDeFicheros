
package ficheros_almacen_artículos;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ArrayList;

public class LecturaListaArtículos {

    public static List<Artículo> cargarArticulosDesdeArchivo(File file) {
        List<Artículo> listaArticulo = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            Object obj = ois.readObject();
            if (obj instanceof List<?>) {
                listaArticulo = (List<Artículo>) obj;
                System.out.println("Objetos leídos desde el archivo: " + file.getName());
            } else {
                System.out.println("Error al leer el archivo. Tipo de objeto no esperado.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return listaArticulo;
    }
}