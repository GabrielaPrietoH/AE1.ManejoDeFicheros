package ficheros_almacen_artículos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class EscrituraListaArtículos {

    public static final String NOMBRE_FICHERO = "articulos.dat";

    public static void guardarArticulosEnArchivo(List<Artículo> listaArticulos) {
        File file = new File(NOMBRE_FICHERO);

        try (FileOutputStream fos = new FileOutputStream(file);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(listaArticulos);
            System.out.println("Objetos guardados en el archivo: " + NOMBRE_FICHERO);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
