package Modelo;
public abstract class Revision{
    protected int numero;
    protected String fecha;
    protected double horasDuracion;
    protected int tarifaBase;


    //Constructor
    public Revision(int numero, String fecha, double horasDuracion, int tarifaBase) {
        this.numero = numero;
        this.fecha = fecha;
        this.horasDuracion = horasDuracion;
        this.tarifaBase = tarifaBase;
    }
        
    //Getters & Setters
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public double getHorasDuracion() {
        return horasDuracion;
    }
    public void setHorasDuracion(double horasDuracion) {
        this.horasDuracion = horasDuracion;
    }
    public int getTarifaBase() {
        return tarifaBase;
    }
    public void setTarifaBase(int tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    //ToString
    @Override
    public String toString() {
        return "Revision [numero=" + numero + ", fecha=" + fecha + ", horasDuracion=" + horasDuracion + ", tarifaBase="
                + tarifaBase + "]";
    }

    //TODO: public abstract dobuble CalcularCostro();
}