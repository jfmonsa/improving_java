public enum Marca {
    LG, Samsumg, Asus, HP, Custom, AlienWare;    
}

public enum Materiales {
    cobre, Chips, tarjeta, transistor, procesador;
}


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


public class HomeApplianceExcerciseTest {
    public static void main(String[] args) throws Exception {

        Materiales[] listaMateriales = Materiales.values(); //Convertir array en una lista de strings

        Computador pc1 = new Computador(110.5f , 2000000,listaMateriales, Marca.Asus, 3.2f, 19);
        Computador pc2 = new Computador(105.5f , 1300000,listaMateriales, Marca.HP, 3.2f, 19);
        Computador pc3 = new Computador(240.5f , 4740000,listaMateriales, Marca.AlienWare, 3.2f, 19);

        Lavadora l1 = new Lavadora(540f,2500000,listaMateriales, 3.4f, true);
        Lavadora l2 = new Lavadora(400f,2500000,listaMateriales, 5f, false);
        Lavadora l3 = new Lavadora(600f,4000000,listaMateriales, 7.4f, true);

        Electrodomestico[] aparatos = {pc1, pc2, pc3, l1, l2, l3};

        int precioContador=0;
        for(Electrodomestico obj: aparatos){
            precioContador+=obj.getPrecio();
        }
        System.out.println("El valor total de los 6 electordomesticos (3 computadores y 3 lavadoras) es: "+precioContador);
    }
}
