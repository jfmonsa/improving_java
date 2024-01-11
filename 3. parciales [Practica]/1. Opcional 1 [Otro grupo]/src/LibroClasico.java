public class LibroClasico extends Libro{
    private String año_publicacion;

    public LibroClasico(String nombre, String autor, int costo, String año_publicacion) {
        super(nombre, autor, costo);
        this.año_publicacion = año_publicacion;
    }

    public String getAño_publicacion() {
        return año_publicacion;
    }
    public void setAño_publicacion(String año_publicacion) {
        this.año_publicacion = año_publicacion;
    }

    
}
