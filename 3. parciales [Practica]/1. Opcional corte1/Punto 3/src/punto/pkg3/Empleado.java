package punto.pkg3;


public class Empleado {
    String nombre, cedula;
    String rango;
    String salario;

    //Rango (Enum interno)
    public enum Rango{
        Novato, Experto, Veterano;
    }
    //Constructor
    public Empleado(String nombre, String cedula, String string2, String string) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.rango = string2;
        this.salario = string;
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
    public String getRango() {
        return rango;
    }
    public void setRango(String rango) {
        this.rango = rango;
    }
    public String getSalario() {
        return salario;
    }
    public void setSalario(String salario) {
        this.salario = salario;
    }
}
