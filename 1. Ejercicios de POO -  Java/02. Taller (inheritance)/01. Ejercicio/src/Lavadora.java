public class Lavadora extends Electrodomestico {
    private float tamañoLitros;
    private boolean tieneSecadora;

    
    public Lavadora(float voltaje, int precio, Materiales[] materiales, float tamañoLitros, boolean tieneSecadora) {
        super(voltaje, precio, materiales);
        this.tamañoLitros = tamañoLitros;
        this.tieneSecadora = tieneSecadora;
    }


    public float getTamañoLitros() {
        return tamañoLitros;
    }
    public void setTamañoLitros(float tamañoLitros) {
        this.tamañoLitros = tamañoLitros;
    }
    public boolean istieneSecadora() {
        return tieneSecadora;
    }
    public void settieneSecadora(boolean tieneSecadora) {
        this.tieneSecadora = tieneSecadora;
    }

    
}
