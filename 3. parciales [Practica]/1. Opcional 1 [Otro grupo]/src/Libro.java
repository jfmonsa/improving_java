public abstract class Libro {
    private int id = this.hashCode(); //Unique id
    private String nombre;
    private String autor;
    private int costo;
    
    public Libro(String nombre, String autor, int costo) {
        this.nombre = nombre;
        this.autor = autor;
        this.costo = costo;
    }

    //Setters and getters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }  
}
