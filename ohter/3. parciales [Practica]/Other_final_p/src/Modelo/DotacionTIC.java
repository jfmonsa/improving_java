package Modelo;
import java.util.LinkedList;

public class DotacionTIC{
    private int numero;
    private String nombre;
    private String fechaAdquisicion;
    private EspacioFisico suUbicacion;
    private LinkedList<Revision> susRevisiones;
    
    //Constructor    
    public DotacionTIC(int numero, String nombre, String fechaAdquisicion, EspacioFisico suUbicacion,
            LinkedList<Revision> susRevisiones) {
        this.numero = numero;
        this.nombre = nombre;
        this.fechaAdquisicion = fechaAdquisicion;
        this.suUbicacion = suUbicacion;
        this.susRevisiones = susRevisiones;
    }

    //Getters and setters
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

    public String getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(String fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public EspacioFisico getSuUbicacion() {
        return suUbicacion;
    }

    public void setSuUbicacion(EspacioFisico suUbicacion) {
        this.suUbicacion = suUbicacion;
    }

    public LinkedList<Revision> getSusRevisiones() {
        return susRevisiones;
    }

    public void setSusRevisiones(LinkedList<Revision> susRevisiones) {
        this.susRevisiones = susRevisiones;
    }
    //+ calcularCostoTotalRevisiones() : double

    //toString
    @Override
    public String toString() {
        return "DotacionTIC [numero=" + numero + ", nombre=" + nombre + ", fechaAdquisicion=" + fechaAdquisicion
                + ", suUbicacion=" + suUbicacion + ", susRevisiones=" + susRevisiones + "]";
    }

}
