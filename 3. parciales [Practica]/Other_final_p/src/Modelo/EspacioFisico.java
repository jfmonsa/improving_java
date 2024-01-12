package Modelo;
public class EspacioFisico {
    private int numero;
    private String nombre;
    private int capacidadPersonas;
    private double area;

    //Constructor
    public EspacioFisico(int numero, String nombre, int capacidadPersonas, double area) {
        this.numero = numero;
        this.nombre = nombre;
        this.capacidadPersonas = capacidadPersonas;
        this.area = area;
    }

    //Getters & Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidadPersonas() {
        return capacidadPersonas;
    }

    public void setCapacidadPersonas(int capacidadPersonas) {
        this.capacidadPersonas = capacidadPersonas;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    //To String
    @Override
    public String toString() {
        return "EspacioFisico [numero=" + numero + ", nombre=" + nombre + ", capacidadPersonas=" + capacidadPersonas
                + ", area=" + area + "]";
    }
    
}