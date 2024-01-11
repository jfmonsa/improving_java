public class Computador extends Electrodomestico {
    private Marca marca;
    private float velocidadProcesador;
    private float pulgdas;

    public Computador(float voltaje, int precio, Materiales[] materiales, Marca marca, float velocidadProcesador,
            float pulgdas) {
        super(voltaje, precio, materiales); //atributos heredados
        this.marca = marca;
        this.velocidadProcesador = velocidadProcesador;
        this.pulgdas = pulgdas;
    }


    public Marca getMarca() {
        return marca;
    }
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    public float getVelocidadProcesador() {
        return velocidadProcesador;
    }
    public void setVelocidadProcesador(float velocidadProcesador) {
        this.velocidadProcesador = velocidadProcesador;
    }
    public float getPulgdas() {
        return pulgdas;
    }
    public void setPulgdas(float pulgdas) {
        this.pulgdas = pulgdas;
    }

    
}
