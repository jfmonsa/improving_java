public class Libro{
    private String nombre;
    private int fecha_publicacion;
    private String editorial;
    private String [] autores;
    
    public Libro(String nombre, int fecha_publicacion, String editorial, String[] autores) {
        this.nombre = nombre;
        this.fecha_publicacion = fecha_publicacion;
        this.editorial = editorial;
        this.autores = autores;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(int fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
    public String getEditorial() {
        return editorial;
    }
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String[] getAutores() {
        return autores;
    }
    public void setAutores(String[] autores) {
        this.autores = autores;
    }

    

}