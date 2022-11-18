public class Electrodomestico{
    private float voltaje;
    private int precio;
    private Materiales[] materiales;
    
    public Electrodomestico(float voltaje2, int precio, Materiales[] materiales) {
        this.voltaje = voltaje2;
        this.precio = precio;
        this.materiales = materiales;
    }

    //Setters & getters
    public float getVoltaje() {
        return voltaje;
    }
    public void setVoltaje(float voltaje) {
        this.voltaje = voltaje;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Materiales[] getMateriales() {
        return materiales;
    }
    public void setMateriales(Materiales[] materiales) {
        this.materiales = materiales;
    }   
}