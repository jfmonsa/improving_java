public class profNombrado extends Profesor{
    Categorias categoria;
    String fecha_nombramiento;

    //Construc
    public profNombrado(String nombre, String cedula,Categorias categoria,
            String fecha_nombramiento) {
        super(nombre, cedula);
        this.categoria = categoria;
        this.fecha_nombramiento = fecha_nombramiento;
    } 

    //Setters y getters
    public Categorias getCategoria() {
        return categoria;
    }
    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }
    public String getFecha_nombramiento() {
        return fecha_nombramiento;
    }
    public void setFecha_nombramiento(String fecha_nombramiento) {
        this.fecha_nombramiento = fecha_nombramiento;
    } 
}
