import java.io.RandomAccessFile;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VideoJuego {
    private Genero genero;
    private String nombre;
    private static int costoAlquilar;
    private static int costoComprar;

    public enum Genero {
        Accion, Plataformas, Shooter;
    }

    // ======================= Constructor
    // =================================================
    public VideoJuego(String nombre, VideoJuego.Genero genero) {
        this.nombre = nombre;
        this.genero = genero;

        LeerPreciosArchivo();
    }
    // ======================= Constructor
    // =================================================

    // ======================= Leer Archivos
    // =================================================
    /*
     * 
     * Nota: Los costos deben tener la siguiente sintaxis:
     * <costoAlquilar>#<costoComprar>
     * Donde <costoAlquilar> y <costoComprar> son enteros
     */
    public void LeerPreciosArchivo() {

        try {
            try (RandomAccessFile archivo = new RandomAccessFile("costo_Videouego.txt", "r")) {
                String linea = "";
                while ((linea = archivo.readLine()) != null) {
                    StringTokenizer tokens = new StringTokenizer(linea, "#");
                    // Guardando los precios en el array arrPrecios
                    VideoJuego.costoAlquilar = Integer.parseInt(tokens.nextToken());
                    VideoJuego.costoComprar = Integer.parseInt(tokens.nextToken());

                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ======================= Leer Archivos
    // =================================================
    // ======================= Setters, getters & toString()
    // =================================================
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static int getCostoAlquilar() {
        return costoAlquilar;
    }

    public static void setCostoAlquilar(int costoAlquilar) {
        VideoJuego.costoAlquilar = costoAlquilar;
    }

    public static int getCostoComprar() {
        return costoComprar;
    }

    public static void setCostoComprar(int costoComprar) {
        VideoJuego.costoComprar = costoComprar;
    }

    @Override
    public String toString() {
        return "(+->) Nombre: " + getNombre() + " | Genero: " + getGenero() + "\n";
    }
    // ======================= Setters, getters & toString()
    // =================================================
}