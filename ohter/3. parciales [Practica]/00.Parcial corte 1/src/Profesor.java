public abstract class Profesor {
    String nombre, cedula;
    //Const
    public Profesor(String nombre, String cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }
    //Profesor generico
    public Profesor(){
    }

    //Setters & getters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
