import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.StringTokenizer;

public class Archivo {

    public void prueba() {

        try {
            File archivito = new File("materias.txt");
            FileReader lector = new FileReader(archivito);
            BufferedReader buffer = new BufferedReader(lector);
            String linea = "";
            System.out.println(archivito.getAbsolutePath());
            System.out.println(archivito.canRead());
            System.out.println(archivito.exists());
            System.out.println(archivito.length());
            while ((linea = buffer.readLine()) != null) {
                System.out.println(linea);
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String buscarTraduccion(String palabraBuscar, String idioma) {
        String traduccion = "No se encuentra la traduccion";

        try {
            RandomAccessFile archivo = new RandomAccessFile("traduccion.txt", "r");
            String linea = "";
            while ((linea = archivo.readLine()) != null) {
                StringTokenizer tokens = new StringTokenizer(linea, "#");
                String spanish = tokens.nextToken();
                if (spanish.equals(palabraBuscar)) {
                    if (idioma.equals("ingles")) {
                        traduccion = tokens.nextToken();
                    } else if (idioma.equals("frances")) {
                        tokens.nextToken();
                        traduccion = tokens.nextToken();
                    }

                }
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return traduccion;
    }

    public void insertarPalabra(String nuevaPalabra) {

        try {
            RandomAccessFile archivo = new RandomAccessFile("traduccion.txt", "rw");
            archivo.seek(archivo.length());
            archivo.writeBytes("\n" + nuevaPalabra);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
